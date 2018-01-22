package com.example.midori.project1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by midori on 2018/01/22.
 */

public class ReceiveDataActivity extends Activity {
    private TextView tvUserInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_data);
        tvUserInfo = (TextView)findViewById(R.id.tv_user_info);
        Intent intent = getIntent();
        if(intent != null){
            Bundle bundle = intent.getBundleExtra(SendDataActivity.BUNDLE);
            if(bundle != null){
                tvUserInfo.setText("Hello " +bundle.getString(SendDataActivity.USERNAME));
            }else{
                tvUserInfo.setText("Hello " +intent.getStringExtra(SendDataActivity.USERNAME));
            }
        }
    }
}
