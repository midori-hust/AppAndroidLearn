package com.example.midori.project1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static android.icu.util.Calendar.getInstance;

public class MainActivity extends AppCompatActivity {
    private ListView lv_contact;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        lv_contact = (ListView) findViewById(R.id.list_contact);
        ArrayList<Contact> arrContact = new ArrayList<>();

        Contact contact1 = new Contact("Mua Quyt Chin","1010101102220",Color.BLACK);
        Contact contact2 = new Contact("Mua Quyt Chi","1010101102220",Color.GREEN);
        Contact contact3 = new Contact("Mua Quyt Chia xa","1010101102220",Color.DKGRAY);
        Contact contact4 = new Contact("Mua Quyt Chi Chi","1010101102220",Color.BLUE);
        Contact contact5 = new Contact("Mua Quyt Chin chu","1010101102220", Color.BLACK);
        arrContact.add(contact1);
        arrContact.add(contact2);
        arrContact.add(contact3);
        arrContact.add(contact4);
        arrContact.add(contact5);

        CustomAdapter arrayAdapter = new CustomAdapter(this, R.layout.learn_view, arrContact);
        lv_contact.setAdapter(arrayAdapter);
    }

}
