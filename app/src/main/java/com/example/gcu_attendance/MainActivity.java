package com.example.gcu_attendance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView subject_list;
private Context context;
    private BottomSheetBehavior mBehavior;
    private BottomSheetDialog mBottomSheetDialog;
    private View bottom_sheet;

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





        bottom_sheet = findViewById(R.id.bottom_sheet);
        mBehavior = BottomSheetBehavior.from(bottom_sheet);
    }

    private void  showBottomSheetDialog() {
        if (mBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            mBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }

        final View view = getLayoutInflater().inflate(R.layout.sheet_list, null);

        ((View) view.findViewById(R.id.lyt_preview)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Preview '"  + "' clicked", Toast.LENGTH_SHORT).show();
            }
        });





        mBottomSheetDialog = new BottomSheetDialog(this);
        mBottomSheetDialog.setContentView(view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mBottomSheetDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        mBottomSheetDialog.show();
        mBottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                mBottomSheetDialog = null;
            }
        });
    }

}