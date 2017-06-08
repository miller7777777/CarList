package android2.levelup.ru.carlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import java.util.ArrayList;

import android2.levelup.ru.carlist.Adapter.CarAdapter;
import android2.levelup.ru.carlist.Entity.Car;
import android2.levelup.ru.carlist.Entity.CarList;
import android2.levelup.ru.carlist.Listener.OnListItemClickListener;
import android2.levelup.ru.carlist.RetrofitUtils.Api;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.security.AccessController.getContext;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CarAdapter adapter;
    final static String TAG = "MyLog";
    private CarList carList;

    //    private RequestManager imageRequestManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


//        final ArrayList<Car> cars = FakeData.getData();
//        final ArrayList<Car> cars = new RealData().getData();
        ArrayList<Car> cars = carList.getCars();

        Log.d(TAG + MainActivity.class.getSimpleName(), "cars.size() = " + cars.size());


        adapter = new CarAdapter(cars, new OnListItemClickListener() {
            @Override
            public void onClick(View v, int position) {
//                Toast.makeText(MainActivity.this, cars.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        loadCars();

    }

    private void loadCars() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://goo.gl")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        api.getCars().enqueue(new retrofit2.Callback<CarList>() {
            @Override
            public void onResponse(retrofit2.Call<CarList> call, retrofit2.Response<CarList> response) {
                if (response.isSuccessful()) {
                    CarList carsResponse = response.body();
//                    RequestManager imageRequestManager = Glide.with(getContext());
                    recyclerView.setAdapter(new CarAdapter(carsResponse.getCars(), null));
                }
            }

            @Override
            public void onFailure(retrofit2.Call<CarList> call, Throwable t) {
                Log.w(TAG, "Failed to load cars", t);
//                Toast.makeText(getContext(), "Failed connection", Toast.LENGTH_LONG).show();
            }
        });


    }

}




