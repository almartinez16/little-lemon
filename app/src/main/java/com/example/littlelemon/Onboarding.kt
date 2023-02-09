package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemon.ui.theme.*

@Composable
fun Onboarding() {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
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
        Text(
            text = stringResource(id = R.string.onboard_first_name),
            style = LittleLemon.h4,
            modifier = Modifier
                .padding(start = 10.dp)
                .align(Alignment.Start)
        )
        OutlinedTextField(
            value = firstName,
            onValueChange = { firstName = it},
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Primary_Green,
            ),
            modifier = Modifier.fillMaxWidth(.95f)
        )
        Text(
            text = stringResource(id = R.string.onboard_last_name),
            style = LittleLemon.h4,
            modifier = Modifier
                .padding(start = 10.dp, top = 25.dp)
                .align(Alignment.Start)
        )
        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it},
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Primary_Green,
            ),
            modifier = Modifier.fillMaxWidth(.95f)
        )
        Text(
            text = stringResource(id = R.string.onboard_email),
            style = LittleLemon.h4,
            modifier = Modifier
                .padding(start = 10.dp, top = 25.dp)
                .align(Alignment.Start)
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it},
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Primary_Green,
            ),
            modifier = Modifier.fillMaxWidth(.95f)
        )
        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxHeight(.85f)
                .fillMaxWidth(.95f)
        ) {
            Button(
                onClick = { /*TODO: add registration logic and new navigation*/ },
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
}

@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    LittleLemonTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Onboarding()
        }
    }
}