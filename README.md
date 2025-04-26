<h1 align="center">🔐 Jetpack Compose OTP Library</h1>

<p align="center">
  <img src="https://github.com/KishanViramgama/Otp/blob/master/demo.gif" height="380px" alt="OTP Demo" />
</p>

<p align="center">
  <strong>A lightweight and customizable OTP input solution built with Jetpack Compose ⚡</strong>
</p>



<h2>✨ Features</h2>

<ul>
  <li>✅ Simple integration – just drop and use</li>
  <li>🔢 Supports any OTP length (4, 6, etc.)</li>
  <li>🎨 Fully customizable using Compose <code>Modifier</code></li>
  <li>🔁 Auto focus and intelligent backspace handling</li>
  <li>🚀 Callback triggered when OTP entry is completed</li>
</ul>



<h2>📦 Gradle Setup</h2>

<h4><code>settings.gradle.kts</code></h4>

<pre><code>
dependencyResolutionManagement {
    repositories {
        maven { url = uri("https://jitpack.io") }
    }
}
</code></pre>

<h4><code>build.gradle.kts</code></h4>

<pre><code>
dependencies {
    implementation("com.github.KishanViramgama:Otp:0.0.2")
}
</code></pre>



<h2>🚀 Usage</h2>

<pre>
<code>
val getOtp = MyOtp(
    otpSize = 4,
    modifier = Modifier.padding(
        start = 10.dp,
        end = 10.dp,
        top = 10.dp
    )
) {
    Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
}

Button(onClick = {
    if (getOtp.isNotEmpty()) {
        Toast.makeText(
            context,
            "OTP Found: $getOtp",
            Toast.LENGTH_SHORT
        ).show()
    } else {
        Toast.makeText(
            context,
            "OTP is empty!",
            Toast.LENGTH_SHORT
        ).show()
    }
}) {
    Text("Get OTP")
}
</code>
</pre>



<h2>🔧 Parameters</h2>

<table>
  <thead>
    <tr>
      <th>🧩 Parameter</th>
      <th>📖 Description</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><code>otpSize: Int</code></td>
      <td>Defines how many digits your OTP input will have. Common values: <code>4</code> or <code>6</code>.</td>
    </tr>
    <tr>
      <td><code>modifier: Modifier</code></td>
      <td>Customize layout using Jetpack Compose's <code>Modifier</code> (padding, width, alignment).</td>
    </tr>
    <tr>
      <td><code>onOtpComplete: (String) -> Unit</code></td>
      <td>Callback triggered when all digits are entered. Returns the full OTP string.</td>
    </tr>
  </tbody>
</table>



<h2>📥 Retrieving OTP Value</h2>
<p>The return value from <code>MyOtp(...)</code> is a <code>String</code> that stores the full OTP.</p>

<ul>
  <li>📦 Use it on button click or form submission</li>
  <li>⚠️ If OTP is incomplete, it will return an <code>empty</code> string</li>
</ul>

---
**Tags**: `Jetpack Compose`, `OTP`, `Android`, `Kotlin`, `Authentication`, `UI`, `Compose UI`, `Material Design`


<h2>🤝 Contribution</h2>

<p>Want to improve this library? You're welcome! Fork it, raise a PR, or open an issue with your suggestions. Let's build better together 💪</p>



<h2>🪪 License</h2>

<p>This project is <a href="LICENSE">MIT Licensed</a></p>

<p align="center">
  <i>Built with ❤️ by <a href="https://github.com/KishanViramgama" target="_blank">Kishan Viramgama</a></i>
</p>