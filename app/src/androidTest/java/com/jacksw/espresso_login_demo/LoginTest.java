package com.jacksw.espresso_login_demo;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class LoginTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);

    @Test
    public void loginSuccess() {
        LoginScreen login = new LoginScreen();
        WelcomeScreen welcome = new WelcomeScreen();

        login.inputUserName("demo");
        login.inputPassword("mode");
        login.clickLoginButton();

        welcome.waitForWelcomeMessage();
    }

    @Test
    public void loginWithInvalidCredential() {
        LoginScreen login = new LoginScreen();

        login.inputUserName("");
        login.inputPassword("");
        login.clickLoginButton();

        login.isDialogAppearWithMessage("Username or password incorrect please try again");
    }
}
