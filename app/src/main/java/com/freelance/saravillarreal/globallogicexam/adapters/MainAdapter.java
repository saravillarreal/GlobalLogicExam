package com.freelance.saravillarreal.globallogicexam.adapters;

import android.app.Activity;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.freelance.saravillarreal.globallogicexam.R;
import com.freelance.saravillarreal.globallogicexam.beans.MockGlobal;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    public final static String TAG = "MainAdapter";
    Activity activity;
    List<MockGlobal> list;


    public MainAdapter (Activity activity, List<MockGlobal> list){
        this.activity = activity;
        this.list = list;
    }


    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        MainViewHolder carouselViewHolder = new MainViewHolder(view);
        return carouselViewHolder;
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, final int position) {


        Picasso.with(activity)
                .load(list.get(position).getImage())
                .into(holder.ivList);


        if (list.get(position).getTitle()!= null ){
            holder.txtTitle.setText(list.get(position).getTitle());
        }

        if (list.get(position).getDescription()!= null ){
            holder.txtDescription.setText(list.get(position).getDescription());
        }

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopup(list.get(position));
            }
        });
    }

    public void showPopup(MockGlobal mockGlobal) {
        View popupView = LayoutInflater.from(activity).inflate(R.layout.popup_detail_item, null);
        final PopupWindow popupWindow = new PopupWindow(popupView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        Button btnDismiss = (Button) popupView.findViewById(R.id.btn_dismiss);
        TextView title = (TextView) popupView.findViewById(R.id.txt_title);
        TextView description = (TextView) popupView.findViewById(R.id.txt_description);
        ImageView image = (ImageView) popupView.findViewById(R.id.iv_list);
        if (mockGlobal.getTitle() != null ){
            title.setText(mockGlobal.getTitle());
        }
        if (mockGlobal.getDescription() != null){
            description.setText(mockGlobal.getDescription());
        }
        Picasso.with(activity)
                .load(mockGlobal.getImage())
                .into(image);

        btnDismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

        popupWindow.showAsDropDown(popupView, 0, 0);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MainViewHolder extends RecyclerView.ViewHolder{
        ImageView ivList;
        TextView txtTitle, txtDescription;
        ConstraintLayout constraintLayout;

        public MainViewHolder(View itemView) {
            super(itemView);
            ivList = (ImageView) itemView.findViewById(R.id.iv_list);
            txtTitle = (TextView) itemView.findViewById(R.id.txt_title);
            txtDescription = (TextView) itemView.findViewById(R.id.txt_description);
            constraintLayout = (ConstraintLayout) itemView.findViewById(R.id.container_item);
        }
    }
}
