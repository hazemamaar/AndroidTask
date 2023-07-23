package com.example.androidtask.ui.screens

import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidtask.R
import com.example.androidtask.ui.composable.AuthenticationHeader
import com.example.androidtask.ui.composable.AuthenticationTextField
import com.example.androidtask.ui.composable.LabelledCheckbox
import com.example.androidtask.ui.theme.Blue
import com.example.androidtask.ui.theme.Gray
import com.example.androidtask.ui.theme.inter

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

    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 30.dp)
            .verticalScroll(scrollState)

    ) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
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
            isValidPhoneNumber = phoneNumber.length==11
        }

        Spacer(modifier = Modifier.height(14.dp))

        AuthenticationTextField(
            valueText = email,
            nameTextField = "Email",
            label = { Text(text = "Email") }, isValid = isValidEmail
        ) {
            email = it
            isValidEmail = Patterns.EMAIL_ADDRESS.matcher(email).matches()

        }

        Spacer(modifier = Modifier.height(14.dp))

        AuthenticationTextField(
            valueText = city,
            nameTextField = "City",
            label = { Text(text = "City") }, isValid = isValidCity
        ) {

            city = it
            isValidCity = city.isNotEmpty()
        }

        Spacer(modifier = Modifier.height(14.dp))

        AuthenticationTextField(
            valueText = password,
            nameTextField = "Password",
            label = { Text(text = "Password") }, isValid = isValidPassword
        ) {
            password = it
            isValidPassword = password.length >= 8
        }
        LabelledCheckbox(onCheckedChange = {
            checkState=it
        }, checked = checkState)
        Spacer(modifier = Modifier.height(15.dp))

        Column(modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(horizontal = 30.dp)){
            Button(onClick = {
             if (isValidCity&&isValidEmail&&isValidPassword&&isValidPhoneNumber&&checkState){
                 Log.e("hazem", "RegisterScreen: Task Done", )
             }
            }, modifier = Modifier
                .fillMaxWidth()
                .height(42.dp),colors = ButtonDefaults.buttonColors(containerColor = Blue, contentColor = Color.White), shape = RoundedCornerShape(15.dp)
            ) {
                Text(text = "Sign Up", fontSize = 18.sp,)
            }
            Spacer(modifier = Modifier.height(15.dp))
            Text(textAlign = TextAlign.Center, modifier = Modifier.align(alignment = Alignment.CenterHorizontally),text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Gray)) {
                    append("Already have an account? ")
                }
                withStyle(style = SpanStyle(color = Blue, textDecoration = TextDecoration.Underline)) {
                    append("Login")
                }
            }, fontFamily = inter, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }

    }

}

@Preview(showBackground = true)
@Composable
fun PreviewRegisterScreen() {
    RegisterScreen()
}