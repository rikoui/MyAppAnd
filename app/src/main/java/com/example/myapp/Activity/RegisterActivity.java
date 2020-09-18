package com.example.myapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapp.R;

import cn.hutool.core.util.StrUtil;

public class RegisterActivity extends AppCompatActivity {

    private EditText accountEditText;
    private EditText pwdEditText;
    private EditText pwdsEditText;
    private Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerBtn = findViewById(R.id.register_btn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accountEditText = findViewById(R.id.account_in);
                String account = accountEditText.getText().toString().trim();
                pwdEditText = findViewById(R.id.pwd_in);
                String passWord1 = pwdEditText.getText().toString().trim();
                pwdsEditText = findViewById(R.id.pwd_ins);
                String passWord2 = pwdsEditText.getText().toString().trim();

                if (StrUtil.isEmpty(account)){
                    Toast.makeText(RegisterActivity.this, "请输入账号", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (StrUtil.isEmpty(passWord1)){
                    Toast.makeText(RegisterActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (StrUtil.isEmpty(passWord2)){
                    Toast.makeText(RegisterActivity.this, "请确认密码", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!passWord1.equals(passWord2)){
                    Toast.makeText(RegisterActivity.this, "两次密码不一致", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();

            }
        });
    }
}