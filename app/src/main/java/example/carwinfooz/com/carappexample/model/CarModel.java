package example.carwinfooz.com.carappexample.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

import static android.R.attr.thumbnail;

/**
 * Created by PoisonSniper on 3/28/17.
 */

public class CarModel implements Parcelable{

    private String thumbnail;
    private String maker;
    private String model;
    private String price;
    private String condition;
    private String seller;
    private ArrayList arrGallery;
    private double latitude;
    private double longitude;


    public CarModel(Parcel in) {
        thumbnail = in.readString();
        maker = in.readString();
        model = in.readString();
        price = in.readString();
        condition = in.readString();
        seller = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
        arrGallery = in.readArrayList(null);

    }

    public static final Creator<CarModel> CREATOR = new Creator<CarModel>() {
        @Override
        public CarModel createFromParcel(Parcel in) {
            return new CarModel(in);
        }

        @Override
        public CarModel[] newArray(int size) {
            return new CarModel[size];
        }
    };

    public CarModel() {

    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public ArrayList getArrGallery() {
        return arrGallery;
    }

    public void setArrGallery(ArrayList arrGallery) {
        this.arrGallery = arrGallery;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(thumbnail);
        dest.writeString(maker);
        dest.writeString(model);
        dest.writeString(price);
        dest.writeString(condition);
        dest.writeString(seller);
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
        dest.writeList(arrGallery);


    }
}
