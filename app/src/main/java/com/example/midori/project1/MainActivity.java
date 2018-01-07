package com.example.midori.project1;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RadioButton r_btn_gender_male;
    private RadioButton r_btn_gender_female;

    private CheckBox cb_hobby_1;
    private CheckBox cb_hobby_2;
    private CheckBox cb_hobby_3;
    private CheckBox cb_hobby_4;

    private ImageButton img_btn_submit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        img_btn_submit.setOnClickListener(this);
    }

    public void initWidget() {
        r_btn_gender_male = (RadioButton) findViewById(R.id.r_btn_gender_male);
        r_btn_gender_female = (RadioButton) findViewById(R.id.r_btn_gender_female);

        cb_hobby_1 = (CheckBox) findViewById(R.id.cb_hobby_1);
        cb_hobby_2 = (CheckBox) findViewById(R.id.cb_hobby_2);
        cb_hobby_3 = (CheckBox) findViewById(R.id.cb_hobby_3);
        cb_hobby_4 = (CheckBox) findViewById(R.id.cb_hobby_4);

        img_btn_submit = (ImageButton)findViewById(R.id.img_btn_submit);
    }

    @Override

    public void onClick(View v) {
        String slogan = " My profile : ";

        if (cb_hobby_1.isChecked()) {
            slogan += cb_hobby_1.getText().toString() + " - ";
        }
        if (cb_hobby_2.isChecked()) {
            slogan += cb_hobby_2.getText().toString() + " - ";
        }
        if (cb_hobby_3.isChecked()) {
            slogan += cb_hobby_3.getText().toString() + " - ";
        }
        if (cb_hobby_4.isChecked()) {
            slogan += cb_hobby_4.getText().toString() + " - ";
        }
        if (r_btn_gender_female.isChecked()) {
            slogan += r_btn_gender_female.getText().toString() + " ";
        } else {
            slogan += r_btn_gender_male.getText().toString() + " ";
        }

        Toast.makeText(MainActivity.this, slogan, Toast.LENGTH_SHORT).show();
    }

}
