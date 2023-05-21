package org.adaschool.retrofit;



import android.content.Context;
import android.content.SharedPreferences;

import org.adaschool.retrofit.databinding.ActivityMainBinding;

public class SharedPreferencesStorage implements Storage{
    private ActivityMainBinding binding;
    Context context = MainActivity.getAppContext();
    private SharedPreferences sharedPreferences = context.getSharedPreferences("MyPref", 0);

    @Override
    public void saveToken(String token) {

        sharedPreferences.edit().putString(Constants.TOKEN_KEY,token).apply();
    }

    @Override
    public String getToken() {
        return sharedPreferences.getString(Constants.TOKEN_KEY,"");
    }

    @Override
    public void clear() {
        sharedPreferences.edit().clear().apply();
    }
}
