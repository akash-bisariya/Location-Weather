package app.android.com.weatherapplication.interfaces;

/**
 * Created by akash on 27/10/17.
 */

public interface IWeatherCallbackListener<T> {
    <Y> void getWeatherData(Y weatherModel, Boolean success, String errorMsg);
}
