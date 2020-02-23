package com.google.android.samples.dynamicfeatures.ondemand

import android.os.Bundle
import android.widget.TextView

import com.google.android.play.core.splitinstall.SplitInstallHelper
import com.google.android.samples.dynamicfeatures.BaseSplitActivity
import com.google.android.samples.dynamicfeatures.ondemand.ccode.R

/** A simple activity displaying some text coming through via JNI. */
class NativeSampleActivity : BaseSplitActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SplitInstallHelper.loadLibrary(this, "hello-jni")

        setContentView(R.layout.activity_hello_jni)
        findViewById<TextView>(R.id.hello_textview).text = stringFromJNI()
    }

    /** Read a string from packaged native code. */
    external fun stringFromJNI(): String
}