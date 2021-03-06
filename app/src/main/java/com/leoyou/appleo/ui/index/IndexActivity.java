package com.leoyou.appleo.ui.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.leoyou.appleo.R;
import com.leoyou.appleo.ui.adapter.ViewPagerAdapter;
import com.leoyou.appleo.ui.fragment.book.BookFragment;
import com.leoyou.appleo.ui.fragment.douban.DoubanFragment;
import com.leoyou.appleo.ui.fragment.index.AndroidFragment;
import com.leoyou.appleo.ui.fragment.index.FuliFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/4/20.
 */

public class IndexActivity extends AppCompatActivity {
    List<Fragment> fragments = new ArrayList<>();
    List<String> titles = new ArrayList<>();
    private TabLayout tablayout;
    private ViewPager viewpager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        initView();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.index_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("MVP项目");
        fragments.add(FuliFragment.newInstance(null));
        fragments.add(AndroidFragment.newInstance());
        fragments.add(DoubanFragment.newInstance());
        fragments.add(BookFragment.newInstance());
        titles.add("福利");
        titles.add("android");
        titles.add("电影");
        titles.add("书籍");
        tablayout = (TabLayout) findViewById(R.id.tablayout);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        tablayout.setupWithViewPager(viewpager);
        viewpager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragments, titles));
    }
}
