package com.example.library

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalLayoutApi::class)
@ExperimentalMaterial3Api
@Composable
fun MyOtp(
    modifier: Modifier = Modifier,
    modifierOtp: Modifier = Modifier,
    otpSize: Int = 6,
    width: Dp = 45.dp,
    keyboardType: KeyboardType = KeyboardType.Number,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(),
    onSuccess: (otp: String) -> Unit = {}
) {

    // Create a dynamic list based on otpSize
    val otpValues = remember { mutableStateListOf<String>() }
    LaunchedEffect(otpSize) {
        repeat(otpSize) { otpValues.add("") }
    }

    FlowRow(
        modifier = modifier, horizontalArrangement = Arrangement.Center
    ) {

        val mMaxLength = 1
        val focusManager = LocalFocusManager.current

        repeat(otpSize) {
            var stringText by rememberSaveable(stateSaver = TextFieldValue.Saver) {
                mutableStateOf(
                    TextFieldValue("")
                )
            }
            OutlinedTextField(value = stringText,
                onValueChange = { onValueChange ->
                    if (onValueChange.text.length <= mMaxLength) {
                        stringText = onValueChange
                        otpValues[it] = onValueChange.text
                        if (it < otpSize - 1) {
                            if (onValueChange.text != "") {
                                focusManager.moveFocus(
                                    focusDirection = FocusDirection.Next,
                                )
                            }
                        } else {
                            if (otpValues.size - 1 == it && otpValues.joinToString("").length == otpSize) {
                                onSuccess.invoke(otpValues.joinToString(""))
                            }
                        }
                    }
                },
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = keyboardType, imeAction = if (it < otpSize - 1) {
                        ImeAction.Next
                    } else {
                        ImeAction.Done
                    }
                ),
                colors = colors,
                modifier = modifierOtp
                    .padding(start = 10.dp)
                    .width(width)
                    .onKeyEvent { event ->
                        if (event.key == Key.Backspace) {
                            if (0 < it) {
                                stringText = TextFieldValue("")
                                focusManager.moveFocus(
                                    focusDirection = FocusDirection.Previous,
                                )
                            }
                            true
                        } else {
                            false
                        }
                    })
        }

    }

    fun myOptValue(): String {
        return if (otpValues.joinToString("").length == otpSize) {
            otpValues.joinToString("")
        } else {
            ""
        }
    }

}