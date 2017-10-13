package app.android.com.weatherapplication;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by akash on 10/10/17.
 */

public interface IWeatherApi {
    @GET("weather?appid=b317aca2e83ad16e219ff2283ca837d5&type=accurate&units=metric")
    Call<ResponseBody> weatherData(@Query("q") String query);

    @GET("forecast?appid=b317aca2e83ad16e219ff2283ca837d5&type=accurate&units=metric")
    Call<WeatherBean> weatherData5days(@Query("q") String query);
}
