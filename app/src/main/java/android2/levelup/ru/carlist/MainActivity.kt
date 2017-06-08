package android2.levelup.ru.carlist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View

import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager

import java.util.ArrayList

import android2.levelup.ru.carlist.Adapter.CarAdapter
import android2.levelup.ru.carlist.Entity.Car
import android2.levelup.ru.carlist.Entity.CarList
import android2.levelup.ru.carlist.Listener.OnListItemClickListener
import android2.levelup.ru.carlist.RetrofitUtils.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private val adapter: CarAdapter? = null
    private val carList: CarList? = null
    private val cars: ArrayList<Car>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view) as RecyclerView
        recyclerView!!.layoutManager = LinearLayoutManager(this)


        loadCars()

    }

    private fun loadCars() {


        val retrofit = Retrofit.Builder()
                .baseUrl("https://goo.gl")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val api = retrofit.create(Api::class.java)
        api.cars.enqueue(object : retrofit2.Callback<CarList> {
            override fun onResponse(call: retrofit2.Call<CarList>, response: retrofit2.Response<CarList>) {
                if (response.isSuccessful) {
                    val carsResponse = response.body()
                    val imageRequestManager = Glide.with(this@MainActivity)
                    recyclerView!!.adapter = CarAdapter(carsResponse!!.cars, imageRequestManager, OnListItemClickListener { v, position -> })
                }
            }

            override fun onFailure(call: retrofit2.Call<CarList>, t: Throwable) {
                Log.w(TAG, "Failed to load cars", t)
            }
        })


    }

    companion object {
        internal val TAG = "MyLog"
    }

}




