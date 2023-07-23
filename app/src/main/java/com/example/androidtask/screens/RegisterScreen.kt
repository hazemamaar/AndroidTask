package com.example.androidtask.screens

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidtask.R
import com.example.androidtask.composable.AuthenticationHeader
import com.example.androidtask.composable.AuthenticationTextField
import com.example.androidtask.composable.LabelledCheckbox
import com.example.androidtask.ui.theme.blue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
) {
    var isValidEmail by remember { mutableStateOf(true) }
    var email by remember { mutableStateOf("") }
    var isValidPhoneNumber by remember { mutableStateOf(true) }
    var phoneNumber by remember { mutableStateOf("") }
    var isValidPassword by remember { mutableStateOf(true) }
    var password by remember { mutableStateOf("") }

    var city by remember { mutableStateOf("") }
    var isValidCity by remember { mutableStateOf(true) }

    var checkState by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 30.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.arrow_left),
                contentDescription = "arrow"
            )
            Spacer(modifier = Modifier.width(110.dp))
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "icon")
        }
        Spacer(modifier = Modifier.height(30.dp))

        AuthenticationHeader(
            title = "Sign Up",
            subTitle = "Create your personal profile.com and follow"
        )
        Spacer(modifier = Modifier.height(14.dp))

        AuthenticationTextField(
            valueText = phoneNumber,
            nameTextField = "Phone Number",
            label = { Text(text = "Phone Number") }, isValid = isValidPhoneNumber
        ) {
            phoneNumber = it
        }

        Spacer(modifier = Modifier.height(14.dp))

        AuthenticationTextField(
            valueText = email,
            nameTextField = "Email",
            label = { Text(text = "Email") }, isValid = isValidEmail
        ) {
            email = it
//            isValidEmail = email.isEmpty() || Patterns.EMAIL_ADDRESS.matcher(it).matches()
        }

        Spacer(modifier = Modifier.height(14.dp))

        AuthenticationTextField(
            valueText = city,
            nameTextField = "City",
            label = { Text(text = "City") }, isValid = isValidCity
        ) {
            city = it
        }

        Spacer(modifier = Modifier.height(14.dp))

        AuthenticationTextField(
            valueText = password,
            nameTextField = "Password",
            label = { Text(text = "Password") }, isValid = isValidPassword
        ) {
            password = it
        }
        LabelledCheckbox()

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRegisterScreen() {
    RegisterScreen()
}