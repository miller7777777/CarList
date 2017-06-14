package android2.levelup.ru.carlist.db

import android.provider.BaseColumns


class CarsDBContract {

    class CarsTable {

        companion object {
            const val TABLE_NAME = "cars"

            const val COLUMN_ID = BaseColumns._ID
            const val COLUMN_NAME = "name"
            const val COLUMN_IMAGE = "image"
            const val COLUMN_VIN = "vin"
        }

    }
}