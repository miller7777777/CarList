package android2.levelup.ru.carlist.Adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import android2.levelup.ru.carlist.Entity.Car;
import android2.levelup.ru.carlist.R;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView carImage;
        TextView carName;
        TextView carVin;

        public ViewHolder(View itemView) {
            super(itemView);
            carImage = (ImageView) itemView.findViewById(R.id.car_image);
            carName = (TextView) itemView.findViewById(R.id.car_name);
            carVin = (TextView) itemView.findViewById(R.id.car_vin);
        }
    }
}
