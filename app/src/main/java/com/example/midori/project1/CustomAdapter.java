package com.example.midori.project1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by midori on 2018/01/11.
 */

public class CustomAdapter extends ArrayAdapter<Contact> {
    private Context context;
    private int resource;
    private ArrayList<Contact> arrContact;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Contact> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.arrContact = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        if (viewHolder != null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.activity_row_item,parent,false);

            viewHolder.tv_color = convertView.findViewById(R.id.tv_color);
            viewHolder.tv_name = convertView.findViewById(R.id.tv_name);
            viewHolder.tv_number = convertView.findViewById(R.id.tv_number);
            convertView.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Contact contact = arrContact.get(position);

        viewHolder.tv_color.setBackgroundColor(contact.getContactColor());
        viewHolder.tv_color.setText((position+1)+"");
        viewHolder.tv_name.setText(contact.getContactName());
        viewHolder.tv_number.setText(contact.getContactNumber());

        return convertView;
    }
    //Tao mot doi tuong view de luu lai
    public class ViewHolder {
        TextView tv_name, tv_number,tv_color;

    }

}
