package com.freelance.saravillarreal.globallogicexam.activities;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.freelance.saravillarreal.globallogicexam.R;

public class BaseActivity extends AppCompatActivity {

    static protected AlertDialog progressDialog;

    @TargetApi(Build.VERSION_CODES.M)
    public void showDialog() {
        if(progressDialog == null || !progressDialog.isShowing()){
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
            LayoutInflater inflater = this.getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.progress_bar, null);
            dialogBuilder.setView(dialogView);
            progressDialog = dialogBuilder.create();
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            progressDialog.setCancelable(false);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
        }
    }
    public void dismissDialog() {
        if(progressDialog != null && progressDialog.isShowing()){
            try {
                progressDialog.dismiss();
            }catch (Exception e){}
        }
    }
}
