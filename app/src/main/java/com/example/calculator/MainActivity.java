package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0, bt_pi, bt_dot,
            bt_equal, bt_plus, bt_min, bt_mul, bt_div, bt_sqrt, bt_square,
            bt_inv, bt_sin, bt_cos, bt_tg, bt_ctg, bt_log, btb1, btb2, bt_ac, bt_c;

    TextView tv_main, tv_sec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);
        bt6 = findViewById(R.id.bt6);
        bt7 = findViewById(R.id.bt7);
        bt8 = findViewById(R.id.bt8);
        bt9 = findViewById(R.id.bt9);
        bt0 = findViewById(R.id.bt0);

        bt_pi = findViewById(R.id.bt_pi);
        bt_dot = findViewById(R.id.bt_dot);
        bt_equal = findViewById(R.id.bt_equal);
        bt_plus = findViewById(R.id.bt_plus);
        bt_min = findViewById(R.id.bt_min);
        bt_mul = findViewById(R.id.bt_mul);
        bt_div = findViewById(R.id.bt_div);
        bt_sqrt = findViewById(R.id.bt_sqrt);
        bt_square = findViewById(R.id.bt_square);

        bt_inv = findViewById(R.id.bt_inv);
        bt_sin = findViewById(R.id.bt_sin);
        bt_cos = findViewById(R.id.bt_cos);
        bt_tg = findViewById(R.id.bt_tg);
        bt_ctg = findViewById(R.id.bt_ctg);
        bt_log = findViewById(R.id.bt_log);
        btb1 = findViewById(R.id.bt_bracket1);
        btb2= findViewById(R.id.bt_bracket2);
        bt_ac= findViewById(R.id.bt_ac);
        bt_c = findViewById(R.id.bt_c);

        tv_main = findViewById(R.id.tv_main);
        tv_sec = findViewById(R.id.tv_sec);

        //onclick listeners
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_main.setText(tv_main.getText()+"1");
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_main.setText(tv_main.getText()+"2");
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_main.setText(tv_main.getText()+"3");
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_main.setText(tv_main.getText()+"4");
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_main.setText(tv_main.getText()+"5");
            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_main.setText(tv_main.getText()+"6");
            }
        });
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_main.setText(tv_main.getText()+"7");
            }
        });
        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_main.setText(tv_main.getText()+"8");
            }
        });
        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_main.setText(tv_main.getText()+"9");
            }
        });
        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_main.setText(tv_main.getText()+"0");
            }
        });
        bt_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_main.setText(tv_main.getText()+".");
            }
        });
        bt_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_main.setText("");
            }
        });
        bt_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tv_main.getText().toString();
                if(!val.isEmpty()){
                    val = val.substring(0, val.length()-1);
                    tv_main.setText(val);
                }
            }
        });
    }
}