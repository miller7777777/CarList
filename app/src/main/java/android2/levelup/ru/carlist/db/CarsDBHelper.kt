package android2.levelup.ru.carlist.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android2.levelup.ru.carlist.db.CarsDBContract.CarsTable


class CarsDBHelper(context: Context): SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {

        //create cars table
        db.execSQL("CREATE TABLE ${CarsTable.TABLE_NAME}(" +
        "${CarsTable.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
        "${CarsTable.COLUMN_NAME} TEXT, " +
        "${CarsTable.COLUMN_IMAGE} TEXT, " +
        "${CarsTable.COLUMN_VIN} TEXT)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }

    private companion object{
        const val DB_NAME = "cars.db"
        const val DB_VERSION = 1
    }
}