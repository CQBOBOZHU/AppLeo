package com.leoyou.appleo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.leoyou.appleo.ui.index.IndexActivity;
import com.leoyou.appleo.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onIndex(View view) {
        Intent mIntent = new Intent(this, IndexActivity.class);
        startActivity(mIntent);
    }

    public void onLogin(View view) {
        Intent mIntent = new Intent(this, LoginActivity.class);
        startActivity(mIntent);
    }
}
