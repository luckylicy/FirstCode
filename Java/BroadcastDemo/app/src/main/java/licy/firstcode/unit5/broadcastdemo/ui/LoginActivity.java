package licy.firstcode.unit5.broadcastdemo.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import licy.firstcode.unit5.broadcastdemo.R;
import licy.firstcode.unit5.broadcastdemo.databinding.ActivityLoginBinding;
import licy.firstcode.unit5.broadcastdemo.model.User;

/**
 * LoginActivity
 * description: TODO
 *
 * @author : Licy
 * @date : 2021/1/7
 * email ：licy3051@qq.com
 */
public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding mLoginBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 视图绑定
        // 数据绑定
        mLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        User user = new User("admin","111111");
        mLoginBinding.setLoginUser(user);


        // 添加监听
        mLoginBinding.btnLogin.setOnClickListener(v -> {
            if (User.verify(mLoginBinding.getLoginUser())) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

    
    
       
    