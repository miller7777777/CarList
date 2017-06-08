package android2.levelup.ru.carlist.Adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.RequestManager

import java.util.ArrayList

import android2.levelup.ru.carlist.Entity.Car
import android2.levelup.ru.carlist.Listener.OnListItemClickListener
import android2.levelup.ru.carlist.R

class CarAdapter(private val cars: ArrayList<Car>, private val imageRequestManager: RequestManager, private val clickListener: OnListItemClickListener) : RecyclerView.Adapter<CarAdapter.ViewHolder>() {

    init {
        Log.d(TAG, "cars.size() = " + cars.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_car, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(cars[position])

    }


    override fun getItemCount(): Int {
        return cars.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        internal var carImage: ImageView
        internal var carName: TextView
        internal var carVin: TextView

        init {
            carImage = itemView.findViewById(R.id.car_image) as ImageView
            carName = itemView.findViewById(R.id.car_name) as TextView
            carVin = itemView.findViewById(R.id.car_vin) as TextView
            itemView.setOnClickListener(this)
        }

        fun bind(car: Car) {
            carName.text = car.name
            carVin.text = car.vin
            imageRequestManager.load(car.image).into(carImage)
        }


        override fun onClick(v: View) {
            clickListener.onClick(v, adapterPosition)
        }
    }

    companion object {

        internal val TAG = "MyLog"
    }
}
