package com.furkanterzi.yemektariflericompose
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.furkanterzi.yemektariflericompose.model.Yemek
import com.furkanterzi.yemektariflericompose.ui.theme.YemekTarifleriComposeTheme
import com.google.gson.Gson

@Composable
fun YemekListesi(yemekler : List<Yemek>, navController: NavController){
    LazyColumn(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.primaryContainer)) {
        items(yemekler){
            YemekRow(it, navController)
        }
    }
}

@Composable
fun YemekRow(yemek : Yemek, navController: NavController){
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(Color.White)
        .clickable {
            navController.navigate("detay_ekrani/${Gson().toJson(yemek)}")
        }
    ) {
        Text( text =  yemek.isim,
            style = MaterialTheme.typography.displayLarge,
            fontWeight = FontWeight.Bold
        )
        Text( text =  yemek.malzemeler,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
    }
}

