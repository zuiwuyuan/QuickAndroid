package com.lnyp.quickandroid;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;
import android.widget.Toast;

import com.lnyp.quickandroid.http.HttpUtil;
import com.lnyp.quickandroid.http.ResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    public ApplicationTest() {
        super(Application.class);

    }
}