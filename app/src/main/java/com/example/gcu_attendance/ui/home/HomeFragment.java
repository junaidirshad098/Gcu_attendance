package com.example.gcu_attendance.ui.home;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gcu_attendance.Attendence_activity;
import com.example.gcu_attendance.MainActivity;
import com.example.gcu_attendance.R;
import com.example.gcu_attendance.Subject;
import com.example.gcu_attendance.subject_customadapter;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView subject_list;
    private Context context;
    private BottomSheetBehavior mBehavior;
    private BottomSheetDialog mBottomSheetDialog;
    public View bottom_sheet;
    public Button btn_create_team;

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
        subject_list.setLayoutManager(new LinearLayoutManager(context));
        subject_list.setHasFixedSize(true);


        ArrayList<Subject> subjectArrayList = new ArrayList<>();
        Subject sub_obj = new Subject("Programming Fundamentals", "E1", "Atif Ishaq", "Programming involves activities such as analysis, developing understanding, generating algorithms...");
        Subject sub_obj1 = new Subject("Database", "E2", "Hafeez", "A structured set of data held in a computer, especially one that is accessible in various ways");

        subjectArrayList.add(sub_obj);
        subjectArrayList.add(sub_obj);
        subjectArrayList.add(sub_obj1);
        subjectArrayList.add(sub_obj);
        subjectArrayList.add(sub_obj1);
        subjectArrayList.add(sub_obj);
        subjectArrayList.add(sub_obj1);
        subjectArrayList.add(sub_obj);
        subjectArrayList.add(sub_obj1);

        subject_customadapter subjectCustomadapter = new subject_customadapter(context, subjectArrayList);
        subject_list.setAdapter(subjectCustomadapter);

        bottom_sheet = root.findViewById(R.id.bottom_sheet);
btn_create_team=root.findViewById(R.id.button_create_team);

        subjectCustomadapter.setOnItemClickListener(new subject_customadapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Subject obj, int pos) {
              Toast.makeText(getContext(),"Home",Toast.LENGTH_SHORT).show();
              showBottomSheetDialog();
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

        ((View) view.findViewById(R.id.lyt_preview)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Preview '" + "' clicked", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context,Attendence_activity.class);
context.startActivity(intent);
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