package com.brioal.messagedemo;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.brioal.messagedemo.adapter.MessageListAdapter;
import com.brioal.messagedemo.entity.MessageEntity;
import com.brioal.messagedemo.util.DataLoader;
import com.brioal.messagedemo.util.StatusBarUtils;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.main_toolBar)
    Toolbar mToolBar;
    @Bind(R.id.main_recyclerView)
    RecyclerView mRecyclerView;
    @Bind(R.id.main_et_msg)
    EditText mEtMsg;
    @Bind(R.id.main_btn_send)
    Button mBtnSend;

    private Context mContext;
    private List<MessageEntity> mList;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                setView();
            } else if (msg.what == 1) {
                mRecyclerView.smoothScrollToPosition(mRecyclerView.getBottom());
//                mRecyclerView.scrollToPosition(mList.size() - 1);
                mAdapter.notifyDataSetChanged();
            }
        }
    };
    private MessageListAdapter mAdapter;

    private void setView() {
        mAdapter = new MessageListAdapter(mContext, mList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mContext = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initBar();
        initData();
        initView();
    }

    private void initView() {
        mBtnSend.setOnClickListener(this);
    }

    private void initBar() {
        mToolBar.setTitle("消息窗口");
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        StatusBarUtils.setColor(this, getResources().getColor(R.color.colorPrimary));
    }

    private void initData() {
        mList = DataLoader.getMessages();
        mHandler.sendEmptyMessage(0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_btn_send:
                MessageEntity entityMine = new MessageEntity(mList.size(), mEtMsg.getText().toString(), 1);
                mList.add(entityMine);
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        MessageEntity entityOther = new MessageEntity(mList.size(), "你你你你你你你你你你你你你你你你你你你你你你你你你你", 0);
                        mList.add(entityOther);
                        mHandler.sendEmptyMessage(1);
                    }
                }, 1000);
                mHandler.sendEmptyMessage(1);
                mEtMsg.setText("");
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
