package com.eng.asu.adaptivelearning.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.eng.asu.adaptivelearning.view.LoginActivity;
import com.eng.asu.adaptivelearning.view.MainActivity;

public class UserViewModel extends AndroidViewModel {

    public UserViewModel(@NonNull Application application) {
        super(application);
    }

    public Class<? extends AppCompatActivity> getActivityToOpen() {
        if (isUserLoggedIn())
            return MainActivity.class;
        else
            return LoginActivity.class;
    }

    private boolean isUserLoggedIn() {
        //TODO --- check for the current access token if it's valid or not
        return false;
    }
}
