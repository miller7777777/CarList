package android2.levelup.ru.carlist.Entity;

import java.util.ArrayList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CarList {

    @SerializedName("cars")
    @Expose
    private ArrayList<Car> cars;

    public CarList(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }



}
