package com.furkanterzi.statemanagementcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.furkanterzi.statemanagementcompose.ui.theme.StateManagementComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StateManagementComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)){
                        MainScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        val username = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }

        MyText("Login")
        Spacer(modifier = Modifier.padding(10.dp))

        TextField(
            value = username.value,
            onValueChange = { username.value = it },
            placeholder = { Text("Username") }
        )

        Spacer(modifier = Modifier.padding(10.dp))

        TextField(
            value = password.value,
            onValueChange = { password.value = it },
            placeholder = { Text("Password") }
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Button(onClick = {
            println(username.value)
            println(password.value)
        }) {
            Text("Login")
        }

    }

}

@Composable
fun MyTextField(str: String, onValueChangeFunction : (String)-> Unit){
    TextField(value = str,onValueChangeFunction,Modifier.padding(10.dp))
}

@Composable
fun MyText(str : String){
    Text(text = str,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
        )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StateManagementComposeTheme {
        MainScreen()
    }
}