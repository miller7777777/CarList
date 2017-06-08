package android2.levelup.ru.carlist.Adapter;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;

import java.util.ArrayList;

import android2.levelup.ru.carlist.Entity.Car;
import android2.levelup.ru.carlist.Listener.OnListItemClickListener;
import android2.levelup.ru.carlist.R;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {

    final static String TAG = "MyLog";

    private ArrayList<Car> cars;
    private OnListItemClickListener clickListener;
    private RequestManager imageRequestManager;
//    private RequestManager imageRequestManager;

    public CarAdapter(ArrayList<Car> cars, RequestManager imageRequestManager, OnListItemClickListener clickListener) {
        this.cars = cars;
        this.clickListener = clickListener;
        this.imageRequestManager = imageRequestManager;
        Log.d(TAG, "cars.size() = " + cars.size());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_car, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.bind(cars.get(position));

    }



    @Override
    public int getItemCount() {
        return cars.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView carImage;
        TextView carName;
        TextView carVin;

        public ViewHolder(View itemView) {
            super(itemView);
            carImage = (ImageView) itemView.findViewById(R.id.car_image);
            carName = (TextView) itemView.findViewById(R.id.car_name);
            carVin = (TextView) itemView.findViewById(R.id.car_vin);
            itemView.setOnClickListener(this);
        }

        public void bind(Car car) {
            carName.setText(car.getName());
            carVin.setText(car.getVin());
//            carImage.setImageResource(R.mipmap.ic_launcher);
            imageRequestManager.load(car.getImage()).into(carImage);
        }




        @Override
        public void onClick(View v) {
            clickListener.onClick(v, getAdapterPosition());
        }
    }
}
