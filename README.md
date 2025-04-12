# Otp

<img src="https://github.com/KishanViramgama/Otp/blob/master/demo.gif" height="368px" align="right" style="max-width:100%;"/>

This library provides a set of composables for easily integrating One-Time Password (OTP)  verification into your Jetpack Compose applications.

🚀 Usage

<pre>
MyOtp(
    otpSize = 4,
    modifier = Modifier.padding(
        start = 10.dp,
        end = 10.dp,
        top = 10.dp
    )
) { otp ->
    Toast.makeText(this@MainActivity, otp, Toast.LENGTH_SHORT).show()
    Log.d("OTP Value", otp)
}
</pre>

<h3>🔧 Parameters</h3>

<table>
  <thead>
    <tr>
      <th>Parameter</th>
      <th>Description</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><code>otpSize: Int</code></td>
      <td>🔢 Defines how many digits your OTP input will have. Common values: <code>4</code> or <code>6</code>.</td>
    </tr>
    <tr>
      <td><code>modifier: Modifier</code></td>
      <td>🎨 Customize layout using Jetpack Compose's <code>Modifier</code> (padding, size, background, etc.).</td>
    </tr>
    <tr>
      <td><code>onOtpComplete: (String) -&gt; Unit</code></td>
      <td>✅ Callback triggered when all digits are entered. Returns the full OTP string.</td>
    </tr>
  </tbody>
</table>




<b>Gradle</b>

Add following dependency to your settings.gradle.kts file:

<pre>
dependencyResolutionManagement {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
</pre>

Add following dependency to your app module build.gradle.kts file:

<pre>
dependencies {
    implementation ("com.github.KishanViramgama:Otp:0.0.1")
}
</pre>
