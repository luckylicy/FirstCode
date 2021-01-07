package licy.firstcode.unit5.broadcastdemo.model;

import android.text.TextUtils;

import androidx.annotation.NonNull;

/**
 * User
 * description: TODO
 *
 * @author : Licy
 * @date : 2021/1/7
 * email ：licy3051@qq.com
 */
public class User {

    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static boolean verify(@NonNull User user) {
        if (TextUtils.equals("admin", user.name) && TextUtils.equals("111111", user.password)) {
            return true;
        } else {
            return false;
        }
    }
}




