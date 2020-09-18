package com.example.myapp.utils;

import cn.hutool.core.util.StrUtil;

/**
 * author: lixw
 * date: 2020/9/18 11:18
 * package: com.example.myapp.utils
 * description:
 */
public class UrlUtils {

    private final static String URL_BASE= "http://192.168.1.69:8080";

    public static String getUrl(String url){
        if (StrUtil.isEmpty(url)) {
            return "";
        }

        if (url.startsWith("/")) {
            return URL_BASE + url;
        } else {
            return URL_BASE + StrUtil.SLASH + url;
        }
    }
}
