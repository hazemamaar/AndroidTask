package com.example.androidtask.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.androidtask.ui.theme.Black_25
import com.example.androidtask.ui.theme.Black_50
import com.example.androidtask.ui.theme.inter

@Composable
fun AuthenticationHeader(
    title: String,
    subTitle: String
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = title,
            fontFamily = inter,
            color = Black_50,
            fontSize = 37.sp,
            fontWeight = FontWeight.Normal
        )
        Text(
            text = subTitle,
            fontFamily = inter,
            color = Black_25,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        )

    }
}

@Preview(backgroundColor = 0xFFFCFCFC, showBackground = true)
@Composable
fun previewHeader() {
    AuthenticationHeader(title = "SignIn", subTitle = "Enter Your Password Please")
}
