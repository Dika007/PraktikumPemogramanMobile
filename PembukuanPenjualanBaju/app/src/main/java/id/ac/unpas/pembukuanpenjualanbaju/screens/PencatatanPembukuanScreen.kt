package id.ac.unpas.pembukuanpenjualanbaju.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.room.Room
import id.ac.unpas.pembukuanpenjualanbaju.model.PembukuanPenjualanBaju
import id.ac.unpas.pembukuanpenjualanbaju.persistences.AppDatabase
import id.ac.unpas.pembukuanpenjualanbaju.persistences.PembukuanPenjualanBajuDao
import kotlinx.coroutines.flow.MutableStateFlow

/* Dika Sulaeman Akbar 203040163*/
/* Tugas fungsi callback*/
@Composable
fun PencatatanPembukuanScreen() {
    val context = LocalContext.current
    val db = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "pengelolaan-sampah"
    ).build()
    val PembukuanPenjualanBajuDao = db.PembukuanPenjualanBajuDao()

    val list : LiveData<List<PembukuanPenjualanBaju>> = PembukuanPenjualanBajuDao.loadAll()
    val items: List<PembukuanPenjualanBaju> by list.observeAsState(initial = listOf())
    Column(modifier = Modifier.fillMaxWidth()) {
        FormPencatatanPembukuan(PembukuanPenjualanBajuDao)




        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(items = items, itemContent = { item ->
                Row(modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()) {
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Tanggal", fontSize = 14.sp)
                        Text(text = item.tanggal, fontSize = 16.sp,
                            fontWeight = FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "nama", fontSize = 14.sp)
                        Text(text = item.namapencatat, fontSize = 16.sp, fontWeight =
                        FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "jumlah", fontSize = 14.sp)
                        Text(text = item.jumlahbajuyangterjual, fontSize = 16.sp, fontWeight =
                        FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Keterangan", fontSize = 14.sp)
                        Text(text = item.keterangan, fontSize = 16.sp, fontWeight =
                        FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Pemasukan", fontSize = 14.sp)
                        Text(text = "RP. ${item.pemasukan}", fontSize = 16.sp,
                            fontWeight = FontWeight.Bold)
                    }

                }
                Divider(modifier = Modifier.fillMaxWidth())
            })
        }
    }
}