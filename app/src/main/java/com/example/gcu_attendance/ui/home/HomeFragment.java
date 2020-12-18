package com.example.gcu_attendance.ui.home;

import android.app.ActionBar;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gcu_attendance.Attendence_activity;
import com.example.gcu_attendance.CreateTeam_activity;
import com.example.gcu_attendance.MainActivity;
import com.example.gcu_attendance.R;
import com.example.gcu_attendance.Student;
import com.example.gcu_attendance.Subject;
import com.example.gcu_attendance.subject_customadapter;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.Serializable;
import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView subject_list;
    private Context context;
    private BottomSheetBehavior mBehavior;
    private BottomSheetDialog mBottomSheetDialog;
    public View bottom_sheet;
    public Button btn_create_team;
    public static ArrayList<Subject> subjectArrayList;
    private subject_customadapter subjectCustomadapter;
    private ImageButton imgbtn_check;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        subject_list = root.findViewById(R.id.subject_list1);
        context = getContext();
//        subject_list.setLayoutManager(new LinearLayoutManager(context));
        subject_list.setLayoutManager(new GridLayoutManager(context,2));
        subject_list.setHasFixedSize(true);


        subjectArrayList = new ArrayList<>();
        Subject sub_obj = new Subject("Programming Fundamentals", "E1", "Atif Ishaq", "Programming involves activities such as analysis, developing understanding, generating algorithms...");
        Subject sub_obj1 = new Subject("Database", "E2", "Hafeez", "A structured set of data held in a computer, especially one that is accessible in various ways");

        subjectArrayList.add(sub_obj);
        subjectArrayList.add(sub_obj);
        subjectArrayList.add(sub_obj1);
//        subjectArrayList.add(sub_obj);
//        subjectArrayList.add(sub_obj1);
//        subjectArrayList.add(sub_obj);
//        subjectArrayList.add(sub_obj1);
//        subjectArrayList.add(sub_obj);
//        subjectArrayList.add(sub_obj1);

        subjectCustomadapter = new subject_customadapter(context, subjectArrayList);
        subject_list.setAdapter(subjectCustomadapter);

        bottom_sheet = root.findViewById(R.id.bottom_sheet);
btn_create_team=root.findViewById(R.id.button_create_team);

        subjectCustomadapter.setOnItemClickListener(new subject_customadapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Subject obj, int pos) {   //override the interface method and we define the defination
              Toast.makeText(getContext(),"Home"+pos,Toast.LENGTH_SHORT).show();
              showBottomSheetDialog();
            }
        });
        btn_create_team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m1();
            }
        });

        return root;


    }

    private void showBottomSheetDialog() {
//        mBehavior = BottomSheetBehavior.from(bottom_sheet);
//        if (mBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
//            mBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
//        }

        final View view = getLayoutInflater().inflate(R.layout.sheet_list, null);

        ((View) view.findViewById(R.id.lyt_preview03)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Preview '" + "' clicked", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context,Attendence_activity.class);
                mBottomSheetDialog.dismiss();
context.startActivity(intent);
//mBottomSheetDialog.dismiss();
            }
        });
        mBottomSheetDialog = new BottomSheetDialog(context);
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

    public void m1(){
        Intent intent=new Intent(context, CreateTeam_activity.class);


        //intent.putExtra("arr",arrayList);

//
//        startActivity(intent);

//        subjectArrayList.add(new Subject("Physics","A","Ali","kahsk"));
//        subjectCustomadapter.notifyDataSetChanged();
//        Log.d("name",subjectArrayList.get(1).getTeacher_name());
//        Log.d("size", String.valueOf(subjectArrayList.size()));
        showBottomSheetDialogCreateteam();
    }

    private void showBottomSheetDialogCreateteam() {
//        mBehavior = BottomSheetBehavior.from(bottom_sheet);
//        if (mBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
//            mBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
//        }

        final View view = getLayoutInflater().inflate(R.layout.fragment_bottom_sheet_dialog_full, null);
        ImageButton btn_close=view.findViewById(R.id.bt_close);
        final EditText edt_sub_name=view.findViewById(R.id.bts_sub_name);
        final EditText edt_sec_name=view.findViewById(R.id.bts_sec_name);
        final EditText edt_sub_desc=view.findViewById(R.id.bts_sub_desc);
        edt_sub_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Full" + " clicked", Toast.LENGTH_SHORT).show();
//                Intent intent=new Intent(context,Attendence_activity.class);
//                context.startActivity(intent);
            }
        });
        view.findViewById(R.id.img_button_check).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Checked '" + "' clicked", Toast.LENGTH_SHORT).show();
//                mBottomSheetDialog.cancel();
                Subject sbobj=new Subject(edt_sub_name.getText().toString(),edt_sec_name.getText().toString(),"Mr Hafeez",edt_sub_desc.getText().toString());

//                subjectArrayList.add(new Subject("Physics","A","Ali","kahsk"));
subjectArrayList.add(sbobj);
                subjectCustomadapter.notifyDataSetChanged();
                mBottomSheetDialog.dismiss();
//                mBottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
//                    @Override
//                    public void onDismiss(DialogInterface dialog) {
//                        mBottomSheetDialog = null;
//                    }
//                });
            }
        });
       btn_close.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               mBottomSheetDialog.dismiss();
           }
       });
        mBottomSheetDialog = new BottomSheetDialog(context);
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