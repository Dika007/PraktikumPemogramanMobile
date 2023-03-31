package id.ac.unpas.functionalcompose.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import id.ac.unpas.functionalcompose.model.SetoranSampah
import id.ac.unpas.functionalcompose.persistences.SetoranSampahDao
import javax.inject.Inject

/* Dika Sulaeman Akbar 203040163*/
@HiltViewModel
class PengelolaanSampahViewModel @Inject constructor(private val
                                                     setoranSampahDao: SetoranSampahDao) : ViewModel(){
    val list : LiveData<List<SetoranSampah>> = setoranSampahDao.loadAll()
    suspend fun insert(id: String,
                       tanggal: String,
                       nama: String,
                       berat: String){
        val item = SetoranSampah(id, tanggal, nama, berat)
        setoranSampahDao.insertAll(item)
    }
}