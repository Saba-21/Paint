package com.example.pc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class Color extends AppCompatActivity {

    private String color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
    }

    public void color(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        if(checked) {
            switch (view.getId()) {
                case R.id.red:
                    color = "red";
                    break;
                case R.id.green:
                    color = "green";
                    break;
                case R.id.blue:
                    color = "blue";
                    break;
                case R.id.purple:
                    color = "purple";
                    break;
                case R.id.brown:
                    color = "brown";
                    break;
                case R.id.black:
                    color = "black";
                    break;
                case R.id.yellow:
                    color = "yellow";
                    break;
                case R.id.orange:
                    color = "orange";
                    break;
            }
        }
    }

    public void ok(View view){
        Intent intent = getIntent();
        intent.putExtra("color", color );
        setResult(RESULT_OK, intent);
        finish();
    }
}
