package com.lnyp.quickandroid.http;

import android.content.Context;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

import java.io.File;
import java.io.FileNotFoundException;

public class HttpUtil {

    private static AsyncHttpClient client = new AsyncHttpClient();

    static {
        client.setTimeout(5 * 1000);
        client.setConnectTimeout(5 * 1000);
    }

    public static void getReq(Context context, String url, RequestParams requestParams, ResponseHandler responseHandler) {

        client.get(context, url, requestParams, responseHandler);
    }

    public static void postReq(Context context, String url, RequestParams requestParams, ResponseHandler responseHandler) {

        client.post(context, url, requestParams, responseHandler);
    }

    // 如果你又特殊的请求，比如增加头信息等，可以单独写一个方法，比如
    public static void login(Context context, String url, RequestParams requestParams, ResponseHandler responseHandler) {
        client.addHeader("token", "wuyuanyoulei");
        client.get(context, url, requestParams, responseHandler);
    }

    // 如果你只是想做图片上传，建议你使用七牛的图片上传，不仅性能优秀，而且帮助你节省不少服务器的消耗

    /**
     * @param context
     * @param path            要上传的文件路径
     * @param url             服务端接收URL
     * @param responseHandler
     */
    public static void uploadFile(final Context context, String path, String url, ResponseHandler responseHandler) {

        File file = new File(path);
        if (file.exists() && file.length() > 0) {
            RequestParams params = new RequestParams();
            try {
                params.put("uploadfile", file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            // 上传文件
            client.post(url, params, responseHandler);

        } else {
            Toast.makeText(context, "文件不存在", Toast.LENGTH_LONG).show();
        }
    }
}