package com.example.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.intentdemo.databinding.ActivityLoginBinding;

/**
 * @author cheng
 */
public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        //普通的传值方法
        mBinding.ButtonLogin1.setOnClickListener(v -> {
            String user = mBinding.user.getText().toString();
            String pwd = mBinding.pwd.getText().toString();
            String isAdmin = mBinding.isAdmin.isChecked() ? "是" : "否";
            if ("".equals(user)|| "".equals(pwd)){
                Toast.makeText(LoginActivity.this,"请填写账号和密码",Toast.LENGTH_SHORT).show();
            }else {
                Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                intent.putExtra("user",user);
                intent.putExtra("pwd",pwd);
                intent.putExtra("isAdmin",isAdmin);
                startActivity(intent);
            }
        });

    }
}