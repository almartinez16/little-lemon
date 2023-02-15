package com.example.littlelemon.ui

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.R
import com.example.littlelemon.data.PrefRepository
import com.example.littlelemon.ui.theme.*
import com.example.littlelemon.ui.navigation.*

@Composable
fun Onboarding(navController: NavHostController) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Header composable
        OnboardingHeader()
        // Form composable
        OnboardingForm(
            context = LocalContext.current,
            navController = navController,
            modifier = Modifier.align(Alignment.Start)
        )
    }
}

@Composable
fun OnboardingHeader() {
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
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(Primary_Green)
    ) {
        Text(
            text = stringResource(id = R.string.onboard_get_to_know_you),
            color = Secondary_White,
            fontFamily = Karla,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
        )
    }
}

@Composable
fun OnboardingForm(
    context: Context,
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val prefRepository = PrefRepository(context)

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    var isFirstNameEmpty by remember { mutableStateOf(false) }
    var isLastNameEmpty by remember { mutableStateOf(false) }
    var isEmailEmpty by remember { mutableStateOf(false) }

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
            .padding(start = 10.dp)
    )
    // First name TextField
    OutlinedTextField(
        value = firstName,
        isError = isFirstNameEmpty,
        onValueChange = {
            firstName = it
            isFirstNameEmpty = false
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary_Green,
        ),
        modifier = Modifier.fillMaxWidth(.95f)
    )
    // Last name Text
    Text(
        text = stringResource(id = R.string.last_name),
        style = LittleLemon.h4,
        modifier = modifier
            .padding(start = 10.dp, top = 25.dp)
    )
    // Last name TextField
    OutlinedTextField(
        value = lastName,
        isError = isLastNameEmpty,
        onValueChange = {
            lastName = it
            isLastNameEmpty = false
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary_Green,
        ),
        modifier = Modifier.fillMaxWidth(.95f)
    )
    // Email text
    Text(
        text = stringResource(id = R.string.email),
        style = LittleLemon.h4,
        modifier = modifier
            .padding(start = 10.dp, top = 25.dp)
    )
    // Email TextField
    OutlinedTextField(
        value = email,
        isError = isEmailEmpty,
        onValueChange = {
            email = it
            isEmailEmpty = false
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary_Green,
        ),
        modifier = Modifier.fillMaxWidth(.95f)
    )

    // Registration button
    Row(
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .fillMaxHeight(.85f)
            .fillMaxWidth(.95f)
    ) {
        Button(
            onClick = {
                // Validation logic
               if (firstName.isNotBlank() && lastName.isNotBlank() && email.isNotBlank()) {
                   context.toast("Registration successful!")
                   // Save login information to sharedPreferences
                   prefRepository.saveUserFirstName(firstName)
                   prefRepository.saveUserLastName(lastName)
                   prefRepository.saveUserEmail(email)
                   prefRepository.saveLoggedIn(true)
                   // Navigate to Home Screen after successful registration
                    navController.navigate(Home.route) {
                        popUpTo(Home.route) {
                            inclusive = true
                        }
                    }
               } else {
                   context.toast("Registration unsuccessful. Please enter all data.")
                   // If any field is empty, is prompted isError
                   if (firstName.isBlank()) isFirstNameEmpty = true
                   if (lastName.isBlank()) isLastNameEmpty = true
                   if (email.isBlank()) isEmailEmpty = true
               }
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.register_button),
                color = Secondary_Black,
                style = LittleLemon.button
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    LittleLemonTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Onboarding(navController = rememberNavController())
        }
    }
}