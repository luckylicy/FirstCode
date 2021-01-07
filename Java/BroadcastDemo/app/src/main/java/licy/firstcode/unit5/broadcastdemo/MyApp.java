package licy.firstcode.unit5.broadcastdemo;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import licy.firstcode.unit5.broadcastdemo.helper.ActivityStackUtils;
import licy.firstcode.unit5.broadcastdemo.helper.NetworkCallbackImpl;

/**
 * MyApp
 * description: TODO
 *
 * @author : Licy
 * @date : 2021/1/7
 * email ：licy3051@qq.com
 */
public class MyApp extends Application implements Application.ActivityLifecycleCallbacks {

    private static MyApp sMyApp;

    public static MyApp getMyApp() {
        return sMyApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sMyApp = this;
        registerActivityLifecycleCallbacks(this);

        registerNetworkCallback();
    }

    private void registerNetworkCallback() {
        NetworkCallbackImpl networkCallback = new NetworkCallbackImpl();
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        NetworkRequest build = builder.build();
        ConnectivityManager systemService = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (systemService != null) {
            systemService.registerNetworkCallback(build, networkCallback);
        }
    }

    @Override
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
        ActivityStackUtils.onActivityCreate(activity);
    }

    @Override
    public void onActivityStarted(@NonNull Activity activity) {

    }

    @Override
    public void onActivityResumed(@NonNull Activity activity) {

    }

    @Override
    public void onActivityPaused(@NonNull Activity activity) {

    }

    @Override
    public void onActivityStopped(@NonNull Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {
        ActivityStackUtils.onActivityDestroy(activity);
    }
}

    
    
       
    