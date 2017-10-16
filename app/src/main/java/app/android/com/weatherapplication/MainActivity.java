package app.android.com.weatherapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText etCityName;
    Button btnCityName;
    TextView tvWeather;
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
    HashMap<String,ArrayList<WeatherBean.Main>> tempListDateWise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        etCityName = (EditText) findViewById(R.id.et_city_name);
        btnCityName = (Button) findViewById(R.id.btn_get_weather);
        tvWeather = (TextView) findViewById(R.id.tv_info);
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okClient = new OkHttpClient.Builder()
                .connectTimeout(10000, TimeUnit.SECONDS)
                .readTimeout(10000, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .client(okClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final IWeatherApi weatherApi = retrofit.create(IWeatherApi.class);

        rvWeatherData.setLayoutManager(new LinearLayoutManager(this));
        btnCityName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Call<ResponseBody> resForgotPasswordCall = weatherApi.weatherData(etCityName.getText().toString());
                resForgotPasswordCall.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            if (response.body() != null) {
                                JSONObject jsonObject = new JSONObject(response.body().string());
                                tvWeather.setText(String.format("Current Temperature - " + jsonObject.getJSONObject("main").get("temp").toString()));

                                tvCountry.setText("Country - " + jsonObject.getJSONObject("sys").get("country").toString());
                                tvCity.setText("City - " + jsonObject.get("name").toString());


                                Glide.with(MainActivity.this)
                                        .load("http://openweathermap.org/img/w/" + (((JSONObject) jsonObject.getJSONArray("weather").get(0)).get("icon").toString()) + ".png")
                                        .into(ivWeatherIcon);


                            } else {
                                tvWeather.setText(response.errorBody().string());
                                tvCity.setText("");
                                tvCountry.setText("");
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        tvWeather.setText(t.toString());
                        tvCity.setText("");
                        tvCountry.setText("");
                    }
                });
            }
        });


        btnGet5DaysWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<WeatherBean> resForgotPasswordCall = weatherApi.weatherData5days(etCityName.getText().toString());
                resForgotPasswordCall.enqueue(new Callback<WeatherBean>() {
                    @Override
                    public void onResponse(Call<WeatherBean> call, Response<WeatherBean> response) {
                        if(response.body()!=null) {
                            ArrayList<WeatherBean.List> arrayList = new ArrayList<WeatherBean.List>();
                            for (int i = 0; i < response.body().getList().size(); i++) {
                                arrayList.add(response.body().getList().get(i));
                            }
                            try {
                                getMinMaxDateWise(arrayList);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            rvWeatherData.setAdapter(new RecyclerAdapter(MainActivity.this, tempListDateWise));
                        }
                        else {
                            try {
                                Toast.makeText(MainActivity.this,response.errorBody().string(),Toast.LENGTH_SHORT).show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<WeatherBean> call, Throwable t) {
                        Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }


    public String setDateFormat(String unformattedDate) throws ParseException {
        Date dateformat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(unformattedDate);
        return  (new SimpleDateFormat("yyyy-MM-dd")).format(dateformat);
    }

    private void getMinMaxDateWise(ArrayList<WeatherBean.List> arrayList) throws ParseException {
        int firstDay = arrayList.size()%8;
        ArrayList<Double> arrayListTemp;
        tempListDateWise = new HashMap<>();
        ArrayList<WeatherBean.Main> arrayList1 = new ArrayList<WeatherBean.Main>();
        ArrayList<WeatherBean.Main> arrayList2 = new ArrayList<WeatherBean.Main>();
        ArrayList<WeatherBean.Main> arrayList3 = new ArrayList<WeatherBean.Main>();
        ArrayList<WeatherBean.Main> arrayList4 = new ArrayList<WeatherBean.Main>();
        ArrayList<WeatherBean.Main> arrayList5 = new ArrayList<WeatherBean.Main>();
        String dateSecondDay="",dateFirstDay="",dateThirdDay="",dateFourthDay="",dateFiveDay="";
        for(int i=0;i<arrayList.size();i++)
        {
            arrayListTemp= new ArrayList<>();

            arrayListTemp.add(arrayList.get(i).getMain().getTemp());
            dateFirstDay  =setDateFormat(Calendar.getInstance().getTime().toString());

            String dateString = arrayList.get(i).getDtTxt();
            dateString = dateString.substring(0,dateString.indexOf(" "));


            Date dateformat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(Calendar.getInstance().getTime().toString());
            Calendar c = Calendar.getInstance();
            c.setTime(dateformat);
            c.add(Calendar.DATE,1);
            dateSecondDay=setDateFormat(c.getTime().toString());

            c.setTime(dateformat);
            c.add(Calendar.DATE,2);
            dateThirdDay=setDateFormat(c.getTime().toString());

            c.setTime(dateformat);
            c.add(Calendar.DATE,3);
            dateFourthDay=setDateFormat(c.getTime().toString());

            c.setTime(dateformat);
            c.add(Calendar.DATE,4);
            dateFiveDay=setDateFormat(c.getTime().toString());



            if(dateString.equals(dateFirstDay))
            {
                arrayList1.add(arrayList.get(i).getMain());
            }
            else if(dateString.equals(dateSecondDay))
            {
                arrayList2.add(arrayList.get(i).getMain());
            }
            else if(dateString.equals(dateThirdDay))
            {
                arrayList3.add(arrayList.get(i).getMain());
            }
            else if(dateString.equals(dateFourthDay))
            {
                arrayList4.add(arrayList.get(i).getMain());
            }
            else if(dateString.equals(dateFiveDay))
            {
                arrayList5.add(arrayList.get(i).getMain());
            }
        }
        Collections.sort(arrayList1, (t1, t2) -> (int)(t1.getTempMax()-t2.getTempMax()));
        Collections.sort(arrayList2, (t1, t2) -> (int)(t1.getTempMax()-t2.getTempMax()));
        Collections.sort(arrayList3, (t1, t2) -> (int)(t1.getTempMax()-t2.getTempMax()));
        Collections.sort(arrayList4, (t1, t2) -> (int)(t1.getTempMax()-t2.getTempMax()));
        Collections.sort(arrayList5, (t1, t2) -> (int)(t1.getTempMax()-t2.getTempMax()));


        tempListDateWise.put(dateFirstDay,arrayList1);
        tempListDateWise.put(dateSecondDay,arrayList2);
        tempListDateWise.put(dateThirdDay,arrayList3);
        tempListDateWise.put(dateFourthDay,arrayList4);
        tempListDateWise.put(dateFiveDay,arrayList5);









    }

//    public class Comparator extends java.util.Comparator<>

}
