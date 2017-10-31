package app.android.com.weatherapplication.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by akash on 25/10/17.
 */

public class ApiService {
    public static Retrofit getRetrofitInstance(String baseUrl)
    {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okClient = new OkHttpClient.Builder()
                .connectTimeout(10000, TimeUnit.SECONDS)
                .readTimeout(10000, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();

        return  new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
