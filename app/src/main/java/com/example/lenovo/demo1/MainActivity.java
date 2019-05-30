package com.example.lenovo.demo1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import adapter.MyAdapter;
import bean.DatasBean;
import presenter.PresenterImpl;
import view.IView;

public class MainActivity extends AppCompatActivity implements IView {

    private RecyclerView mRec;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initMvp();
    }

    private void initMvp() {
        PresenterImpl presenter = new PresenterImpl(this);
        presenter.updataData();
    }

    private void initView() {
        mRec = (RecyclerView) findViewById(R.id.rec);

        mRec.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(this);
        mRec.setAdapter(adapter);
    }

    private static final String TAG = "MainActivity";
    @Override
    public void updataSuccess(List<DatasBean> datasBeans) {
        adapter.addData(datasBeans);
    }

    @Override
    public void updaraError(String error) {
        Log.d(TAG, "updaraError: "+error);
    }
}
