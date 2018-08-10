package com.freelance.saravillarreal.globallogicexam.views;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.freelance.saravillarreal.globallogicexam.R;
import com.freelance.saravillarreal.globallogicexam.activities.BaseActivity;
import com.freelance.saravillarreal.globallogicexam.adapters.MainAdapter;
import com.freelance.saravillarreal.globallogicexam.beans.MockGlobal;
import com.freelance.saravillarreal.globallogicexam.interfaces.MainPresenterInterface;
import com.freelance.saravillarreal.globallogicexam.interfaces.MainViewInterface;
import com.freelance.saravillarreal.globallogicexam.presenters.MainPresenterImpl;

import java.util.List;

public class MainActivity extends BaseActivity implements MainViewInterface {



    private MainPresenterInterface presenter;
    RecyclerView recyclerView;
    MainAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        presenter = new MainPresenterImpl(this);
        showDialog();
        presenter.callList();
    }

    @Override
    public void showItem(List<MockGlobal> list) {
        dismissDialog();
        mAdapter = new MainAdapter(this, list);
        recyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
    }

    @Override
    public void showErrorService() {
        dismissDialog();
        Toast.makeText(this, R.string.error_server, Toast.LENGTH_SHORT).show();
    }
}
