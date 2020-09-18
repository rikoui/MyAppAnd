package com.example.myapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapp.R;
import com.example.myapp.utils.OkHttpUtils;
import com.example.myapp.utils.UrlUtils;

import java.io.IOException;

import cn.hutool.core.util.StrUtil;

public class LoginActivity extends AppCompatActivity {

    private EditText accountEditText;
    private EditText pwdEditText;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accountEditText = findViewById(R.id.account_in);
                String account = accountEditText.getText().toString().trim();
                pwdEditText = findViewById(R.id.pwd_in);
                String passWord = pwdEditText.getText().toString().trim();
                if (StrUtil.isEmpty(account)) {
                    Toast.makeText(LoginActivity.this, "请输入账号", Toast.LENGTH_LONG).show();
                    return;
                }
                if (StrUtil.isEmpty(passWord)) {
                    Toast.makeText(LoginActivity.this, "请输入密码", Toast.LENGTH_LONG).show();
                    return;
                }

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String s = account;
                            execute(account, passWord);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();


                Intent intent = new Intent(LoginActivity.this, AppMasterActivity.class);
                startActivity(intent);
            }
        });
    }

    public void execute(String account,  String passWord) throws IOException {
        String str = OkHttpUtils.get(UrlUtils.getUrl("/hello"));
        showResponse(str);
    }

    private void showResponse(final String string){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this, string, Toast.LENGTH_LONG).show();
            }
        });
    }
}