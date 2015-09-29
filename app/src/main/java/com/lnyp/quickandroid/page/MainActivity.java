package com.lnyp.quickandroid.page;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lnyp.quickandroid.R;
import com.lnyp.quickandroid.sys.AppSetting;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends Activity {

    @Bind(R.id.textView)
    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        // 设置引导页关闭
        AppSetting.init(this).setGuideFlag(true);
    }

    @OnClick({R.id.button, R.id.button2})
    public void onClick(View view) {
        if (R.id.button == view.getId()) {
//            Toast.makeText(this, "lining", Toast.LENGTH_SHORT).show();
            textView.setText("lining");
        } else {
            textView.setText("wuyuan");
//            Toast.makeText(this, "wuyuan", Toast.LENGTH_SHORT).show();
        }
    }

}
