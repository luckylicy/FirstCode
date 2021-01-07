package licy.firstcode.unit5.broadcastdemo.ui;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import licy.firstcode.unit5.broadcastdemo.Constants;
import licy.firstcode.unit5.broadcastdemo.broadcast.LocalBroadcastReceiver;
import licy.firstcode.unit5.broadcastdemo.broadcast.MyCustomBroadcastReceiver;
import licy.firstcode.unit5.broadcastdemo.databinding.ActivityMainBinding;

/**
 * @author Licy
 */
public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mActivityMainBinding;

    IntentFilter mIntentFilter;
    MyCustomBroadcastReceiver mMyCustomBroadcastReceiver;

    LocalBroadcastReceiver mLocalBroadcastReceiver;
    LocalBroadcastManager mLocalBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mActivityMainBinding.getRoot());

        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);
        mLocalBroadcastReceiver = new LocalBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter(Constants.CUSTOM_RECEIVER_LOCAL);
        mLocalBroadcastManager.registerReceiver(mLocalBroadcastReceiver, intentFilter);


        mActivityMainBinding.register.setOnClickListener(v -> {
            mIntentFilter = new IntentFilter();
            mIntentFilter.addAction(Constants.CUSTOM_RECEIVER_TEST);
            mMyCustomBroadcastReceiver = new MyCustomBroadcastReceiver();
            registerReceiver(mMyCustomBroadcastReceiver, mIntentFilter);
        });

        mActivityMainBinding.unregister.setOnClickListener(v -> {
            unregisterReceiver(mMyCustomBroadcastReceiver);
        });

        mActivityMainBinding.send.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Constants.CUSTOM_RECEIVER_TEST);
            sendBroadcast(intent);
        });

        mActivityMainBinding.sendOrder.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Constants.CUSTOM_RECEIVER_TEST);
            sendOrderedBroadcast(intent, null);
        });

        mActivityMainBinding.sendClear.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Constants.CUSTOM_RECEIVER_CLEAR);
            sendBroadcast(intent, null);
        });

        mActivityMainBinding.sendLocal.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Constants.CUSTOM_RECEIVER_LOCAL);
            mLocalBroadcastManager.sendBroadcast(intent);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mMyCustomBroadcastReceiver != null) {
            unregisterReceiver(mMyCustomBroadcastReceiver);
        }
        if (mLocalBroadcastManager != null) {
            mLocalBroadcastManager.unregisterReceiver(mLocalBroadcastReceiver);
        }
    }
}