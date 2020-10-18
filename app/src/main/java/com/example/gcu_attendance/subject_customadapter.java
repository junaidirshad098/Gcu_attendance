package com.example.gcu_attendance;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class subject_customadapter extends ArrayAdapter<Subject> {

private Context context;
ArrayList<Subject> arrayListsub;


    public subject_customadapter(@NonNull Context context, ArrayList arr) {
        super(context, 0,arr);
        this.context=context;
this.arrayListsub=arr;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup vg) {

        if(view==null)
        {
view= LayoutInflater.from((getContext())).inflate(R.layout.subject_design,vg,false);
        }

final TextView txt_teacher_name=view.findViewById(R.id.teacher_name);
        final TextView txt_sub_name=view.findViewById(R.id.subjectname);
        final TextView txt_sec_name=view.findViewById(R.id.section_name);
        final TextView txt_sub_desc=view.findViewById(R.id.subject_desc);
txt_sub_name.setText(arrayListsub.get(position).getSub_name());
txt_teacher_name.setText(arrayListsub.get(position).getTeacher_name());
txt_sec_name.setText(arrayListsub.get(position).getSection_name());
txt_sub_desc.setText(arrayListsub.get(position).getSub_desc());

View view1=view.findViewById(R.id.subject_design1);
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(context,Attendence_activity.class);
                context.startActivity(intent);
               // Toast.makeText(context,"Hello",Toast.LENGTH_SHORT).show();
            }
        });
return  view;

    }
}
