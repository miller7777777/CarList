package android2.levelup.ru.carlist;


import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import android2.levelup.ru.carlist.Entity.Car;
import android2.levelup.ru.carlist.Entity.CarList;
import android2.levelup.ru.carlist.RetrofitUtils.Api;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;
import static java.security.AccessController.getContext;

public class RealData {

    Retrofit retrofit;
    Api api;
    CarList carList;



    public  ArrayList<Car> getData() {




        retrofit = new Retrofit.Builder()
                .baseUrl("https://goo.gl")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(Api.class);

        api.getCars().enqueue(new retrofit2.Callback<CarList>() {
            @Override
            public void onResponse(Call<CarList> call, Response<CarList> response) {
                carList = response.body();
                Log.d(TAG, "Что-то получили: " + carList.toString());
            }

            @Override
            public void onFailure(Call<CarList> call, Throwable t) {

                Log.w(TAG, "Failed to load cars", t);
            }

        });

        return carList.getCars();
    }
}
