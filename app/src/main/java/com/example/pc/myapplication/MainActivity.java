package com.example.pc.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView brush;
    private RelativeLayout main_layout;
    private RelativeLayout.LayoutParams layoutParams;
    private ImageView pencil;
    private float dx, dy;
    private String color = "black";
    private int size = 5;
    private boolean colorChanged = false;
    private boolean sizeChanged = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);
        initView();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        main_layout.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        pencil.setVisibility(View.VISIBLE);
                        dx = event.getRawX() - v.getX();
                        dy = event.getRawY() - v.getY();
                        pencil.animate()
                                .x(dx-10)
                                .y(dy-65)
                                .setDuration(0)
                                .start();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        dx = event.getRawX() - v.getX();
                        dy = event.getRawY() - v.getY();
                        pencil.animate()
                                .x(dx-10)
                                .y(dy-65)
                                .setDuration(0)
                                .start();

                        brush = (TextView) LayoutInflater.from(MainActivity.this).inflate(R.layout.item, null);
                        brush.setBackgroundResource(R.drawable.black);
                        layoutParams = new RelativeLayout.LayoutParams(5, 5);
                        if(colorChanged)
                            changeColor();
                        if(sizeChanged)
                            changeSize();
                        layoutParams.setMargins(Math.round((dx)), Math.round((dy)), 0, 0);
                        brush.setLayoutParams(layoutParams);
                        main_layout.addView(brush);
                        break;
                    case MotionEvent.ACTION_UP:
                        pencil.setVisibility(View.INVISIBLE);
                }
                return true;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            switch (requestCode){
                case 20:
                    color = data.getStringExtra("color");
                    colorChanged = true;
                    break;
                case 30:
                    sizeChanged = true;
                    size = data.getExtras().getInt("size");
                    break;
            }
        }
    }

    private void changeColor(){
        switch (color){
            case "red":
                brush.setBackgroundResource(R.drawable.red);
                break;
            case "green":
                brush.setBackgroundResource(R.drawable.green);
                break;
            case "blue":
                brush.setBackgroundResource(R.drawable.blue);
                break;
            case "black":
                brush.setBackgroundResource(R.drawable.black);
                break;
            case "purple":
                brush.setBackgroundResource(R.drawable.purple);
                break;
            case "brown":
                brush.setBackgroundResource(R.drawable.brown);
                break;
            case "yellow":
                brush.setBackgroundResource(R.drawable.yellow);
                break;
            case "orange":
                brush.setBackgroundResource(R.drawable.orange);
                break;
        }
    }

    private void changeSize(){
        layoutParams = new RelativeLayout.LayoutParams(size, size);
    }

    public void clear_all(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void change_color(View view){
        Intent intent = new Intent(this, Color.class);
        startActivityForResult(intent, 20);
    }

    public void change_size(View view){
        Intent intent = new Intent(this, Size.class);
        startActivityForResult(intent, 30);
    }

    private void initView() {
        main_layout = findViewById(R.id.main_layout);
        pencil = findViewById(R.id.pencil);
    }
}