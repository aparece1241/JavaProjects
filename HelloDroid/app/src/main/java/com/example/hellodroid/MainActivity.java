package com.example.hellodroid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
//refers to this link
//https://www.jetbrains.com/help/idea/create-your-first-android-application.html#build-run-Android-application

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}