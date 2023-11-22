package com.example.otp

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.window.OnBackInvokedDispatcher
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.os.BuildCompat
import com.example.library.MyOtp
import com.example.otp.ui.theme.OtpTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= 33) {
            onBackInvokedDispatcher.registerOnBackInvokedCallback(
                OnBackInvokedDispatcher.PRIORITY_DEFAULT
            ) {
                finish()
            }
        } else {
            onBackPressedDispatcher.addCallback(this,
                object : OnBackPressedCallback(true) {
                    override fun handleOnBackPressed() {
                        finish()
                    }
                })
        }

        setContent {
            OtpTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    MyOtp(this) {
                        Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                        Log.d("data_information", it.toString())
                    }
                }
            }
        }
    }
}