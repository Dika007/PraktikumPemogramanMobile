package id.ac.unpas.pembukuanpenjualanbaju.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PembukuanPenjualanBaju(
    @PrimaryKey val id: String,
    val tanggal: String,
    val namapencatat: String,
    val jumlahbajuyangterjual: String,
    val keterangan: String,
    val pemasukan: String,

    )
