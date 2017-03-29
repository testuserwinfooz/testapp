package example.carwinfooz.com.carappexample.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import de.hdodenhof.circleimageview.CircleImageView;
import example.carwinfooz.com.carappexample.R;
import example.carwinfooz.com.carappexample.model.CarModel;

/**
 * Created by PoisonSniper on 3/29/17.
 */

public class DetailsActivity extends Activity implements OnMapReadyCallback {
    private GalleryAdapter horizontalAdapter;
    private RecyclerView horizontal_recycler_view;
    private CircleImageView iv_maker;
    private TextView tv_seller_name, tv_condition, tv_price, tv_model;
    private CarModel detailOBJ;
    private  MapFragment mapFragment;
    private Button btn_buy,bt_dynamic;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initViews();
        loadData();
    }
    /********  inital screen views on Details Screen **********/

    private void initViews() {
        detailOBJ = getIntent().getExtras().getParcelable("DetailsData");

        horizontal_recycler_view= (RecyclerView) findViewById(R.id.horizontal_recycler_view);
        tv_seller_name = (TextView) findViewById(R.id.tv_seller_name);
        tv_condition = (TextView) findViewById(R.id.tv_condition);
        tv_price = (TextView) findViewById(R.id.tv_price);
        tv_model = (TextView) findViewById(R.id.tv_model);
        btn_buy = (Button) findViewById(R.id.bt_buy);
        bt_dynamic= (Button) findViewById(R.id.bt_dynamic);
         mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);

        /********  Adding listeners on buy and dynamic buttons **********/

        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setData(Uri.parse("sms:"));

                sendIntent.putExtra("sms_body", detailOBJ.getModel()+" "+detailOBJ.getPrice());

                startActivity(sendIntent);
            }
        });

        bt_dynamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DynamicApiActivity.class);
                context.startActivity(intent);
            }
        });



    }
    /********  set data on Details Screen **********/

    private void loadData(){

        context=this;
        horizontalAdapter=new GalleryAdapter(this,detailOBJ.getArrGallery());

        horizontal_recycler_view.setAdapter(horizontalAdapter);

        tv_seller_name.setText(detailOBJ.getSeller());
        tv_condition.setText(detailOBJ.getCondition());
        tv_model.setText(detailOBJ.getModel());
        tv_price.setText(detailOBJ.getPrice());

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        /********  set marker on the map when the map is ready **********/

        MarkerOptions marker = new MarkerOptions().position(new LatLng(detailOBJ.getLatitude(), detailOBJ.getLongitude())).title("Hello Maps ");
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(detailOBJ.getLatitude(), detailOBJ.getLongitude()),15));
        // Zoom in, animating the camera.
        googleMap.animateCamera(CameraUpdateFactory.zoomIn());
        // Zoom out to zoom level 10, animating with a duration of 2 seconds.
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
        googleMap.addMarker(marker);



    }
}
