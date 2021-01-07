package licy.firstcode.unit5.broadcastdemo.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import licy.firstcode.unit5.broadcastdemo.model.User;

/**
 * UserViewModel
 * description: TODO
 *
 * @author : Licy
 * @date : 2021/1/7
 * email ：licy3051@qq.com
 */
public class UserViewModel extends ViewModel {

   private final MutableLiveData<User> user=new MutableLiveData<>();

    public LiveData<User> getUser() {
        return user;
    }


}

    
    
       
    