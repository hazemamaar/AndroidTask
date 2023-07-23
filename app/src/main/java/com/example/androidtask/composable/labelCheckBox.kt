package com.example.androidtask.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidtask.ui.theme.black_25
import com.example.androidtask.ui.theme.blue
import com.example.androidtask.ui.theme.inter

@Composable
fun LabelledCheckbox() {
    Row(modifier = Modifier.padding(vertical = 16.dp)) {
        var isChecked by remember { mutableStateOf(false) }

        Checkbox(
            modifier = Modifier.size(width = 40.dp, height = 30.dp).padding(6.dp).clip(
                RoundedCornerShape(30.dp)
            ),
            checked = isChecked,
            onCheckedChange = {
                isChecked = it
            },
            colors = CheckboxDefaults.colors(checkedColor = blue, uncheckedColor = blue),
            enabled = true,
        )

        Text(buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Black)) {
                append("By signing up, you agree to the ")
            }
            withStyle(style = SpanStyle(color = blue)) {
                append("Terms of Service and Privacy Policy")
            }
        }, fontFamily = inter, fontWeight = FontWeight.SemiBold, fontSize = 15.sp)
    }
}