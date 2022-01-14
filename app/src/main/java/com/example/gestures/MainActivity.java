package com.example.gestures;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button myButton;
    private GestureDetectorCompat gestureDetector;
    Context ct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ct = MainActivity.this;
        //params: context, class implementing GestureDetector.OnGestureListener OR extending
        // GestureDetector.SimpleOnGestureListener
        gestureDetector = new GestureDetectorCompat(this,new myGestureListener());

        myButton = findViewById(R.id.myButton);
        myButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //onTouchEvent ANALYZES the given motion event and IF APPLICABLE TRIGGERS
                //THE APPROPRIATE CALLBACKS ON THE GestureDetector
                return gestureDetector.onTouchEvent(event);
            }

        });
    }

    public class myGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Toast.makeText(ct,"Double click gesture detected!",Toast.LENGTH_SHORT).show();
            return true;
        }

    }
}