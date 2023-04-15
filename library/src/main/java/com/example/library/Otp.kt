package com.example.library

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly

@OptIn(ExperimentalLayoutApi::class)
@ExperimentalMaterial3Api
@Composable
fun Otp() {

    FlowRow(
        modifier = Modifier.padding(start = 10.dp, top = 10.dp, end = 10.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Box(modifier = Modifier.width(60.dp)) {
            var stringText by remember { mutableStateOf(TextFieldValue("")) }
            OutlinedTextField(
                value = stringText,
                onValueChange = {
                    if (it.text.isDigitsOnly()) {
                        stringText = it
                    }
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.padding(end = 10.dp)
            )
        }
        Box(modifier = Modifier.width(60.dp)) {
            var stringText by remember { mutableStateOf(TextFieldValue("")) }
            OutlinedTextField(
                value = stringText,
                onValueChange = {
                    if (it.text.isDigitsOnly()) {
                        stringText = it
                    }
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.padding(end = 10.dp)
            )
        }
        Box(modifier = Modifier.width(60.dp)) {
            var stringText by remember { mutableStateOf(TextFieldValue("")) }
            OutlinedTextField(
                value = stringText,
                onValueChange = {
                    if (it.text.isDigitsOnly()) {
                        stringText = it
                    }
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.padding(end = 10.dp)
            )
        }
        Box(modifier = Modifier.width(60.dp)) {
            var stringText by remember { mutableStateOf(TextFieldValue("")) }
            OutlinedTextField(
                value = stringText,
                onValueChange = {
                    if (it.text.isDigitsOnly()) {
                        stringText = it
                    }
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.padding(end = 10.dp)
            )
        }
        Box(modifier = Modifier.width(60.dp)) {
            var stringText by remember { mutableStateOf(TextFieldValue("")) }
            OutlinedTextField(
                value = stringText,
                onValueChange = {
                    if (it.text.isDigitsOnly()) {
                        stringText = it
                    }
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.padding(end = 10.dp)
            )
        }
        Box(modifier = Modifier.width(60.dp)) {
            var stringText by remember { mutableStateOf(TextFieldValue("")) }
            OutlinedTextField(
                value = stringText,
                onValueChange = {
                    if (it.text.isDigitsOnly()) {
                        stringText = it
                    }
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.padding(end = 10.dp)
            )
        }
        Box(modifier = Modifier.width(60.dp)) {
            var stringText by remember { mutableStateOf(TextFieldValue("")) }
            OutlinedTextField(
                value = stringText,
                onValueChange = {
                    if (it.text.isDigitsOnly()) {
                        stringText = it
                    }
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.padding(end = 10.dp)
            )
        }
        Box(modifier = Modifier.width(60.dp)) {
            var stringText by remember { mutableStateOf(TextFieldValue("")) }
            OutlinedTextField(
                value = stringText,
                onValueChange = {
                    if (it.text.isDigitsOnly()) {
                        stringText = it
                    }
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.padding(end = 10.dp)
            )
        }
        Box(modifier = Modifier.width(60.dp)) {
            var stringText by remember { mutableStateOf(TextFieldValue("")) }
            OutlinedTextField(
                value = stringText,
                onValueChange = {
                    if (it.text.isDigitsOnly()) {
                        stringText = it
                    }
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.padding(end = 10.dp)
            )
        }
    }

}