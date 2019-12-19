package com.jacksw.espresso_login_demo;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceProvider {

    LoginService loginService;

   public ServiceProvider(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LoginAPIEndpoint.BASE_URL)
                .client(RestAdapter.getUnsafeOkHttpClient().build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        loginService = retrofit.create(LoginService.class);
   }

   public LoginService loginService() {
       return loginService;
   }

}
