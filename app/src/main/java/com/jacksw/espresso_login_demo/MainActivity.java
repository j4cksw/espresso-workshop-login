package com.jacksw.espresso_login_demo;

import android.content.Intent;
import android.os.Debug;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView username;
    private TextView password;
    private Button loginButton;

    private ServiceProvider serviceProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(this);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        serviceProvider = new ServiceProvider();
    }


    @Override
    public void onClick(View view) {

        serviceProvider
                .loginService()
                .login(new User(username.getText().toString(), password.getText().toString()))
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                        if(response.isSuccessful()) {
                            redirectToWelcome();
                            return;
                        }

                        showAlertdialog();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Log.d("Error", t.toString());
                    }
                });
    }

    private void redirectToWelcome() {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    private void showAlertdialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setMessage("Username or password incorrect please try again");
        builder.setPositiveButton("OK", null);

        builder.create();

        builder.show();
    }
}
