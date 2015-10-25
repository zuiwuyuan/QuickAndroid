package com.lnyp.quickandroid.page;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.lnyp.quickandroid.R;
import com.lnyp.quickandroid.util.ViewPagerHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 新手导航页
 *
 * @author lining
 */
public class GudieActivity extends BaseActivity {

    private List<View> views = null;

    @Bind(R.id.viewpager)
    public ViewPager mViewPager;
    @Bind(R.id.dots_parent)
    public LinearLayout viewPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_guide);

        ButterKnife.bind(this);

        this.initDatas();
    }

    /**
     * 初始化数据
     */
    private void initDatas() {
        views = new ArrayList<View>();

        View view1 = LayoutInflater.from(this).inflate(R.layout.page_guide_first, null);
        View view2 = LayoutInflater.from(this).inflate(R.layout.page_guide_second, null);
        View view3 = LayoutInflater.from(this).inflate(R.layout.page_guide_third, null);

        views.add(view1);
        views.add(view2);
        views.add(view3);

        view3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GudieActivity.this, MainActivity.class);
                GudieActivity.this.startActivity(intent);

                GudieActivity.this.finish();
            }
        });

        new ViewPagerHelper(false, mViewPager, views, viewPoints, R.mipmap.page_indicator_focused,
                R.mipmap.page_indicator_unfocused);
    }
}
