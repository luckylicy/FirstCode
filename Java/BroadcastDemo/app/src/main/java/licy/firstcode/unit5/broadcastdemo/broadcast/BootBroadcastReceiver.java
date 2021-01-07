package licy.firstcode.unit5.broadcastdemo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * BootBroadcastReceiver
 * description: TODO
 *
 * @author : Licy
 * @date : 2021/1/7
 * email ：licy3051@qq.com
 */
public class BootBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "boot complete", Toast.LENGTH_SHORT).show();
    }
}

    
    
       
    