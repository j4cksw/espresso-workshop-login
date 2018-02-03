package com.jacksw.espresso_login_demo;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class WelcomeScreen {

    public void waitForWelcomeMessage() {
        onView(withId(R.id.welcome_text)).check(matches(withText("Welcome!")));
    }
}
