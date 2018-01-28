package com.example.midori.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by midori on 2018/01/27.
 */

public class OutputActivity extends AppCompatActivity {
    private Button btn_result;
    private TextView tx_number_a;
    private TextView tx_number_b;

    private int number_a;
    private int number_b;
    public static final String RESULT ="result";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receive_data);
        setWidget();
        getData();
        setEvent();
    }

    public void getData(){
        Intent intent = getIntent();
        number_a = intent.getIntExtra(InputActivity.NUMBER_A,0);
        number_b = intent.getIntExtra(InputActivity.NUMBER_B,0);
        tx_number_a.setText("Number A :" + number_a);
        tx_number_b.setText("Number B :" + number_b);
    }

    public void setWidget(){
        btn_result = (Button) findViewById(R.id.btn_result);
        tx_number_a = (TextView) findViewById(R.id.tv_number_a);
        tx_number_b = (TextView) findViewById(R.id.tv_number_b);
    }
    public void setEvent(){
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(RESULT,number_a+number_b);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
