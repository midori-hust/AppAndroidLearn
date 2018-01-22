package com.example.midori.project1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by midori on 2018/01/22.
 */

public class SendDataActivity extends Activity{
    public Button btn_send_data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_data);
        btn_send_data = (Button) findViewById(R.id.btn_send_data);
        btn_send_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SendDataActivity.this, ReceiveDataActivity.class);
                startActivity(intent);
            }
        });
    }
}
