package com.example.surfaceview;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Example extends AppCompatActivity {
    private SurfaceHolder holder;
    private SurfaceView surfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        surfaceView = findViewById(R.id.surfaceView);

        holder = surfaceView.getHolder();
        holder.addCallback(callback);
    }

    SurfaceHolder.Callback2 callback = new SurfaceHolder.Callback2() {
        @Override
        public void surfaceRedrawNeeded(@NonNull SurfaceHolder holder) {

        }

        @Override
        public void surfaceCreated(@NonNull SurfaceHolder holder) {

        }

        @Override
        public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

        }

        @Override
        public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

        }
    };

    private Paint drawPaint = new Paint();
    {
        drawPaint.setColor(0xffff0000);
    };
}
