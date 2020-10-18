package com.example.gcu_attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private ListView subject_list;
private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
subject_list=findViewById(R.id.subject_list);
context=MainActivity.this;
        ArrayList<Subject> subjectArrayList=new ArrayList<>();
Subject sub_obj=new Subject("Programming Fundamentals","E1","Atif Ishaq","Programming involves activities such as analysis, developing understanding, generating algorithms...");
        Subject sub_obj1=new Subject("Database","E2","Hafeez","A structured set of data held in a computer, especially one that is accessible in various ways");

subjectArrayList.add(sub_obj);subjectArrayList.add(sub_obj);
        subjectArrayList.add(sub_obj1);subjectArrayList.add(sub_obj);
        subjectArrayList.add(sub_obj1);subjectArrayList.add(sub_obj);
        subjectArrayList.add(sub_obj1);subjectArrayList.add(sub_obj);subjectArrayList.add(sub_obj1);

subject_customadapter subjectCustomadapter=new subject_customadapter(context,subjectArrayList);
subject_list.setAdapter(subjectCustomadapter);
    }
}