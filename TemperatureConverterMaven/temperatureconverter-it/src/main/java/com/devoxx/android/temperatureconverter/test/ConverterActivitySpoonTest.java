package com.devoxx.android.temperatureconverter.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.devoxx.android.temperatureconverter.*;
import com.robotium.solo.Solo;
import com.squareup.spoon.Spoon;

import static org.fest.assertions.api.ANDROID.assertThat;

/**
 * Spoon tests.
 */
public class ConverterActivitySpoonTest extends ActivityInstrumentationTestCase2<ConverterActivity> {

    private Solo solo;
    private TextView fahrenheitField;

    public ConverterActivitySpoonTest() {
        super(ConverterActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
        fahrenheitField = (TextView) getActivity().findViewById(com.devoxx.android.temperatureconverter.R.id.fahrenheit_textview);
    }

    @Override
    protected void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void testConversion() throws Exception {
        Spoon.screenshot(getActivity(), "before_conversion");

        solo.enterText(0, "0");
        solo.clickOnButton("Convert!");

        // check
        Spoon.screenshot(getActivity(), "after_conversion");
        assertThat(fahrenheitField).containsText("32.0");
    }
}
