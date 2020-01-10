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
        int loginCode = user.isValidData();

        if (loginCode == 0)
            iLoginView.onLoginError("Debe ingresar su email");
        else if (loginCode == 1)
            iLoginView.onLoginError("Debe ingresar un email valido");
        else if (loginCode == 2)
            iLoginView.onLoginError("El password debe ser mayor de 6 caracteres");
        else
            iLoginView.onLoginSuccess("Exito");
    }
}
