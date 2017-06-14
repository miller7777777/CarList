package android2.levelup.ru.carlist.db

import android.content.ContentValues
import android.database.Cursor
import android.provider.SyncStateContract.Helpers.insert
import android.provider.SyncStateContract.Helpers.update
import android.util.Log
import android2.levelup.ru.carlist.Entity.Car
import android2.levelup.ru.carlist.db.CarsDBContract.CarsTable


class CarsDatabase(val carsDBHelper: CarsDBHelper) {

    fun insertCars(cars: List<Car>) {
        val db = carsDBHelper.writableDatabase

        db.beginTransaction()

        cars.forEach { car ->
            val values = ContentValues().apply {
                put(CarsTable.COLUMN_NAME, car.name)
                put(CarsTable.COLUMN_IMAGE, car.image)
                put(CarsTable.COLUMN_VIN, car.vin)
            }

            db.insert(CarsTable.TABLE_NAME, null, values)

        }

        db.setTransactionSuccessful()
        db.endTransaction()


    }

    fun updateAllCars(cars: List<Car>) {
        val db = carsDBHelper.writableDatabase
        var cv = ContentValues()
        val carsExist = getCars()

        for (c: Car in cars) {

            if (!carsExist!!.contains(c)) {

                insert(c)

            }else{
                update(c)

            }

        }



    }

    fun getCars(): ArrayList<Car>? {

        val db = carsDBHelper.readableDatabase

        var carsFromBase = ArrayList<Car>()

        val selectQuery: String = CarsDBContract.CarsTable.TABLE_NAME
        val cursor: Cursor = db.query(selectQuery, null, null, null, null, null, null)

        if (cursor.moveToFirst()) {
            do {
                val car: Car = Car(
                        cursor.getString(cursor.getColumnIndex("name")),
                        cursor.getString(cursor.getColumnIndex("image")),
                        cursor.getString(cursor.getColumnIndex("vin"))
                )
                carsFromBase!!.add(car)
            } while (cursor.moveToNext())
        }
        cursor.close()





        return carsFromBase!!
    }

    fun insert(car: Car) {

        var db = carsDBHelper.writableDatabase

        val values = ContentValues().apply {
            put(CarsTable.COLUMN_NAME, car.name)
            put(CarsTable.COLUMN_IMAGE, car.image)
            put(CarsTable.COLUMN_VIN, car.vin)
        }

        db.beginTransaction()
        db.insert(CarsTable.TABLE_NAME, null, values)
        db.setTransactionSuccessful()
        db.endTransaction()
        Log.d("777", "Car " + car.name + " inserted")



    }

    fun update(car: Car){

        var db = carsDBHelper.writableDatabase
        val values = ContentValues().apply {
            put(CarsTable.COLUMN_NAME, car.name)
            put(CarsTable.COLUMN_IMAGE, car.image)
            put(CarsTable.COLUMN_VIN, car.vin)
        }

        db.beginTransaction()
        db.update(CarsTable.TABLE_NAME, values, "name = ?", Array(1, {car.name}))
        db.setTransactionSuccessful()
        db.endTransaction()
        Log.d("777", "Car " + car.name + " updated")


    }

    fun delete(car: Car){

        var db = carsDBHelper.writableDatabase

        db.beginTransaction()
        db.delete(CarsTable.TABLE_NAME, "name = ?", Array(1, {car.name}))
        db.setTransactionSuccessful()
        db.endTransaction()


    }
}