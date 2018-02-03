package com.jacksw.espresso_login_demo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {

    @POST("login")
    Call<Void> login(@Body User user);
}
