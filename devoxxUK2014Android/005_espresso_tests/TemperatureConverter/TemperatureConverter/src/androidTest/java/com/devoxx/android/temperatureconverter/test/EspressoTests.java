package com.devoxx.android.temperatureconverter.test;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.closeSoftKeyboard;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.typeText;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.isDisplayed;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

import android.test.ActivityInstrumentationTestCase2;

import com.devoxx.android.temperatureconverter.ConverterActivity;
import com.devoxx.android.temperatureconverter.R;
import com.google.android.apps.common.testing.ui.espresso.Espresso;
import com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions;
import com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers;

/**
 * Basic Espresso functionality.
 */
public class EspressoTests extends ActivityInstrumentationTestCase2<ConverterActivity> {

    public EspressoTests() {
        this("EspressoTests");
    }

    public EspressoTests(String name) {
        super(ConverterActivity.class);
        setName(name);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        // Espresso will not automatically launch the Activity, we must launch it via getActivity().
        getActivity();
    }

    public void testPreconditions() {
        Espresso.onView(ViewMatchers.withId(R.id.celsius_label)).check(ViewAssertions.matches(isDisplayed()));
    }

    public void testCheckingLabels() {
        Espresso.onView(ViewMatchers.withId(R.id.celsius_label))
                .check(ViewAssertions.matches(ViewMatchers.withText("Celsius")));
    }

    public void testTypingAndClicking() {
        // type in celsius field, and then close the soft keyboard
        onView(withId(R.id.celsius_textview)).perform(typeText("100"), closeSoftKeyboard());

        onView(withId(R.id.conversion_button)).perform(click());

        onView(withId(R.id.fahrenheit_textview)).check(matches(withText(containsString("212"))));
    }
}
