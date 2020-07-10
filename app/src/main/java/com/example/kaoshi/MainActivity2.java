package com.example.kaoshi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import p.Longinp;
import view.LonginView;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener, LonginView {

    /**
     * 手机号
     */
    private EditText mShou;
    /**
     * 确认手机号
     */
    private EditText mQz;
    /**
     * 账户余额：
     */
    private TextView mText;
    /**
     * 取消
     */
    private Button mQu;
    /**
     * 确认兑换
     */
    private Button mQue;
    private Editable shou;
    private Editable qz;
    private RecyclerView mRecy;
    private ArrayList<Bean.DataBean.ListBean> listBeans;
    private MyRecyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Longinp longinp = new Longinp(this);
        longinp.setdata();
        initView();
    }

    private void initView() {
        mShou = (EditText) findViewById(R.id.shou);
        mQz = (EditText) findViewById(R.id.qz);
        shou = mShou.getText();
        qz = mQz.getText();
        mText = (TextView) findViewById(R.id.text);
        mQu = (Button) findViewById(R.id.qu);
        mQu.setOnClickListener(this);
        mQue = (Button) findViewById(R.id.que);
        mQue.setOnClickListener(this);
        mRecy = (RecyclerView) findViewById(R.id.Recy);
        mRecy.setLayoutManager(new LinearLayoutManager(this));
        listBeans = new ArrayList<>();
        adapter = new MyRecyAdapter(listBeans, this);
        mRecy.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.qu:
                Toast.makeText(this, "取消", Toast.LENGTH_SHORT).show();
                break;
            case R.id.que:

                    Intent intent = new Intent(this, MainActivity3.class);
                    startActivity(intent);
                break;
        }
    }

    @Override
    public void send(List<Bean.DataBean.ListBean> lists) {
         listBeans.addAll(lists);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void shouToast(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
}
