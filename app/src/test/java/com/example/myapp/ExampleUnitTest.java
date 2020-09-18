package com.example.myapp;

import org.junit.Test;

import java.util.HashMap;

import cn.hutool.http.HttpUtil;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("city", "北京");
        String s = HttpUtil.get("http://192.168.1.69:8080/hello", paramMap);
        System.out.println(s);
    }
}