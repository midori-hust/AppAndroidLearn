package com.example.midori.project1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by midori on 2018/01/27.
 */

public class InputActivity extends AppCompatActivity{
    public EditText edt_number_a;
    public EditText edt_number_b;
    public Button btn_result;

    public static final String NUMBER_A = "number_a";
    public static final String NUMBER_B = "number_b";

    public static final int REQUEST_CODE = 2018;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_data_receive);
        getWidget();
        sendEvent();
    }
    public void getWidget(){
        edt_number_a = (EditText) findViewById(R.id.edt_number_a);
        edt_number_b = (EditText) findViewById(R.id.edt_number_b);
        btn_result = (Button) findViewById(R.id.btn_result);
    }
    public void sendEvent(){
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number_a = edt_number_a.getText().toString();
                String number_b = edt_number_b.getText().toString();
                if (!TextUtils.isEmpty(number_a) && !TextUtils.isEmpty(number_b)){
                    Intent intent = new Intent(InputActivity.this, OutputActivity.class);
                    intent.putExtra(NUMBER_A,Integer.parseInt(number_a));
                    intent.putExtra(NUMBER_B,Integer.parseInt(number_b));
                    startActivityForResult(intent,REQUEST_CODE);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            switch (resultCode){
                case RESULT_OK:
                    Toast.makeText(InputActivity.this, "Result : "+data.getIntExtra(OutputActivity.RESULT,0), Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    }

}
