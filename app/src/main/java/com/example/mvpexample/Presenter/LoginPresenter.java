package com.example.mvpexample.Presenter;

import com.example.mvpexample.Model.User;
import com.example.mvpexample.View.ILoginView;

public class LoginPresenter implements ILoginPresenter {

    ILoginView iLoginView;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email, password);
        boolean isLoginSucces = user.isValidData();

        if (isLoginSucces)
            iLoginView.onLoginResult("Login Success");
        else
            iLoginView.onLoginResult("Login Error");
    }
}
