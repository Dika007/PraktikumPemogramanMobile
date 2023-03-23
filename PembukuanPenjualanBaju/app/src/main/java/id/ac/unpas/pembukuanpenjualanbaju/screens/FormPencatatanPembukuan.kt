package id.ac.unpas.pembukuanpenjualanbaju.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import android.widget.Toast
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.benasher44.uuid.uuid4
import id.ac.unpas. pembukuanpenjualanbaju.model.PembukuanPenjualanBaju
import id.ac.unpas.pembukuanpenjualanbaju.persistences.PembukuanPenjualanBajuDao
import id.ac.unpas. pembukuanpenjualanbaju.ui.theme.Purple700
import id.ac.unpas. pembukuanpenjualanbaju.ui.theme.Teal200
import kotlinx.coroutines.launch

/* Dika Sulaeman Akbar 203040163*/
/* Tugas fungsi callback*/
@Composable
fun FormPencatatanPembukuan(PembukuanPenjualanBajuDao: PembukuanPenjualanBajuDao) {
    val tanggal = remember { mutableStateOf(TextFieldValue("")) }
    val namapencatat = remember { mutableStateOf(TextFieldValue("")) }
    val jumlahbajuyangterjual = remember { mutableStateOf(TextFieldValue("")) }
    val keterangan = remember { mutableStateOf(TextFieldValue("")) }
    val pemasukan = remember { mutableStateOf(TextFieldValue("")) }
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()) {
        OutlinedTextField(
            label = { Text(text = "Tanggal") },
            value = tanggal.value,
            onValueChange = {
                tanggal.value = it
            },
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            placeholder = { Text(text = "yyyy-mm-dd") }
        )
        OutlinedTextField(
            label = { Text(text = "nama") },
            value = namapencatat.value,
            onValueChange = {
                namapencatat.value = it
            },
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization =
            KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
            placeholder = { Text(text = ".............") }
        )
        OutlinedTextField(
            label = { Text(text = "jumlah") },
            value = jumlahbajuyangterjual.value,
            onValueChange = {
                jumlahbajuyangterjual.value = it
            },
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization =
            KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
            placeholder = { Text(text = ".............") }
        )
        OutlinedTextField(
            label = { Text(text = "Keterangan") },
            value = keterangan.value,
            onValueChange = {
                keterangan.value = it
            },
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization =
            KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
            placeholder = { Text(text = ".............") }
        )
        OutlinedTextField(
            label = { Text(text = "Pemasukan") },
            value = pemasukan.value,
            onValueChange = {
                pemasukan.value = it
            },
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType =
            KeyboardType.Decimal),
            placeholder = { Text(text = "RP. ") }
        )

        val loginButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Purple700,
            contentColor = Teal200
        )
        val resetButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Teal200,
            contentColor = Purple700
        )
        Row (modifier = Modifier.padding(4.dp).fillMaxWidth()) {
            Button(modifier = Modifier.weight(5f), onClick = {
                val id = uuid4().toString()
                val item = PembukuanPenjualanBaju(id,tanggal.value.text,namapencatat.value.text,jumlahbajuyangterjual.value.text,keterangan.value.text,pemasukan.value.text,)
                scope.launch {
                    PembukuanPenjualanBajuDao.insertAll(item)
                }
                if (tanggal.value.text.isEmpty()){
                    Toast.makeText(context,"tanggal harus di isi", Toast.LENGTH_SHORT).show()
                    return@Button
                }



                if (namapencatat.value.text.isEmpty()){
                    Toast.makeText(context,"nama harus di isi", Toast.LENGTH_SHORT).show()
                    return@Button
                }

                if (jumlahbajuyangterjual.value.text.isEmpty()){
                    Toast.makeText(context,"jumlah harus di isi", Toast.LENGTH_SHORT).show()
                    return@Button
                }

                if (keterangan.value.text.isEmpty()){
                    Toast.makeText(context,"keterangan harus di isi", Toast.LENGTH_SHORT).show()
                    return@Button
                }

                if (pemasukan.value.text.isEmpty()){
                    Toast.makeText(context,"Pemasukan atau pengeluaran harus di isi", Toast.LENGTH_SHORT).show()
                    return@Button
                }
                tanggal.value = TextFieldValue("")
                namapencatat.value = TextFieldValue("")
                jumlahbajuyangterjual.value = TextFieldValue("")
                keterangan.value = TextFieldValue("")
                pemasukan.value = TextFieldValue("")

            }, colors = loginButtonColors) {
                Text(
                    text = "Simpan",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
            Button(modifier = Modifier.weight(5f), onClick = {
                tanggal.value = TextFieldValue("")
                namapencatat.value = TextFieldValue("")
                jumlahbajuyangterjual.value = TextFieldValue("")
                keterangan.value = TextFieldValue("")
                pemasukan.value = TextFieldValue("")

            }, colors = resetButtonColors) {
                Text(
                    text = "Reset",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}