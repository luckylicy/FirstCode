package licy.firstcode.unit5.broadcastdemo.helper;

import android.app.Activity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * ActivityStackUtils
 * description: TODO
 *
 * @author : Licy
 * @date : 2021/1/7
 * email ：licy3051@qq.com
 */
public class ActivityStackUtils {

    private static List<Activity> mActivitys = new ArrayList<>();

    public static void onActivityCreate(Activity activity) {
        if (mActivitys != null) {
            mActivitys.add(activity);
            Toast.makeText(activity, "add a activity : " + activity.getClass().getSimpleName(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void onActivityDestroy(Activity activity) {
        if (mActivitys != null) {
            mActivitys.remove(activity);
            Toast.makeText(activity, "remove a activity : " + activity.getClass().getSimpleName(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void removeAll() {
        if (mActivitys != null) {
            for (Activity mActivity : mActivitys) {
                if (mActivity != null) {
                    mActivity.finish();
                }
            }
        }
    }
}

    
    
       
    