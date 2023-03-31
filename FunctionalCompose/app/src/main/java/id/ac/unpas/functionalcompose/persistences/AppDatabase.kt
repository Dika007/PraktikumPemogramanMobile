package id.ac.unpas.functionalcompose.persistences

import androidx.room.Database
import androidx.room.RoomDatabase
import id.ac.unpas.functionalcompose.model.SetoranSampah

/* Dika Sulaeman Akbar 203040163*/
@Database(entities = [SetoranSampah::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun SetoranSampahDao(): SetoranSampahDao
}
