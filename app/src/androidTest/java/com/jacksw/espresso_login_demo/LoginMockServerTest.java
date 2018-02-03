package com.jacksw.espresso_login_demo;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

@RunWith(AndroidJUnit4.class)
public class LoginMockServerTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class, true, false);

    private MockWebServer server;

    @Before
    public void setUp() throws Exception {
        server = new MockWebServer();
        server.start();

        LoginAPIEndpoint.BASE_URL = server.url("/").toString();
    }

    @Test
    public void loginSuccess() {
        server.enqueue(new MockResponse().setResponseCode(200));

        Intent intent = new Intent();
        mActivityRule.launchActivity(intent);

        LoginScreen loginScreen = new LoginScreen();
        WelcomeScreen welcomeScreen = new WelcomeScreen();

        loginScreen.clickLoginButton();

        welcomeScreen.waitForWelcomeMessage();
    }

    @Test
    public void loginFail() {
        server.enqueue(new MockResponse().setResponseCode(404));

        Intent intent = new Intent();
        mActivityRule.launchActivity(intent);

        LoginScreen loginScreen = new LoginScreen();
        loginScreen.clickLoginButton();

        loginScreen.isDialogAppearWithMessage("Username or password incorrect please try again");
    }

    @After
    public void tearDown() throws Exception {
        server.shutdown();
    }
}
