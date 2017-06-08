package android2.levelup.ru.carlist.Entity

import java.util.ArrayList
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CarList(@SerializedName("cars")
              @Expose
              val cars: ArrayList<Car>)
