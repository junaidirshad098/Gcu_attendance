package com.example.gcu_attendance;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class subject_customadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Subject> itemarray = new ArrayList<>();

    private Context ctx;

    //-------------------
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    public interface OnItemClickListener {
        void onItemClick(View view, Subject obj, int position);
    }
//-------------------


    public subject_customadapter(Context context, List<Subject> items) {
        this.itemarray = items;
        ctx = context;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {

        public TextView txt_sub_name,txt_tec_name,txt_sec,txt_sub_desc;
        public LinearLayout lyt_parent;

        public OriginalViewHolder(View v) {
            super(v);   //call parent constructor
            //View v is parent class of all layout
            //linear layout-->ViewGrup-->view
            //in this constructor we only find every element of layout that we pass
            txt_sub_name=v.findViewById(R.id.subjectname);
            txt_tec_name =  v.findViewById(R.id.teacher_name);
            txt_sec=v.findViewById(R.id.section_name);
            txt_sub_desc=v.findViewById(R.id.subject_desc);
            lyt_parent=v.findViewById(R.id.card_design);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.subject_design, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
            OriginalViewHolder view = (OriginalViewHolder) holder;

            Subject obj = itemarray.get(position);

            view.txt_sub_name.setText(obj.getSub_name());
            view.txt_tec_name.setText(obj.getTeacher_name());
            view.txt_sec.setText(obj.getSection_name());
            view.txt_sub_desc.setText(obj.getSub_desc());
            // Tools.displayImageRound(ctx, view.image, obj.image);
            view.lyt_parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(view, itemarray.get(position), position);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return itemarray.size();
    }
    public Subject getItem(int position) {
        return itemarray.get(position);
    }


}