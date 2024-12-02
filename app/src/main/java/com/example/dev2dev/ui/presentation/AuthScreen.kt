package com.example.dev2dev.ui.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AuthScreen(authViewModel: AuthViewModel) {

    var logIn by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(25.dp)
    ) {
        TextField(
            value = logIn,
            onValueChange = {
                logIn = it
            },
            label = { Text(text = "Введите Логин") },
            placeholder = { Text(text = "...") },
            modifier = Modifier.padding(4.dp)
        )

        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = { Text(text = "Введите Пароль") },
            placeholder = { Text(text = "...") },
            modifier = Modifier.padding(4.dp)
        )

        Button(
            onClick = {
                authViewModel.singUp(logIn , password)
                      } ,
            Modifier.fillMaxWidth())
        {

            Text(text = "register")
            
        }

        TextField(
            value = logIn,
            onValueChange = {
                logIn = it
            },
            label = { Text(text = "Введите Логин") },
            placeholder = { Text(text = "...") },
            modifier = Modifier.padding(4.dp)
        )

        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = { Text(text = "Введите Пароль") },
            placeholder = { Text(text = "...") },
            modifier = Modifier.padding(4.dp)
        )

        Button(
            onClick = {
                authViewModel.singIn(logIn , password)
            } ,
            Modifier.fillMaxWidth())
        {

            Text(text = "login")

        }

    }


}