package id.ac.unpas.pembukuanpenjualanbaju.persistences

import androidx.room.Database
import androidx.room.RoomDatabase
import id.ac.unpas.pembukuanpenjualanbaju.model.PembukuanPenjualanBaju

@Database(entities = [PembukuanPenjualanBaju::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun PembukuanPenjualanBajuDao(): PembukuanPenjualanBajuDao
}
