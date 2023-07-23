package com.example.androidtask.ui.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidtask.ui.theme.Blue
import com.example.androidtask.ui.theme.inter
import com.example.androidtask.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthenticationTextField(
    modifier: Modifier = Modifier,
    isValid: Boolean,
    valueText: String,
    nameTextField: String,
    label: @Composable (() -> Unit),
    onValueChange: (String) -> Unit
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = nameTextField,
            fontFamily = inter,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp
        )
        Spacer(modifier = modifier.height(7.dp))
        TextField(
            value = valueText,
            placeholder = label,
            onValueChange = onValueChange,
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(16.dp))
                .clip(RoundedCornerShape(16.dp)),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = Blue,
                disabledIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                containerColor = White
            ),
            isError = !isValid
        )
    }

}


