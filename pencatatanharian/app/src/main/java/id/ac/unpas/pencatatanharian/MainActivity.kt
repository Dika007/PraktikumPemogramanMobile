package id.ac.unpas.pencatatanharian

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import id.ac.unpas.pencatatanharian.screens.PencatatanKeuanganScreen
import id.ac.unpas.pencatatanharian.ui.theme.PencatatanharianTheme


/* Dika Sulaeman Akbar 203040163*/
/* Tugas fungsi callback*/

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PencatatanharianTheme {
                // A surface container using the 'background' color from the theme
                theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PencatatanKeuanganScreen()
                }
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PencatatanharianTheme {
        PencatatanKeuanganScreen()
    }
}