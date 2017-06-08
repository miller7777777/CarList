package android2.levelup.ru.carlist


import java.util.ArrayList
import java.util.UUID

import android2.levelup.ru.carlist.Entity.Car

object FakeData {


    val data: ArrayList<Car>
        get() {

            val carList = ArrayList<Car>()

            for (i in 0..99) {

                val car = Car(
                        "BMW " + i,
                        "ImageUrl " + UUID.randomUUID().toString().substring(0, 9),
                        "Vin " + UUID.randomUUID().toString().substring(0, 30)
                )

                carList.add(car)

            }


            return carList
        }
}
