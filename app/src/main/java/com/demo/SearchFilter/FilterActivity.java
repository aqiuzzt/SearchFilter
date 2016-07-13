package com.demo.SearchFilter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.SearchFilter.Filterfragment.FilterFragment;

public class FilterActivity extends FragmentActivity implements View.OnClickListener {
    private static final String LOG_TAG = "FilterActivity";
    private DrawerLayout mDrawerLayout;
    private RelativeLayout drawer_content;
    private TextView slide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        initView();
        initData();
    }

    private void initView() {
        slide = (TextView) findViewById(R.id.slide);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer_content = (RelativeLayout) findViewById(R.id.drawer_content);
        slide.setOnClickListener(this);
    }

    private void initData() {
        mDrawerLayout.setDrawerListener(myDrawerListener);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.slide:
                //显示默认fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.drawer_content, new FilterFragment()).commit();
                mDrawerLayout.openDrawer(drawer_content);//打开抽屉内容
                Toast.makeText(this, "点击筛选按钮", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * DrawerLayout监听器
     */
    DrawerLayout.DrawerListener myDrawerListener = new DrawerLayout.DrawerListener() {
        //drawlayout偏移
        @Override
        public void onDrawerSlide(View drawerView, float slideOffset) {
            Log.d(LOG_TAG, "slideOffset:" + String.format("%.2f", slideOffset));

        }

        @Override
        public void onDrawerOpened(View drawerView) {
            Log.d(LOG_TAG, "onDrawerOpened:");

        }

        @Override
        public void onDrawerClosed(View drawerView) {
            Log.d(LOG_TAG, "onDrawerClosed:");

        }

        @Override
        public void onDrawerStateChanged(int newState) {
            //在IDLE进行数据更新
            switch (newState) {
                case DrawerLayout.STATE_IDLE:
                    Toast.makeText(FilterActivity.this, "STATE_IDLE", Toast.LENGTH_SHORT).show();
                    break;
                case DrawerLayout.STATE_DRAGGING:
//                    Toast.makeText(FilterActivity.this,"STATE_DRAGGING",Toast.LENGTH_SHORT).show();
                    break;
                case DrawerLayout.STATE_SETTLING:
//                    Toast.makeText(FilterActivity.this,"STATE_SETTLING",Toast.LENGTH_SHORT).show();
                    break;
            }
            Log.d(LOG_TAG, "onDrawerStateChanged:");


        }
    };

}
