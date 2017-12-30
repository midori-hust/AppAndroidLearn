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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CalculatorController calculator;

    private LinearLayout linearLayoutRoot;
    private RelativeLayout relativeLayoutRoot;

    private EditText edtNumberOperation;
    private TextView tvResult;

    private Button btnNumber0;
    private Button btnNumber1;
    private Button btnNumber2;
    private Button btnNumber3;
    private Button btnNumber4;
    private Button btnNumber5;
    private Button btnNumber6;
    private Button btnNumber7;
    private Button btnNumber8;
    private Button btnNumber9;

    private Button btnPoint;

    private Button btnPlus;
    private Button btnMinus;
    private Button btnMultiplication;
    private Button btnDivision;

    private Button btnClear;
    private Button btnAlLClear;
    private Button btnResult;


    //Handle onclick
    // handle String on number
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        calculator = new CalculatorController();
        setContentView(R.layout.calculator);
        initWidget();
        setEventClickView();
    }

    public void initWidget() {
        edtNumberOperation = (EditText) findViewById(R.id.edt_operation);
        tvResult =(TextView) findViewById(R.id.tv_result);

        btnNumber0 = (Button) findViewById(R.id.btn_number0);
        btnNumber1 = (Button) findViewById(R.id.btn_number1);
        btnNumber2 = (Button) findViewById(R.id.btn_number2);
        btnNumber3 = (Button) findViewById(R.id.btn_number3);
        btnNumber4 = (Button) findViewById(R.id.btn_number4);
        btnNumber6 = (Button) findViewById(R.id.btn_number5);
        btnNumber5 = (Button) findViewById(R.id.btn_number6);
        btnNumber7 = (Button) findViewById(R.id.btn_number7);
        btnNumber8 = (Button) findViewById(R.id.btn_number8);
        btnNumber9 = (Button) findViewById(R.id.btn_number9);

        btnPoint = (Button) findViewById(R.id.btn_point);

        btnNumber0 = (Button) findViewById(R.id.btn_number0);
        btnPlus = (Button) findViewById(R.id.btn_plus);
        btnMinus = (Button) findViewById(R.id.btn_minus);
        btnMultiplication = (Button) findViewById(R.id.btn_multiplication);
        btnDivision = (Button) findViewById(R.id.btn_division);

        btnClear = (Button) findViewById(R.id.btn_clear);
        btnAlLClear = (Button) findViewById(R.id.btn_all_clear);
        btnResult = (Button) findViewById(R.id.btn_result);

    }

    public void setEventClickView() {
        btnNumber0.setOnClickListener(this);
        btnNumber1.setOnClickListener(this);
        btnNumber2.setOnClickListener(this);
        btnNumber3.setOnClickListener(this);
        btnNumber4.setOnClickListener(this);
        btnNumber5.setOnClickListener(this);
        btnNumber6.setOnClickListener(this);
        btnNumber7.setOnClickListener(this);
        btnNumber8.setOnClickListener(this);
        btnNumber9.setOnClickListener(this);

        btnPoint.setOnClickListener(this);

        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMultiplication.setOnClickListener(this);
        btnDivision.setOnClickListener(this);

        btnClear.setOnClickListener(this);
        btnAlLClear.setOnClickListener(this);
        btnResult.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_number0:
                System.out.print("0");
                edtNumberOperation.append("0");
                break;
            case R.id.btn_number1:
                edtNumberOperation.append("1");
                break;
            case R.id.btn_number2:
                edtNumberOperation.append("2");
                break;
            case R.id.btn_number3:
                edtNumberOperation.append("3");
                break;
            case R.id.btn_number4:
                edtNumberOperation.append("4");
                break;
            case R.id.btn_number5:
                edtNumberOperation.append("5");
                break;
            case R.id.btn_number6:
                edtNumberOperation.append("6");
                break;
            case R.id.btn_number7:
                edtNumberOperation.append("7");
                break;
            case R.id.btn_number8:
                edtNumberOperation.append("8");
                break;
            case R.id.btn_number9:
                edtNumberOperation.append("9");
                break;

            case R.id.btn_point:
                edtNumberOperation.append(".");
                break;

            case R.id.btn_plus:
                edtNumberOperation.append("+");
                break;
            case R.id.btn_minus:
                edtNumberOperation.append("-");
                break;
            case R.id.btn_multiplication:
                edtNumberOperation.append("*");
                break;
            case R.id.btn_division:
                edtNumberOperation.append("/");
                break;

            case R.id.btn_clear:
//                String after_clear;
//                after_clear = edtNumberOperation.getText().toString();
//                after_clear = after_clear.substring(0,after_clear.length()-1);
//                edtNumberOperation.setText(after_clear);
                BaseInputConnection textFieldConnection = new BaseInputConnection(edtNumberOperation, true);
                textFieldConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN,KeyEvent.KEYCODE_DEL));
                break;
            case R.id.btn_all_clear:
                edtNumberOperation.setText("");
                break;
            case R.id.btn_result:
                String mathExpression = edtNumberOperation.getText().toString();
                CalculatorController handleOperation = new CalculatorController();
                if(handleOperation.invalidStringMathExpression(mathExpression)){
                    tvResult.setText(handleOperation.getResult());
                }else {

                }
                break;
            default:

                break;
        }
    }
    //TODO string to number ?
    //String to number + operation(+,-,*,/) to stack
    //12 * 13 + 14 - 16



    //a1:12|*|13|+|14|-|16

    //a2:156|+|14|-|16

    //String to number + operation(+,-) to stack

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
