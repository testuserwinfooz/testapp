package example.carwinfooz.com.carappexample.rest;

import example.carwinfooz.com.carappexample.model.MoviesResponseModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by PoisonSniper on 3/29/17.
 */

public interface ApiInterface {
    @GET("movie/top_rated")
    Call<MoviesResponseModel> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<MoviesResponseModel> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}


