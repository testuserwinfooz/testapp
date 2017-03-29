package example.carwinfooz.com.carappexample.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

import java.util.List;

import example.carwinfooz.com.carappexample.R;
import example.carwinfooz.com.carappexample.controller.CustomVolleyRequest;

/**
 * Created by PoisonSniper on 3/29/17.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.MyViewHolder> {

    private final Context detailsActivity;
    private List<String> horizontalList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_gallery;
        private Context detailsActivity;

        public MyViewHolder(View view) {
            super(view);
            iv_gallery = (ImageView) view.findViewById(R.id.iv_gallery);

        }
    }


    public GalleryAdapter(Context detailsActivity, List<String> horizontalList) {
        this.horizontalList = horizontalList;
        this.detailsActivity=detailsActivity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gallery_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        imagLoader(holder.iv_gallery, horizontalList.get(position));


    }

    @Override
    public int getItemCount() {
        return horizontalList.size();
    }

    private void imagLoader(final ImageView iv, String imgURL) {
        ImageLoader imageLoader = CustomVolleyRequest.getInstance(detailsActivity)
                .getImageLoader();
        imageLoader.get(imgURL, ImageLoader.getImageListener(iv,
                R.drawable.loading, android.R.drawable
                        .ic_dialog_alert));

    }
}