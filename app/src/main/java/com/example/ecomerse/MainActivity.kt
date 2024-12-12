package com.example.ecomerse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                AppScreen()
            }
        }
    }
}

@Composable
fun AppScreen() {
    var isLoggedIn by remember { mutableStateOf(false) }

    if (isLoggedIn) {
        ProductPage(onLogout = { isLoggedIn = false })
    } else {
        LoginPage(onLogin = { isLoggedIn = true })
    }
}

@Composable
fun LoginPage(onLogin: () -> Unit) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Login Page", modifier = Modifier.padding(bottom = 16.dp))

        // Username TextField
        TextField(
            value = username,
            onValueChange = { username = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            label = { Text("Username") }
        )

        // Password TextField
        TextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            visualTransformation = PasswordVisualTransformation(),
            label = { Text("Password") }
        )

        // Login Button
        Button(
            onClick = { onLogin() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }
    }
}

@Composable
fun ProductPage(onLogout: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // Product Image Placeholder
        Text(text = "Product Image", modifier = Modifier.padding(bottom = 16.dp))  // Placeholder for the image

        // Product Name
        Text(text = "Sample Product", modifier = Modifier.padding(bottom = 8.dp))

        // Product Price
        Text(text = "$99.99", modifier = Modifier.padding(bottom = 16.dp))

        // Add to Cart Button
        Button(
            onClick = { /* Handle Add to Cart functionality */ },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        ) {
            Text("Add to Cart")
        }

        // Logout Button
        Button(
            onClick = { onLogout() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Logout")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MaterialTheme {
        AppScreen() // Preview the main screen
    }
}
