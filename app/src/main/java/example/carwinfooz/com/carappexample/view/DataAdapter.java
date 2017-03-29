package example.carwinfooz.com.carappexample.view;

/**
 * Created by PoisonSniper on 3/28/17.
 */


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import example.carwinfooz.com.carappexample.R;
import example.carwinfooz.com.carappexample.controller.CustomVolleyRequest;
import example.carwinfooz.com.carappexample.model.CarModel;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<CarModel> carsData;
    private Context context;

    public DataAdapter(Context context, ArrayList<CarModel> data) {
        this.carsData = data;
        this.context = context;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cars_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DataAdapter.ViewHolder viewHolder, int i) {
        /********  set data on carslist **********/
        viewHolder.tv_seller_name.setText(carsData.get(i).getSeller());
        viewHolder.tv_condition.setText(carsData.get(i).getCondition() + " / ");
        viewHolder.tv_model.setText(carsData.get(i).getModel());
        viewHolder.tv_price.setText(carsData.get(i).getPrice());
        imagLoader(viewHolder.iv_car, carsData.get(i).getThumbnail());
        imagLoader(viewHolder.iv_maker, carsData.get(i).getMaker());

    }

    @Override
    public int getItemCount() {
        return carsData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tv_seller_name, tv_condition, tv_price, tv_model;
        private ImageView iv_car, iv_maker;

        public ViewHolder(View view) {
            super(view);

            iv_car = (ImageView) view.findViewById(R.id.iv_car);
            iv_maker = (CircleImageView) view.findViewById(R.id.iv_maker);
            tv_seller_name = (TextView) view.findViewById(R.id.tv_seller_name);
            tv_condition = (TextView) view.findViewById(R.id.tv_condition);
            tv_price = (TextView) view.findViewById(R.id.tv_price);
            tv_model = (TextView) view.findViewById(R.id.tv_model);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("DetailsData", carsData.get(getAdapterPosition()));
            context.startActivity(intent);
        }
    }

    private void imagLoader(final ImageView iv, String imgURL) {
        ImageLoader imageLoader = CustomVolleyRequest.getInstance(context)
                .getImageLoader();
        imageLoader.get(imgURL, ImageLoader.getImageListener(iv,
                R.drawable.loading, android.R.drawable
                        .ic_dialog_alert));


    }

}
