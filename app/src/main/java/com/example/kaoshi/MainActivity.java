package com.example.kaoshi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mTool;
    private EditText mEdit;
    /**
     * 进入兑换页
     */
    private Button mHuan;
    private String a="111111";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTool = (Toolbar) findViewById(R.id.Tool);
        setSupportActionBar(mTool);
        mEdit = (EditText) findViewById(R.id.edit);
        mHuan = (Button) findViewById(R.id.huan);
        mHuan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.huan:
                Intent intent = new Intent(this,MainActivity2.class);
                startActivity(intent);
                break;
        }
    }
}
