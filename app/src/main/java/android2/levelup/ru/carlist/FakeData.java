package android2.levelup.ru.carlist;


import java.util.ArrayList;
import java.util.UUID;

import android2.levelup.ru.carlist.Entity.Car;

public class FakeData {


    public static ArrayList<Car> getData() {

        ArrayList<Car> carList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            Car car = new Car("BMW " + i
                    , "ImageUrl " + UUID.randomUUID().toString().substring(0, 9)
                    , "Vin " + UUID.randomUUID().toString().substring(0, 9)
            );

        }


        return carList;
    }
}
