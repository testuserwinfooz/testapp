package example.carwinfooz.com.carappexample.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by PoisonSniper on 3/29/17.
 */

public class ApiClient {
    //define api constance
    public static final String BASE_URL = "http://api.themoviedb.org/3/";
    public static final String IMG_URL = "https://image.tmdb.org/t/p/w500/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}