package com.example.myapp.utils;




import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * author: lixw
 * date: 2020/9/17 17:17
 * package: com.example.myapp.utils
 * description:
 */
public class OkHttpUtils {

    private static final OkHttpClient mOkHttpClient = new OkHttpClient();

    public static String get(String url) throws IOException {
        Request request = new Request.Builder().url(url).get().build();
        Response response = mOkHttpClient.newCall(request).execute();
        if (response.isSuccessful()){
            return response.body().string();
        }
        return "";
    }
}
