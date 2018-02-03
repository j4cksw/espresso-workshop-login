package com.jacksw.espresso_login_demo;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class LoginScreen {

    public void inputUserName(String username){
        onView(withId(R.id.username)).perform(typeText(username));
    }

    public void inputPassword(String password){
        onView(withId(R.id.password)).perform(typeText(password));
    }

    public void clickLoginButton() {
        onView(withId(R.id.login_button)).perform(click());
    }

    public void isDialogAppearWithMessage(String dialogMessage) {
        onView(withText(dialogMessage)).check(matches(isDisplayed()));
    }
}
