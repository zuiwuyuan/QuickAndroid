package com.lnyp.quickandroid.page;

import android.os.Bundle;
import android.view.View;

import com.apkfuns.logutils.LogUtils;
import com.lnyp.quickandroid.R;
import com.lnyp.quickandroid.http.HttpUtil;
import com.lnyp.quickandroid.http.ResponseHandler;
import com.lnyp.quickandroid.sys.AppSetting;
import com.lnyp.quickandroid.util.DateUtil;

import java.util.Date;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        applyKitKatTranslucency();

        // 设置引导页关闭
        AppSetting.init(this).setGuideFlag(true);
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.button1:
//                LogUtils.e(DateUtil.formatDateTime1(new Date()));
                HttpUtil.getReq(this, "http://221.226.64.10:8081/thbjk/getLogin?account=oyp&pwd=111111", null, new ResponseHandler(this,null) {
                    @Override
                    public void onSuccess(Object result) {
                        LogUtils.e("result:" + result);
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        LogUtils.e("throwable:" + throwable);
                    }
                });

                break;

            case R.id.button2:
                LogUtils.e(DateUtil.formatDateTime2(new Date()));
                break;

            case R.id.button3:
                LogUtils.e(DateUtil.formatDateTime1(System.currentTimeMillis()));
                break;

            case R.id.button4:
                LogUtils.e(DateUtil.formatDateTime2(System.currentTimeMillis()));
                break;
            case R.id.button5:
                LogUtils.e(DateUtil.parseDateTime1("2016-1-16 12:52:39"));
                break;

            case R.id.button6:
                LogUtils.e(DateUtil.parseDateTime2("2016-1-16 12:52"));
                break;
        }
    }
}
