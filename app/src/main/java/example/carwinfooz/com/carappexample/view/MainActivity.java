package example.carwinfooz.com.carappexample.view;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import example.carwinfooz.com.carappexample.R;
import example.carwinfooz.com.carappexample.controller.Controller;
import example.carwinfooz.com.carappexample.model.CarModel;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<CarModel> data;
    private DataAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    /********  create view elements - Start **********/

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadData();
    }
    /********  End view elements - Start **********/
    /******************  Create Dummy Items Data  ***********/
    private void loadData() {
        final Controller aController = (Controller) getApplicationContext();

        data = new ArrayList<>();
        //Create Dumy Objects with dummy data
        CarModel carObj1 = new CarModel();
        carObj1.setSeller("Asaad Al-Assad");
        carObj1.setCondition("USED");
        carObj1.setModel("Mercedes benz S class");
        carObj1.setMaker("https://febestparts.com/img/make/mercedes%20benz.png");
        carObj1.setPrice("437900 $");
        carObj1.setThumbnail("http://media.caranddriver.com/images/13q2/510832/2014-mercedes-benz-s-class-s550-first-drive-review-car-and-driver-photo-521692-s-450x274.jpg");
        carObj1.setLatitude(31.9518839);
        carObj1.setLongitude(35.8879535);
        ArrayList arrGallery1=new ArrayList();
        arrGallery1.add("https://media.ed.edmunds-media.com/mercedes-benz/s-class/2016/oem/2016_mercedes-benz_s-class_sedan_s550-plug-in-hybrid_fq_oem_3_1280.jpg");
        arrGallery1.add("https://i.ytimg.com/vi/UCz9_px6JRk/maxresdefault.jpg");
        arrGallery1.add("https://cars.usnews.com/static/images/Auto/izmo/i2344991/2017_mercedes_benz_s_class_angularfront.jpg");

        arrGallery1.add("https://s1.cdn.autoevolution.com/images/gallery/MERCEDES-BENZ-S-class--W222--4853_19.jpg");
        arrGallery1.add("http://i.auto-bild.de/ir_img/1/1/9/1/3/2/0/Mercedes-S-Klasse-Coup-1200x800-21496319bde6cd39.jpg");
        arrGallery1.add("http://s1.ibtimes.com/sites/www.ibtimes.com/files/styles/lg/public/2014/06/26/mercedes-benz-s-class.jpg");



        carObj1.setArrGallery(arrGallery1);

        CarModel carObj2 = new CarModel();
        carObj2.setSeller("Bisher Rasheed");
        carObj2.setCondition("New");
        carObj2.setModel("BMW 7 Series");
        carObj2.setMaker("http://orig15.deviantart.net/a6f3/f/2011/241/f/e/bmw_logo_256_png_by_mahesh69a-d48akz6.png");
        carObj2.setPrice("237900 $");
        carObj2.setThumbnail("http://media.caranddriver.com/images/15q2/657945/2016-bmw-7-series-photos-and-info-news-car-and-driver-photo-659442-s-450x274.jpg");
        carObj2.setLatitude(32.0192286);
        carObj2.setLongitude(35.994922);
        ArrayList arrGallery2=new ArrayList();
        arrGallery2.add("https://images.cdn.autocar.co.uk/sites/autocar.co.uk/files/styles/gallery_slide/public/images/car-reviews/first-drives/legacy/bmw-7-series-sdfer-018.jpg?itok=tPhp2Tc_.jpg");
        arrGallery2.add("https://i.ytimg.com/vi/UCz9_px6JRk/maxresdefault.jpg");
        arrGallery2.add("https://cars.usnews.com/static/images/Auto/izmo/i2344991/2017_mercedes_benz_s_class_angularfront.jpg");

        arrGallery2.add("http://cdn2.autoexpress.co.uk/sites/autoexpressuk/files/styles/article_main_image/public/6/06/bmw_730d-012_0_0.jpg?itok=TWbfKmfW");
        arrGallery2.add("http://uploads.haystak.com/seo/responsive_model_pages/2015_model_pages/bmw/7-Series/images/header.jpg");
        arrGallery2.add("https://res.cloudinary.com/carsguide/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_large/v1/editorial/bmw-7-series-2015-%282%29_0.jpg");

        carObj2.setArrGallery(arrGallery2);

        CarModel carObj3 = new CarModel();
        carObj3.setSeller("Samer Mansour");
        carObj3.setCondition("New");
        carObj3.setModel("GMC Sierra");
        carObj3.setMaker("http://www.autoglassquotez.com/make/images/gmc-emblem.png");
        carObj3.setPrice("879900 $");
        carObj3.setThumbnail("http://www.gmc.com/content/dam/GMC/global/master/nscwebsite/en/home/Vehicles/Current_Vehicles/2017_Sierra_1500/Model_Overview/01_images/2017-gmc-sierra-1500-mov-packages-mm1-lightbox-960x648-01.jpg");
        carObj3.setLatitude(31.9418674);
        carObj3.setLongitude(35.8867877);
        ArrayList arrGallery3=new ArrayList();
        arrGallery3.add("https://media.ed.edmunds-media.com/mercedes-benz/s-class/2016/oem/2016_mercedes-benz_s-class_sedan_s550-plug-in-hybrid_fq_oem_3_1280.jpg");
        arrGallery3.add("https://i.ytimg.com/vi/UCz9_px6JRk/maxresdefault.jpg");
        arrGallery3.add("https://cars.usnews.com/static/images/Auto/izmo/i2344991/2017_mercedes_benz_s_class_angularfront.jpg");
        carObj3.setArrGallery(arrGallery3);

        CarModel carObj4 = new CarModel();
        carObj4.setSeller("Asaad Al-Assad");
        carObj4.setCondition("USED");
        carObj4.setModel("Toyota LandCruzer");
        carObj4.setMaker("https://listcarbrands.com/wp-content/uploads/2015/10/logo-Toyota.png");
        carObj4.setPrice("437900 $");
        carObj4.setThumbnail("http://flykd.com/wp-content/uploads/2016/07/2017-toyota-land-cruiser-spy-photo.jpg");
        carObj4.setLatitude(31.9518839);
        carObj4.setLongitude(35.8879535);
        ArrayList arrGallery4=new ArrayList();
        arrGallery4.add("http://s3.caradvice.com.au/thumb/770/382/wp-content/uploads/2015/08/2016_toyota_landcruiser-200-series_sahara_official_02.jpg");
        arrGallery4.add("https://i.ytimg.com/vi/UCz9_px6JRk/maxresdefault.jpg");
        arrGallery4.add("http://bestcarmag.com/sites/default/files/72898622017-mitsubishi-montero-spy-shots--image-via-s-baldauf-sb-medien_100505933_l.jpg");

        arrGallery4.add("https://carreleasedates2017.com/wp-content/uploads/2016/05/2017-Toyota-Land-Cruiser-front-view.jpg");
        arrGallery4.add("https://carreleasedates2017.com/wp-content/uploads/2016/05/2017-Toyota-Land-Cruiser-front-view.jpg");
        arrGallery4.add("http://4.bp.blogspot.com/-jXRzL8jfsAg/VdGWEfzFupI/AAAAAAAA4v4/mzIAhNZP5vs/s1600/Toyota-Land-Cruiser-200-0.jpg");



        carObj4.setArrGallery(arrGallery4);

        CarModel carObj5 = new CarModel();
        carObj5.setSeller("Ahmad Hilmy");
        carObj5.setCondition("USED");
        carObj5.setModel("Peugeot Concept car");
        carObj5.setMaker("http://www.earlsfield-servicestation.co.uk/Images/Car%20Logos%20PNG%20256/Peugeot.png");
        carObj5.setPrice("237900 $");
        carObj5.setThumbnail("http://o.aolcdn.com/dims-shared/dims3/GLOB/legacy_thumbnail/800x450/format/jpg/quality/85/http://o.aolcdn.com/hss/storage/midas/87246b5dbef4744ffe36fb39ea379ad4/203644902/peugeot-onyx-concept.jpg");
        carObj5.setLatitude(32.0192286);
        carObj5.setLongitude(35.994922);
        ArrayList arrGallery5=new ArrayList();
        arrGallery5.add("https://images.cdn.autocar.co.uk/sites/autocar.co.uk/files/styles/gallery_slide/public/images/car-reviews/first-drives/legacy/bmw-7-series-sdfer-018.jpg?itok=tPhp2Tc_.jpg");
        arrGallery5.add("http://i.ndtvimg.com/i/2015-05/peugeot-vision-gt_650x310_61430990568.jpg");
        arrGallery5.add("https://cars.usnews.com/static/images/Auto/izmo/i2344991/2017_mercedes_benz_s_class_angularfront.jpg");

        arrGallery5.add("http://g02.a.alicdn.com/kf/HTB1tsRJIXXXXXaWXXXXq6xXFXXXY/1-18-Nowell-NOREV-supercar-mobil-konsep-Peugeot-ONYX-model-mobil.jpg");
        arrGallery5.add("https://carwallpaper.us/wp-content/uploads/2016/05/Amazing-peugeot-cars-Z16.jpg");
        arrGallery5.add("https://s-media-cache-ak0.pinimg.com/736x/4d/26/ed/4d26ed8a7b20a7b5597452df0a6c5640.jpg");

        carObj5.setArrGallery(arrGallery5);

        CarModel carObj6 = new CarModel();
        carObj6.setSeller("Samer Mansour");
        carObj6.setCondition("New");
        carObj6.setModel("GMC Sierra");
        carObj6.setMaker("http://www.autoglassquotez.com/make/images/gmc-emblem.png");
        carObj6.setPrice("879900 $");
        carObj6.setThumbnail("http://www.gmc.com/content/dam/GMC/global/master/nscwebsite/en/home/Vehicles/Current_Vehicles/2017_Sierra_1500/Model_Overview/01_images/2017-gmc-sierra-1500-mov-packages-mm1-lightbox-960x648-01.jpg");
        carObj6.setLatitude(31.9418674);
        carObj6.setLongitude(35.8867877);
        ArrayList arrGallery6=new ArrayList();
        arrGallery6.add("https://media.ed.edmunds-media.com/mercedes-benz/s-class/2016/oem/2016_mercedes-benz_s-class_sedan_s550-plug-in-hybrid_fq_oem_3_1280.jpg");
        arrGallery6.add("https://i.ytimg.com/vi/UCz9_px6JRk/maxresdefault.jpg");
        arrGallery6.add("https://cars.usnews.com/static/images/Auto/izmo/i2344991/2017_mercedes_benz_s_class_angularfront.jpg");
        carObj6.setArrGallery(arrGallery6);

        aController.setItems(carObj1);
        aController.setItems(carObj2);
        aController.setItems(carObj3);
        aController.setItems(carObj4);
        aController.setItems(carObj5);
        aController.setItems(carObj6);

        /******************  End Dummy Items Data  ***********/


        //preparing the adapter to display the fisrt page list
        adapter = new DataAdapter(this,aController.getAllData());
        recyclerView.setAdapter(adapter);
    }



}
