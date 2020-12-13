package com.example.gcu_attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

public class Attendence_activity extends AppCompatActivity {
private ListView list_atd_std;
private CheckBox select_all_check;
boolean mark=false;
private Button btn_att_submit;
ImageButton btn_call;
private  int std_count_prsent,std_count_absent;
    private int mYear, mMonth, mDay, mHour, mMinute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendence_activity);
list_atd_std=findViewById(R.id.listviewattendence);
select_all_check=findViewById(R.id.checkall);
btn_att_submit=findViewById(R.id.button_submit_atte);
btn_call=findViewById(R.id.button_cal);
final ArrayList<Student> studentArrayList=new ArrayList<>();
Student std_obj=new Student("Muhammad Umair","0283-BSCS-16",false);
        Student std_obj1=new Student("Muhammad Umair","0283-BSCS-16",true);
        Student std_obj2=new Student("Uzair Baber","0202-BSCS-16",false);
        Student std_obj3=new Student("Hamza Amir","1-BSCS-16",true);
        studentArrayList.add(new Student("Hamza Amir","1-BSCS-16",true));
        studentArrayList.add(new Student("Hamza","1-BSCS-16",true));
        studentArrayList.add(new Student("Jamil","0283-BSCS-16",false));
        studentArrayList.add(std_obj);studentArrayList.add(std_obj2);studentArrayList.add(std_obj1);
        studentArrayList.add(new Student("Hamza Amir","1-BSCS-16",true));
        studentArrayList.add(new Student("Hamza Amir","1-BSCS-16",true));
        studentArrayList.add(std_obj3);
        studentArrayList.add(new Student("Muhammad Ali","031-BSCS-19",true));
        studentArrayList.add(new Student("Sameer","0283-BSCS-16",false));
        studentArrayList.add(new Student("Muhammad Umair","0283-BSCS-16",false));
        studentArrayList.add(new Student("Muhammad Ali","031-BSCS-19",true));
        studentArrayList.add(new Student("Sameer","0283-BSCS-16",false));
        studentArrayList.add(new Student("Muhammad Umair","0283-BSCS-16",false));
        studentArrayList.add(new Student("Muhammad Ali","031-BSCS-19",true));
        studentArrayList.add(new Student("Sameer","0283-BSCS-16",false));
        studentArrayList.add(new Student("Muhammad Umair","0283-BSCS-16",false));
        studentArrayList.add(new Student("Muhammad Ali","031-BSCS-19",true));
        studentArrayList.add(new Student("Sameer","0283-BSCS-16",false));
        studentArrayList.add(new Student("Muhammad Umair","0283-BSCS-16",false));


        final attendence_customadapter attendence_customadapter=new attendence_customadapter(getApplicationContext(),studentArrayList);
list_atd_std.setAdapter(attendence_customadapter);

select_all_check.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

      mark=  select_all_check.isChecked();

        Toast.makeText(Attendence_activity.this,mark+"click",Toast.LENGTH_SHORT).show();
       for(int i=0;i<studentArrayList.size();i++)
       {
           studentArrayList.get(i).setMark(mark);

       }
        attendence_customadapter.notifyDataSetChanged();
    }
});
btn_att_submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        std_count_absent=0;
        std_count_prsent=0;
        for(int j=0;j<studentArrayList.size();j++)
        {
            if(studentArrayList.get(j).isMark()) {
                std_count_prsent += 1;
            }else {
                std_count_absent += 1;
            }
            }

        Toast.makeText(Attendence_activity.this,"Present: "+std_count_prsent+" Absent: "+std_count_absent,Toast.LENGTH_SHORT).show();

//        Intent intent=new Intent(Attendence_activity.this,MainActivity.class);
//        startActivity(intent);
//
    }
});


btn_call.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
date();
    }
});





    }


public void date()
{
    final Calendar c = Calendar.getInstance();
    mYear = c.get(Calendar.YEAR);
    mMonth = c.get(Calendar.MONTH);
    mDay = c.get(Calendar.DAY_OF_MONTH);


    DatePickerDialog datePickerDialog = new DatePickerDialog(this,
            new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {

                    //selectDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
//Toast.makeText(Attendence_activity.this,mYear+mMonth+mDay,Toast.LENGTH_SHORT).show();
                }
            }, mYear, mMonth, mDay);

    datePickerDialog.show();
}






}