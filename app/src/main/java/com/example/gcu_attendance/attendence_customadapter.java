package com.example.gcu_attendance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class attendence_customadapter extends ArrayAdapter<Student> {
private boolean mark;
Context context;
ArrayList<Student> studentArrayList;
    public attendence_customadapter(@NonNull Context context,ArrayList<Student> studentArrayList) {
        super(context, 0,studentArrayList);
        this.context=context;
        this.studentArrayList=studentArrayList;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View view, @NonNull ViewGroup vg) {

        if(view==null)
        {
            view= LayoutInflater.from((getContext())).inflate(R.layout.user_attendence,vg,false);
        }
final TextView txtindex=view.findViewById(R.id.textindex);
        final TextView txtstdname=view.findViewById(R.id.textstd_name);
        final TextView txtstdrollno=view.findViewById(R.id.textstd_roll_no);
        final CheckBox checkBoxmark=view.findViewById(R.id.checkBox);
        String index=String.valueOf(position);

        txtindex.setText(index);
        txtstdname.setText(studentArrayList.get(position).getStd_name());
        txtstdrollno.setText(studentArrayList.get(position).getStd_roll_number());
        checkBoxmark.setChecked(studentArrayList.get(position).isMark());


        checkBoxmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             mark=checkBoxmark.isChecked();
             studentArrayList.get(position).setMark(mark);

            }
        });

        return  view;

    }


}
