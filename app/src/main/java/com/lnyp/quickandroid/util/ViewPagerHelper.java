package com.lnyp.quickandroid.util;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ViewPager工具类
 */
public class ViewPagerHelper {

    // 判断是否自动滑动
    private boolean mIsAuto;

    private ViewPager mViewPager;

    private List<View> mViews;

    private LinearLayout mIndicatorParents; // 指示器容器

    private PagerAdapter mPagerAdapter;

    private int mSelect;

    private int mUnSelect;

    // 一个提供原子操作的Integer的类
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    // 广告不停的循环播放
    private boolean isContinue = true;

    /*
     * 每隔固定时间切换广告栏图片
     */
    public final Handler viewHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            if (msg.what == mViews.size()) {
                mViewPager.setCurrentItem(1);
            } else {
                mViewPager.setCurrentItem(msg.what);
            }
            super.handleMessage(msg);
        }

    };


    public ViewPagerHelper(boolean isAuto, ViewPager viewPager, List<View> views, LinearLayout indicatorParents,
                           int selectDrawableRes, int unselectDrawableRes) {
        mIsAuto = isAuto;
        mViewPager = viewPager;
        mViews = views;
        mIndicatorParents = indicatorParents;
        mSelect = selectDrawableRes;
        mUnSelect = unselectDrawableRes;

        init();
    }

    /**
     * 设置atomicInteger
     */
    private void atomicOption() {
        atomicInteger.incrementAndGet();
        if (atomicInteger.get() > mViews.size() - 1) {
            atomicInteger.getAndAdd(-mViews.size());
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
    }

    private void init() {
        mPagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return mViews.size();
            }

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == (arg1);
            }

            @Override
            public int getItemPosition(Object object) {
                View view = (View) object;
                if (mViews.contains(view)) {
                    return mViews.indexOf(view);
                }

                return POSITION_NONE;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mViews.get(position));// 删除页卡
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = mViews.get(position);
                container.addView(view, 0);
                return mViews.get(position);
            }
        };

//        mViewPager.setPageTransformer();

        mViewPager.setAdapter(mPagerAdapter);

        mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrollStateChanged(int state) {
                // 状态有三个0空闲，1是正在滑行中，2目标加载完毕
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // 从1到2滑动，在1滑动前调用
            }

            @Override
            public void onPageSelected(int index) {
                // activity从1到2滑动，2被加载后掉用此方法
                switchBannerIndicator(index);
            }
        });

        if (mIndicatorParents != null) {
            for (int i = 0; i < mViews.size(); i++) {
                int width = ActivityUtil.dip2px(mViewPager.getContext(), 8); // 像素
                int margin = ActivityUtil.dip2px(mViewPager.getContext(), 5);

                View view = new View(mViewPager.getContext());
                view.setBackgroundResource(mUnSelect);

                LayoutParams params = new LayoutParams(width, width);
                if (i < mViews.size() - 1) {
                    params.rightMargin = margin;
                }
                mIndicatorParents.addView(view, params);
            }

            mIndicatorParents.getChildAt(0).setBackgroundResource(mSelect);
        }

        if (mIsAuto) {
            // 启动线程，定时更改图片
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        if (isContinue) {
                            viewHandler.sendEmptyMessage(atomicInteger.get());
                            atomicOption();
                        }
                    }
                }
            }).start();
        }

    }

    /**
     * 设置指示器当前页码
     */
    private void switchBannerIndicator(int index) {
        if (mIndicatorParents != null) {
            for (int i = 0; i < mIndicatorParents.getChildCount(); i++) {
                View view = mIndicatorParents.getChildAt(i);
                if (i == index) {
                    view.setBackgroundResource(mSelect);
                } else {
                    view.setBackgroundResource(mUnSelect);
                }
            }
        }
    }
}
