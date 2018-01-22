package com.example.midori.project1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by midori on 2018/01/22.
 */

public class SendDataActivity extends Activity{
    public Button btnSendData;
    public EditText edtUsername;
    public EditText edtPassword;

    public static final String USERNAME ="username";
    public static final String PASSWORD ="password";
    public static final String BUNDLE="bundle";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_data);
        btnSendData = (Button) findViewById(R.id.btn_send_data);
        edtUsername = (EditText) findViewById(R.id.edt_username);
        edtPassword = (EditText) findViewById(R.id.edt_password);

        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                //byExtras(username,password);
                byBundle(username,password);
            }
        });
    }

    public void byExtras(String username, String password){
        Intent intent = new Intent(SendDataActivity.this, ReceiveDataActivity.class);
        intent.putExtra(USERNAME,username);
        intent.putExtra(PASSWORD,password);
        startActivity(intent);
    }

    public void byBundle(String username, String password){
        Intent intent = new Intent(SendDataActivity.this, ReceiveDataActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(USERNAME,username);
        bundle.putString(PASSWORD,password);
        intent.putExtra(BUNDLE,bundle);
        startActivity(intent);
    }
}
