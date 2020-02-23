package com.google.android.samples.dynamicfeatures.ondemand;

import android.os.Bundle;
import com.google.android.samples.dynamicfeatures.BaseSplitActivity;
import com.google.android.samples.dynamicfeatures.ondemand.java.R;

import androidx.annotation.Nullable;

/** A simple activity displaying text written in Java. */
public class JavaSampleActivity extends BaseSplitActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feature_java);
    }
}