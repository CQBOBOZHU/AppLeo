package com.leoyou.appleo.ui.bookdetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.leoyou.appleo.R;
import com.leoyou.appleo.bean.BookBean;
import com.leoyou.appleo.photo.ImageLoader;
import com.leoyou.appleo.ui.adapter.BaseRecycleViewAdapter;
import com.leoyou.appleo.ui.adapter.BaseRecycleViewHolder;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/5/8.
 * <p>
 * 数据是直接传递过来的 所以不用mvp模式。 用这个来做material design
 */
public class BookDetailsActivity extends AppCompatActivity {
    BookBean.BooksBean booksBean;
    private Toolbar toolbar;
    private AppBarLayout appBarLayout;
    private CollapsingToolbarLayout collapsingTopBarLayout;
    private RecyclerView recyclerView;
    private ImageView book_img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookdetails);
        booksBean = (BookBean.BooksBean) getIntent().getSerializableExtra("data");
        initView();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_exit);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle(booksBean.getTitle());
        appBarLayout = (AppBarLayout) findViewById(R.id.appbar_layout);
//        collapsingTopBarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingTopBarLayout);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<String> list = new ArrayList<>();
        list.add(booksBean.getAuthor_intro() + booksBean.getSummary());
        recyclerView.setAdapter(new BaseRecycleViewAdapter<String, BaseRecycleViewHolder>(R.layout.item_recycler, list) {
            @Override
            public void onBdViewHolder(BaseRecycleViewHolder viewHolder, int position) {
                viewHolder.setText(R.id.item_tv, mData.get(position));
            }
        });
        book_img = (ImageView) findViewById(R.id.book_img);
        ImageLoader.disImage(this,booksBean.getImage(),book_img);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
