package com.afunx.rxjava4androiddemos.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.afunx.rxjava4androiddemos.R;
import com.afunx.rxjava4androiddemos.samples.SampleManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SampleManager.get().test();
    }
}
