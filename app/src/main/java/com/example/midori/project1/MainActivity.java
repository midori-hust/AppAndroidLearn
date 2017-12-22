package com.example.midori.project1;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private LinearLayout linearLayoutRoot;
    private RelativeLayout relativeLayoutRoot;

    private Button btn_result;
    private EditText edt_numbera;
    private EditText edt_numberb;
    private int numbera, numberb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_numbera = (EditText) findViewById(R.id.edta);
        edt_numberb = (EditText) findViewById(R.id.edtb);
        btn_result = (Button) findViewById(R.id.btn_result);

        btn_result.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String stra = edt_numbera.getText().toString();
                String strb = edt_numberb.getText().toString();
                if (stra.isEmpty() || strb.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Input number!", Toast.LENGTH_SHORT).show();
                    return;
                }
                numbera = Integer.parseInt(stra);
                numberb = Integer.parseInt(strb);
                Toast.makeText(MainActivity.this, String.format("%s + %s = %s", numbera,numberb,numbera+numberb), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initRelativeLayout() {
        //RelativeLayout Root
        relativeLayoutRoot = new RelativeLayout(this);
        RelativeLayout.LayoutParams relativeLayoutParam = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        relativeLayoutRoot.setLayoutParams(relativeLayoutParam);

        //RelativeLayout sub
        RelativeLayout relativeLayoutSub = new RelativeLayout(this);
        RelativeLayout.LayoutParams relativeLayoutParamSub = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        relativeLayoutSub.setLayoutParams(relativeLayoutParamSub);
        relativeLayoutSub.setGravity(Gravity.CENTER);
        relativeLayoutSub.setId(R.id.rl);


        //ImageLayout
        ImageView imgView = new ImageView(this);
        imgView.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        imgView.setId(R.id.imgAvatar);
        imgView.setImageResource(R.mipmap.ic_launcher);

        //Text View
        TextView textView = new TextView(this);
        RelativeLayout.LayoutParams textViewParam = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textViewParam.addRule(RelativeLayout.CENTER_VERTICAL);
        textViewParam.addRule(RelativeLayout.RIGHT_OF, imgView.getId());
        textView.setLayoutParams(textViewParam);
        textView.setText("Hello ! This is my app! ");
        textView.setGravity(Gravity.CENTER);

        relativeLayoutSub.addView(imgView);
        relativeLayoutSub.addView(textView);

        //Button on click
        Button btnClick = new Button(this);
        RelativeLayout.LayoutParams btnClickParam = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        btnClickParam.addRule(RelativeLayout.CENTER_HORIZONTAL);
        btnClickParam.addRule(RelativeLayout.BELOW, relativeLayoutSub.getId());
        btnClick.setLayoutParams(btnClickParam);
        btnClick.setId(R.id.btnOnClick);
        btnClick.setText("On click! ");

        //Button Hihi
        Button btnHihi = new Button(this);
        RelativeLayout.LayoutParams btnHihiParam = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        btnHihiParam.addRule(RelativeLayout.CENTER_HORIZONTAL);
        btnHihiParam.addRule(RelativeLayout.BELOW, btnClick.getId());
        btnHihi.setLayoutParams(btnHihiParam);
        btnHihi.setText("Hi Hi !!! ");

        relativeLayoutRoot.addView(relativeLayoutSub);
        relativeLayoutRoot.addView(btnClick);
        relativeLayoutRoot.addView(btnHihi);
    }

    private void initLinearLayout() {
        //Linear Layout Root
        linearLayoutRoot = new LinearLayout(this);
        LinearLayout.LayoutParams linearLayoutParamsRoot = new LinearLayout.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        linearLayoutRoot.setOrientation(LinearLayout.VERTICAL);
        linearLayoutRoot.setLayoutParams(linearLayoutParamsRoot);

        //Linear Layout Second
        LinearLayout linearLayoutSecond = new LinearLayout(this);
        LinearLayout.LayoutParams linearLayoutParamSecond = new LinearLayout.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
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
    }
}
