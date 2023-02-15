package com.example.littlelemon.ui

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.R
import com.example.littlelemon.data.PrefRepository
import com.example.littlelemon.ui.navigation.Onboarding
import com.example.littlelemon.ui.theme.LittleLemon
import com.example.littlelemon.ui.theme.LittleLemonTheme
import com.example.littlelemon.ui.theme.Primary_Green
import com.example.littlelemon.ui.theme.Secondary_Black

@Composable
fun Profile(navController: NavHostController) {
    val context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header containing logo
        ProfileHeader()
        // Personal Information section
        ProfileInformation(
            context = context,
            modifier = Modifier.align(Alignment.Start)
        )
        // Logout button
        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxHeight(.85f)
                .fillMaxWidth(.95f)
        ) {
            Button(
                onClick = {
                    PrefRepository(context).clearSavedData()
                    context.toast("S")
                    navController.navigate(Onboarding.route) {
                        popUpTo(Onboarding.route) {
                            inclusive = true
                        }
                    }
                },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = R.string.logout_button),
                    color = Secondary_Black,
                    style = LittleLemon.button
                )
            }
        }
    }
}

@Composable
fun ProfileHeader(
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Little Lemon logo",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .size(270.dp)
        )
    }
}

@Composable
fun ProfileInformation(
    context: Context,
    modifier: Modifier = Modifier
) {
    val prefRepository = PrefRepository(context)

    // Gather information from shared preferences
    // (setup with mutableState to allow future information update)
    var firstName by remember { mutableStateOf(prefRepository.getUserFirstName()) }
    var lastName by remember { mutableStateOf(prefRepository.getUserLastName()) }
    var email by remember { mutableStateOf(prefRepository.getUserEmail()) }

    // Personal information
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(.95f)
            .height(150.dp)
    ) {
        Text(
            text = stringResource(id = R.string.onboard_personal_information),
            style = LittleLemon.h3
        )
    }
    // First name Text
    Text(
        text = stringResource(id = R.string.first_name),
        style = LittleLemon.h4,
        modifier = modifier
            .padding(start = 10.dp, bottom = 5.dp)
    )
    // First name TextField
    OutlinedTextField(
        value = firstName,
        onValueChange = { firstName = it },
        enabled = false,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary_Green,
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth(.95f)
    )
    // Last name Text
    Text(
        text = stringResource(id = R.string.last_name),
        style = LittleLemon.h4,
        modifier = modifier
            .padding(start = 10.dp, top = 25.dp, bottom = 5.dp)
    )
    // Last name TextField
    OutlinedTextField(
        value = lastName,
        onValueChange = { lastName = it },
        enabled = false,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary_Green,
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth(.95f)
    )
    // Email text
    Text(
        text = stringResource(id = R.string.email),
        style = LittleLemon.h4,
        modifier = modifier
            .padding(start = 10.dp, top = 25.dp, bottom = 5.dp)
    )
    // Email TextField
    OutlinedTextField(
        value = email,
        onValueChange = { email = it },
        enabled = false,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary_Green,
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth(.95f)
    )
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    LittleLemonTheme {
        Profile(rememberNavController())
    }
}