package com.example.android.androiddemomvvm;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.android.androiddemomvvm.Interface.LoginResultCallBack;
import com.example.android.androiddemomvvm.ViewModel.LoginViewModel;
import com.example.android.androiddemomvvm.ViewModel.LoginViewModelFactory;
import com.example.android.androiddemomvvm.databinding.ActivityMainBinding;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements LoginResultCallBack {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.setViewModel(ViewModelProviders.of(this,new LoginViewModelFactory(this))
                .get(LoginViewModel.class));
    }

    @Override
    public void onSuccess(String message) {
        Toasty.success(this, "Login Success", Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void onError(String message) {
        Toasty.error(this, "Login Error", Toast.LENGTH_SHORT)
                .show();
    }
}
