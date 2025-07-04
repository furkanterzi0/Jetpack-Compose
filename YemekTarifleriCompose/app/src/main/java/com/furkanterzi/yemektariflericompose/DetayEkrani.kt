package com.furkanterzi.yemektariflericompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.furkanterzi.yemektariflericompose.model.Yemek
import com.furkanterzi.yemektariflericompose.ui.theme.YemekTarifleriComposeTheme

@Composable
fun DetayEkranı(yemek : Yemek){

    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center
        ){
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Text(yemek.isim,
                    style = MaterialTheme.typography.displayLarge,
                    modifier = Modifier.padding(5.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                    )
                Image(bitmap = ImageBitmap.imageResource(id = yemek.gorsel),
                    contentDescription = yemek.isim, modifier = Modifier
                        .padding(16.dp)
                        .size(300.dp,200.dp)
                    )
                Text(yemek.malzemeler,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(2.dp),
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                )

            }
    }
}


@Preview(showBackground = true)
@Composable
fun DetayEkranıPreview() {
    YemekTarifleriComposeTheme {

        val pizza = Yemek("Pizza", "Hamur, Peynir, Sucuk", R.drawable.pizza)
        val makarna = Yemek("Makarna", "Penne, Domates, Fesleğen", R.drawable.makarna)
        val kofte = Yemek("Kofte", "Kıyma, Ekmek, Pirinç", R.drawable.kofte)
        val salata = Yemek("Salata", "Domates, Salatalık, Soğan", R.drawable.salata)
        val ekmek = Yemek("Ekmek", "Hamur, Maya", R.drawable.ekmek)



        DetayEkranı(makarna)
    }
}