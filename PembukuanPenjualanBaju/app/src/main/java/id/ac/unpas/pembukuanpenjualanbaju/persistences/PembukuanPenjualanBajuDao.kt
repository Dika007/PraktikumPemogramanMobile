package id.ac.unpas.pembukuanpenjualanbaju.persistences

import androidx.lifecycle.LiveData
import androidx.room.*
import id.ac.unpas.pembukuanpenjualanbaju.model.PembukuanPenjualanBaju

@Dao
interface PembukuanPenjualanBajuDao{
    @Query("SELECT * FROM PembukuanPenjualanBaju")
    fun loadAll(): LiveData<List<PembukuanPenjualanBaju>>
    @Query("SELECT * FROM PembukuanPenjualanBaju WHERE id = :id")
    fun find(id: String): PembukuanPenjualanBaju?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: PembukuanPenjualanBaju)
    @Delete
    fun delete(item: PembukuanPenjualanBaju)

    }
