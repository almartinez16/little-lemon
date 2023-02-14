package com.example.littlelemon.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.littlelemon.ui.navigation.Profile

@Composable
fun Home(navController: NavHostController) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
            .clickable { navController.navigate(Profile.route) }
    ) {
        Text(
            text = "Home",
            fontSize = 64.sp
        )
    }
}