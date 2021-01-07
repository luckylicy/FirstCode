package licy.firstcode.unit5.broadcastdemo.helper;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.widget.Toast;

import androidx.annotation.NonNull;

import licy.firstcode.unit5.broadcastdemo.MyApp;

/**
 * NetworkCallbackImpl
 * description: TODO
 *
 * @author : Licy
 * @date : 2021/1/7
 * email ：licy3051@qq.com
 */
public class NetworkCallbackImpl extends ConnectivityManager.NetworkCallback {

    @Override
    public void onAvailable(@NonNull Network network) {
        super.onAvailable(network);
        Toast.makeText(MyApp.getMyApp(), "network is available", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLost(@NonNull Network network) {
        super.onLost(network);
        Toast.makeText(MyApp.getMyApp(), "network is not available", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCapabilitiesChanged(@NonNull Network network, @NonNull NetworkCapabilities networkCapabilities) {
        super.onCapabilitiesChanged(network, networkCapabilities);
        if (networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)) {
            if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                Toast.makeText(MyApp.getMyApp(), "wifi已经连接", Toast.LENGTH_SHORT).show();
            } else if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                Toast.makeText(MyApp.getMyApp(), "数据流量已经连接", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MyApp.getMyApp(), "其他网络已经连接", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

    
    
       
    