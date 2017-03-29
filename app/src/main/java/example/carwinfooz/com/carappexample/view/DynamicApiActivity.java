package example.carwinfooz.com.carappexample.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import example.carwinfooz.com.carappexample.R;
import example.carwinfooz.com.carappexample.model.MovieModel;
import example.carwinfooz.com.carappexample.model.MoviesResponseModel;
import example.carwinfooz.com.carappexample.rest.ApiClient;
import example.carwinfooz.com.carappexample.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by PoisonSniper on 3/29/17.
 */

public class DynamicApiActivity extends Activity {
    private RecyclerView recyclerView;
    private ApiInterface apiService;
    private static final String TAG = MainActivity.class.getSimpleName();


    //add dev api_key
    private final static String API_KEY = "7e8f60e325cd06e164799af1e317d7a7";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        loadData();
    }

    /********
     * inital screen views on Details Screen
     **********/

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        apiService = ApiClient.getClient().create(ApiInterface.class);


    }

    /********
     * set data on Movies Screen
     **********/

    private void loadData() {
        //requesting api call
        Call<MoviesResponseModel> call = apiService.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<MoviesResponseModel>() {
            @Override
            public void onResponse(Call<MoviesResponseModel> call, Response<MoviesResponseModel> response) {
                int statusCode = response.code();
                List<MovieModel> movies = response.body().getResults();
                recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.movie_row, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<MoviesResponseModel> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }
}