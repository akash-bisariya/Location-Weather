package app.android.com.weatherapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.ParseException;

import app.android.com.weatherapplication.adapters.AutoCompleteAdapter;
import app.android.com.weatherapplication.adapters.RecyclerAdapter;
import app.android.com.weatherapplication.adapters.RecyclerAdapterAccuWeather;
import app.android.com.weatherapplication.interfaces.IWeatherCallbackListener;
import app.android.com.weatherapplication.models.AccuWeather5DayModel;
import app.android.com.weatherapplication.models.AccuWeatherModel;
import app.android.com.weatherapplication.models.LocationSearchModel;
import app.android.com.weatherapplication.models.OpenWeather5DayModel;
import app.android.com.weatherapplication.models.OpenWeatherModel;
import app.android.com.weatherapplication.utils.WeatherConditions;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IWeatherCallbackListener {

    @BindView(R.id.tv_city)
    TextView tvCity;
    @BindView(R.id.tv_country)
    TextView tvCountry;
    @BindView(R.id.btn_get_5_days_weather)
    Button btnGet5DaysWeather;
    @BindView(R.id.iv_weather_icon)
    ImageView ivWeatherIcon;
    @BindView(R.id.rv_weather_data)
    RecyclerView rvWeatherData;
    @BindView(R.id.et_city_name)
    AutoCompleteTextView etCityName;
    @BindView(R.id.btn_get_weather)
    Button btnGetCurrentWeather;

    String OPEN_WEATHER_APP_ID = "b317aca2e83ad16e219ff2283ca837d5";
    String ACCU_WEATHER_APP_ID = "87ad516d1d4842838fcfebe843d933b1";

    LocationSearchModel mLocationSearchModel;
    @BindView(R.id.tv_info)
    TextView tvWeather;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        etCityName.setThreshold(2);
        etCityName.setAdapter(new AutoCompleteAdapter(MainActivity.this, ACCU_WEATHER_APP_ID));

        rvWeatherData.setLayoutManager(new LinearLayoutManager(this));

        btnGetCurrentWeather.setOnClickListener(view -> WeatherConditions.getOpenWeatherData(etCityName.getText().toString(), OPEN_WEATHER_APP_ID, MainActivity.this));

        btnGet5DaysWeather.setOnClickListener(view -> WeatherConditions.getOpenWeatherData5Days(etCityName.getText().toString(), OPEN_WEATHER_APP_ID, MainActivity.this));

        etCityName.setOnItemClickListener((adapterView, view, i, l) -> {

            mLocationSearchModel = (LocationSearchModel) adapterView.getAdapter().getItem(i);

            etCityName.setText(mLocationSearchModel.getLocalizedName());

            WeatherConditions.getAccuWeatherData(mLocationSearchModel.getKey(), ACCU_WEATHER_APP_ID, MainActivity.this, true);

            WeatherConditions.getAccuWeatherData5Days(mLocationSearchModel.getKey(), ACCU_WEATHER_APP_ID, MainActivity.this, true);

        });

    }


    @Override
    public void getWeatherData(Object weatherModel, Boolean success, String errorMsg) {
        if (success) {
            if (weatherModel instanceof OpenWeatherModel) {

                OpenWeatherModel openWeatherModel = (OpenWeatherModel) weatherModel;
                tvCountry.setText("Country -- " + openWeatherModel.getSys().getCountry());
                tvCity.setText("City -- " + openWeatherModel.getName());
                tvWeather.setText("Temperature -- " + String.valueOf(openWeatherModel.getMain().getTemp()));
                Glide.with(MainActivity.this)
                        .load("http://openweathermap.org/img/w/" + openWeatherModel.getWeather().get(0).getIcon() + ".png")
                        .into(ivWeatherIcon);

            } else if (weatherModel instanceof OpenWeather5DayModel) {

                OpenWeather5DayModel weatherBean = (OpenWeather5DayModel) weatherModel;
                try {
                    rvWeatherData.setAdapter(new RecyclerAdapter(MainActivity.this, weatherBean.getMinMaxTemp()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            } else if (weatherModel instanceof AccuWeatherModel) {

                AccuWeatherModel accuWeatherModel = (AccuWeatherModel) weatherModel;
                tvWeather.setText("Current Temperature - " + String.valueOf(accuWeatherModel.getTemperature().getMetric().getValue()));
                tvCity.setText("City - " + mLocationSearchModel.getLocalizedName());
                tvCountry.setText("Country - " + mLocationSearchModel.getCountry().getLocalizedName());

                Glide.with(MainActivity.this)
                        .load("http://apidev.accuweather.com/developers/Media/Default/WeatherIcons/" + String.format("%02d", accuWeatherModel.getWeatherIcon()) + "-s" + ".png")
                        .into(ivWeatherIcon);

            } else if (weatherModel instanceof AccuWeather5DayModel) {

                AccuWeather5DayModel accuWeather5DayModel = (AccuWeather5DayModel) weatherModel;
                rvWeatherData.setAdapter(new RecyclerAdapterAccuWeather(MainActivity.this, accuWeather5DayModel));

            }
        }
    }
}
