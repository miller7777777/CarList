package android2.levelup.ru.carlist.Entity

//Класс описывает сущность: машину


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Car(@SerializedName("name")
          @Expose
          var name: String?, @SerializedName("image")
          @Expose
          var image: String?, @SerializedName("vin")
          @Expose
          var vin: String?)
