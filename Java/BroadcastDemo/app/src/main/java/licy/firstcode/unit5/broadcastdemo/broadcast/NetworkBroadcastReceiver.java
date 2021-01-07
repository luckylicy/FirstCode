package licy.firstcode.unit5.broadcastdemo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * NetworkBroadcastReceiver
 * description: TODO
 *
 * @author : Licy
 * @date : 2021/1/7
 * email ：licy3051@qq.com
 */
public class NetworkBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    Toast.makeText(context, "network is available~", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "network is not available~", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(context, "network is not available~", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, "network is not available~", Toast.LENGTH_SHORT).show();
        }
    }
}

    
    
       
    