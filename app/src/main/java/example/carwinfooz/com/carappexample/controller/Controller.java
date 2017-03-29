package example.carwinfooz.com.carappexample.controller;

import android.app.Application;

import java.util.ArrayList;

import example.carwinfooz.com.carappexample.model.CarModel;

/**
 * Created by PoisonSniper on 3/29/17.
 */

public class Controller extends Application {

    private ArrayList<CarModel> myItems = new ArrayList<CarModel>();
    private CarModel myBasket = new CarModel();


    public CarModel getItems(int position) {

        return myItems.get(position);
    }

    public void setItems(CarModel Items) {

        myItems.add(Items);

    }

    public ArrayList<CarModel> getAllData() {

        return myItems;

    }

    public void clearItems() {
        myItems.clear();
    }

    public int getItemsArraylistSize() {

        return myItems.size();
    }

}