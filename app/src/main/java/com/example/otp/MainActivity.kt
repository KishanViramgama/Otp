package com.example.otp

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import android.window.OnBackInvokedDispatcher
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
            onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    finish()
                }
            })
        }

        setContent {
            OtpTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    MyView()
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    @Preview(showBackground = true)
    private fun MyView() {
        val context = LocalContext.current
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            MarginVertical(dp = 120.dp)
            Text(stringResource(R.string.enter_your_otp), style = MaterialTheme.typography.displaySmall)
            MarginVertical()
            Text(
                stringResource(R.string.des_otp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier
                    .padding(
                        start = 20.dp, end = 20.dp
                    )
                    .fillMaxWidth()
            )
            MarginVertical()
            val getOtp = MyOtp(
                otpSize = 4, modifier = Modifier.padding(
                    start = 10.dp, end = 10.dp, top = 10.dp
                )
            ) {
                Toast.makeText(this@MainActivity, it, Toast.LENGTH_SHORT).show()
            }

            MarginVertical()

            Button(onClick = {
                if (getOtp.isNotEmpty()) {
                    Toast.makeText(
                        context, "${getString(R.string.otp_found)} $getOtp", Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        context, getString(R.string.otpEmpty), Toast.LENGTH_SHORT
                    ).show()
                }
            }) {
                Text(stringResource(R.string.verify))
            }
            MarginVertical()
        }
    }

}

