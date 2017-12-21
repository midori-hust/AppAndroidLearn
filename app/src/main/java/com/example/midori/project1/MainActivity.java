package com.example.midori.project1;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private LinearLayout linearLayoutRoot;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Linear Layout Root
        linearLayoutRoot = new LinearLayout(this);
        LinearLayout.LayoutParams linearLayoutParamsRoot = new LinearLayout.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        linearLayoutRoot.setOrientation(LinearLayout.VERTICAL);
        linearLayoutRoot.setLayoutParams(linearLayoutParamsRoot);

        //Linear Layout Second
        LinearLayout linearLayoutSecond = new LinearLayout(this);
        LinearLayout.LayoutParams linearLayoutParamSecond = new LinearLayout.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT );
        linearLayoutSecond.setGravity(Gravity.CENTER);
        linearLayoutSecond.setLayoutParams(linearLayoutParamSecond);
        linearLayoutSecond.setOrientation(LinearLayout.HORIZONTAL);

        //Image View
        ImageView imgView = new ImageView(this);
        imgView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        imgView.setImageResource(R.mipmap.ic_launcher);

        //Text view
        TextView textView = new TextView(this);
        textView.setText("This is my app ! WeLl come");
        LinearLayout.LayoutParams lay = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lay.gravity = Gravity.CENTER;
        textView.setLayoutParams(lay);

        linearLayoutSecond.addView(imgView);
        linearLayoutSecond.addView(textView);

        //Button Click me
        Button btnClick = new Button(this);
        LinearLayout.LayoutParams btnParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        btnParams.gravity = Gravity.CENTER;
        btnClick.setLayoutParams(btnParams);
        btnClick.setText("On Click !!");

        //Button hihi me
        Button btnhihi = new Button(this);
        btnhihi.setLayoutParams(btnParams);
        btnhihi.setText("On Click !!");

        linearLayoutRoot.addView(linearLayoutSecond);
        linearLayoutRoot.addView(btnClick);
        linearLayoutRoot.addView(btnhihi);
        setContentView(linearLayoutRoot);
    }
}
