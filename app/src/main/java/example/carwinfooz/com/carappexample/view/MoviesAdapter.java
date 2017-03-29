package example.carwinfooz.com.carappexample.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;

import java.util.List;

import example.carwinfooz.com.carappexample.R;
import example.carwinfooz.com.carappexample.controller.CustomVolleyRequest;
import example.carwinfooz.com.carappexample.model.MovieModel;
import example.carwinfooz.com.carappexample.rest.ApiClient;

/**
 * Created by PoisonSniper on 3/29/17.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<MovieModel> movies;
    private int rowLayout;
    private Context context;


    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView data;
        TextView movieDescription;
        TextView rating;
        ImageView iv_movie;

        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            movieTitle = (TextView) v.findViewById(R.id.title);
            data = (TextView) v.findViewById(R.id.subtitle);
            movieDescription = (TextView) v.findViewById(R.id.description);
            rating = (TextView) v.findViewById(R.id.rating);
            iv_movie = (ImageView) v.findViewById(R.id.iv_movie);
        }
    }

    public MoviesAdapter(List<MovieModel> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public MoviesAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MovieViewHolder viewHolder, final int position) {
        /********  set data on movies list **********/
        viewHolder.movieTitle.setText(movies.get(position).getTitle());
        viewHolder.data.setText(movies.get(position).getReleaseDate());
        viewHolder.movieDescription.setText(movies.get(position).getOverview());
        viewHolder.rating.setText(movies.get(position).getVoteAverage().toString());
        imagLoader(viewHolder.iv_movie, ApiClient.IMG_URL + movies.get(position).getPosterPath());

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    private void imagLoader(final ImageView iv, String imgURL) {
        ImageLoader imageLoader = CustomVolleyRequest.getInstance(context)
                .getImageLoader();
        imageLoader.get(imgURL, ImageLoader.getImageListener(iv,
                R.drawable.loading, android.R.drawable
                        .ic_dialog_alert));


    }
}