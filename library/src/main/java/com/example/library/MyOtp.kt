package com.example.library

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly

@OptIn(ExperimentalLayoutApi::class)
@ExperimentalMaterial3Api
@Composable
fun MyOtp(content: Context, otpSize: Int = 6, width: Dp = 45.dp, onSuccess: (otp: String) -> Unit) {

    var myOtp: String = ""

    FlowRow(
        modifier = Modifier.padding(start = 10.dp, top = 10.dp, end = 10.dp),
        horizontalArrangement = Arrangement.Center
    ) {

        val mMaxLength = 1
        val focusManager = LocalFocusManager.current

        repeat(otpSize) {
            var stringText by remember { mutableStateOf(TextFieldValue("")) }
            OutlinedTextField(
                value = stringText,
                onValueChange = { onValueChange ->
                    if (onValueChange.text.isDigitsOnly()) {
                        if (onValueChange.text.length <= mMaxLength) {
                            stringText = onValueChange
                            myOtp = onValueChange.text
                            if (otpSize - 1 > it) {
                                focusManager.moveFocus(
                                    focusDirection = FocusDirection.Next,
                                )
                            }
                        }
                    }
                },
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .padding(end = 10.dp)
                    .width(width)
                    .onKeyEvent { event ->
                        if (0 < it) {
                            if (event.key == Key.Backspace) {
                                focusManager.moveFocus(
                                    focusDirection = FocusDirection.Previous,
                                )

                            }
                        }
                        true
                    }
            )
        }

    }

}