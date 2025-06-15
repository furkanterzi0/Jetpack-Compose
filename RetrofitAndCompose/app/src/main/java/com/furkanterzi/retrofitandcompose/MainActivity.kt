package com.furkanterzi.retrofitandcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.furkanterzi.retrofitandcompose.ui.theme.RetrofitAndComposeTheme
import com.furkanterzi.retrofitandcompose.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RetrofitAndComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)){
                        UserListScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun UserListScreen(viewModel: UserViewModel = viewModel()) {
    val users by viewModel.userList.collectAsState()
    Box(){
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
        ) {
            items(users){ user ->
                Text(user.name, fontWeight = FontWeight.Bold)
                Spacer(Modifier.padding(1.dp))
                Text("Email: ${user.email}")
                Text("Web site: ${user.website}")
                Text("Phone number: ${user.phone}")
                Spacer(Modifier.padding(3.dp))

                HorizontalDivider(
                    thickness = 3.dp,
                    color = Color.Black
                )
            }
        }
    }

}

