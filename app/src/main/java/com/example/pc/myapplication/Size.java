package com.example.pc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class Size extends AppCompatActivity {

    private int size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_size);
    }

    public void size(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        if(checked) {
            switch (view.getId()) {
                case R.id.one:
                        size = 1;
                    break;
                case R.id.five:
                        size = 5;
                    break;
                case R.id.ten:
                        size = 10;
                    break;
                case R.id.fifteen:
                    size = 15;
                    break;
                case R.id.twenty:
                    size = 20;
                    break;
                case R.id.thirty:
                    size = 30;
                    break;
            }
        }
    }

    public void ok(View view){
        Intent intent = getIntent();
        intent.putExtra("size", size );
        setResult(RESULT_OK, intent);
        finish();
    }
}
