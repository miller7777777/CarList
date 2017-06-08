package android2.levelup.ru.carlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.RequestManager;

import java.util.ArrayList;

import android2.levelup.ru.carlist.Adapter.CarAdapter;
import android2.levelup.ru.carlist.Entity.Car;
import android2.levelup.ru.carlist.Listener.OnListItemClickListener;



public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CarAdapter adapter;
    final static String TAG = "MyLog";
//    private RequestManager imageRequestManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



//        final ArrayList<Car> cars = FakeData.getData();
        final ArrayList<Car> cars = new RealData().getData();
        Log.d(TAG + MainActivity.class.getSimpleName(), "cars.size() = " + cars.size());



        adapter = new CarAdapter(cars, new OnListItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                Toast.makeText(MainActivity.this, cars.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);

    }


}
