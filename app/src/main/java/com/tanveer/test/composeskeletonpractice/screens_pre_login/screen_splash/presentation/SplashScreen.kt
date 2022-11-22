package com.tanveer.test.composeskeletonpractice.screens_pre_login.screen_splash.presentation


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SplashScreen(onNavigateToFriends: () -> Unit) {
    SplashScreenContent(onNavigateToFriends = onNavigateToFriends)
}

@Composable
fun SplashScreenContent(
    onNavigateToFriends: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .border(2.dp, color = Color.Gray)
            .height(50.dp),
    ) {
        Button(
            modifier = Modifier
                .padding(top = 10.dp)
                .align(Alignment.TopCenter)
                .border(2.dp, color = Color.Red),
            onClick = onNavigateToFriends

        ) {
            Text(text = "go to dashboard")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultSplashPreview() {
    Surface {
        SplashScreenContent {}
    }
}