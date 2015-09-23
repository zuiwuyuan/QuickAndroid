package com.lnyp.quickandroid.http;

import android.content.Context;
import android.widget.Toast;

import com.lnyp.quickandroid.util.FastJsonUtil;
import com.loopj.android.http.TextHttpResponseHandler;

import org.apache.http.Header;

public abstract class ResponseHandler<T> extends TextHttpResponseHandler {

    public abstract void onSuccess(T result);

    public abstract void onFailure(Throwable throwable);

    private Context mContext;

    private Class<T> clazz;

    public ResponseHandler(Context context, Class clazz) {

        this.mContext = context;
        this.clazz = clazz;
    }

    @Override
    public void onFailure(int i, Header[] headers, String s, Throwable throwable) {

        Toast.makeText(mContext, "ÍøÂç´íÎó", Toast.LENGTH_SHORT).show();

        onFailure(throwable);
    }

    @Override
    public void onSuccess(int i, Header[] headers, String s) {

//        ´¦Àíjson½âÎö
        T data = FastJsonUtil.json2T(s, clazz);
        onSuccess(data);
    }
}