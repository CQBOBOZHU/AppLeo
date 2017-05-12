package com.leoyou.appleo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.leoyou.appleo.bean.OrderBean;
import com.leoyou.appleo.net.CallBack;
import com.leoyou.appleo.net.HttpUtil;
import com.leoyou.appleo.photo.ImageLoader;
import com.leoyou.appleo.ui.adapter.BaseTaskAdapter;
import com.leoyou.appleo.ui.adapter.BaseViewHolder;
import com.leoyou.appleo.ui.index.IndexActivity;
import com.leoyou.appleo.ui.login.LoginActivity;
import com.leoyou.appleo.ui.wight.PullRefreshListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    PullRefreshListView listView;
    ImageView imageView;

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
        imageView= (ImageView) findViewById(R.id.image);
        ImageLoader.disImage1(this,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1494332381118&di=5ebd42a77c3df6ff02d253619c0d61a4&imgtype=0&src=http%3A%2F%2Fb.hiphotos.baidu.com%2Fzhidao%2Fwh%253D450%252C600%2Fsign%3Dca1fd2eb054f78f0805e92f74c012663%2Fbd3eb13533fa828b97ecd15cfb1f4134960a5a45.jpg",imageView);
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
