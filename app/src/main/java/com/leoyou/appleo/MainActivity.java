package com.leoyou.appleo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.leoyou.appleo.bean.OrderBean;
import com.leoyou.appleo.net.CallBack;
import com.leoyou.appleo.net.HttpUtil;
import com.leoyou.appleo.ui.adapter.BaseTaskAdapter;
import com.leoyou.appleo.ui.adapter.BaseViewHolder;
import com.leoyou.appleo.ui.index.IndexActivity;
import com.leoyou.appleo.ui.login.LoginActivity;
import com.leoyou.appleo.ui.wight.PullRefreshListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    PullRefreshListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (PullRefreshListView) findViewById(R.id.PullRefreshListView);
        initData();
        listView.setAdapter(new BaseTaskAdapter<String>(mData, this, R.layout.list_item) {
            @Override
            public void convert(BaseViewHolder bViewHoder, String s, int position) {
                bViewHoder.setText(R.id.list_item_tv, s);
            }
        });
    }

    List<String> mData = new ArrayList<>();

    public void initData() {
        for (int i = 0; i < 50; i++) {
            mData.add("这是数据====" + i);
        }
    }


    public void onIndex(View view) {
        Intent mIntent = new Intent(this, IndexActivity.class);
        startActivity(mIntent);
    }

    public void onLogin(View view) {
        Intent mIntent = new Intent(this, LoginActivity.class);
        startActivity(mIntent);
    }

    public void getOrderList(View view) {
        HttpUtil.getPhone("5", "ec008e8d07924448a71a2c0915775191", "0", 10, 1, new CallBack<OrderBean>() {

            @Override
            public void onSuccess(OrderBean o) {
                Log.v("this", o.getMSG() + o.getRESULT() + o.getDATA());
            }

            @Override
            public void onError(Throwable e) {
                Log.v("this", e.getMessage());
            }

            @Override
            public void onCompleted() {
                Log.v("this", "onCompleted");
            }
        });
    }
}
