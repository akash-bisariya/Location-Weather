package app.android.com.weatherapplication.interfaces;

import java.util.List;

import app.android.com.weatherapplication.models.LocationSearchModel;
import app.android.com.weatherapplication.models.AccuWeather5DayModel;
import app.android.com.weatherapplication.models.AccuWeatherModel;
import app.android.com.weatherapplication.models.OpenWeatherModel;
import app.android.com.weatherapplication.models.OpenWeather5DayModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by akash on 10/10/17.
 */

public interface IWeatherApi {
    @GET("weather?type=accurate&units=metric")
    Call<OpenWeatherModel> getOpenWeatherData(@Query("appid") String appId, @Query("q") String query);

    @GET("forecast?type=accurate&units=metric")
    Call<OpenWeather5DayModel> getOpenWeatherData5days(@Query("appid") String appId, @Query("q") String query);

    @GET("forecasts/v1/daily/5day/{key}?metric=true")
    Call<AccuWeather5DayModel> getAccuWeatherData5days(@Path("key") String cityKey, @Query("apikey") String appId);

    @GET("currentconditions/v1/{key}")
    Call<List<AccuWeatherModel>> getAccuWeatherData(@Path("key") String cityKey, @Query("apikey") String appId);

    @GET("locations/v1/cities/autocomplete")
    Call<List<LocationSearchModel>> getAccuWeatherCities(@Query("apikey") String appId,@Query("q") String query);
}
