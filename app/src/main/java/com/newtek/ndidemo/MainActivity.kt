package com.newtek.ndidemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        sample_text.text = stringFromJNI()

        val success = testNDIInitialize()
        Log.i("MainActivity", "$success")
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String
    external fun testNDIInitialize(): Boolean

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("ndi")
            System.loadLibrary("native-lib")
        }
    }
}
