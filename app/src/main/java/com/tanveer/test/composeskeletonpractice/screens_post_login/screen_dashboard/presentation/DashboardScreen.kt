package com.tanveer.test.composeskeletonpractice.screens_post_login.screen_dashboard.presentation

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DashboardScreen() {
    ShowGreeting()
}

@Composable
fun ShowGreeting() {
    val context = LocalContext.current
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 34.dp)
            .clickable {
                Toast
                    .makeText(
                        context,
                        "Clicked On Welcome to Compose App Development",
                        Toast.LENGTH_SHORT
                    )
                    .show()
            },
        text = "Hello, Welcome to Compose App Development",
        fontFamily = FontFamily.Cursive,
        color = Color.Black,
        fontSize = 34.sp,
        textAlign = TextAlign.Center

    )
}

@Preview(showBackground = true)
@Composable
fun DefaultDashboardPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        ShowGreeting()
    }

}