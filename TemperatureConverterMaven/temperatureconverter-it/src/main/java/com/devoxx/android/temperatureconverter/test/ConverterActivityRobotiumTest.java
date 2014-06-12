package com.devoxx.android.temperatureconverter.test;

import android.test.ActivityInstrumentationTestCase2;

import com.devoxx.android.temperatureconverter.ConverterActivity;
import com.robotium.solo.Solo;

import junit.framework.Assert;

/**
 * Robotium tests.
 */
public class ConverterActivityRobotiumTest extends ActivityInstrumentationTestCase2<ConverterActivity> {

    private Solo solo;

    public ConverterActivityRobotiumTest() {
        super(ConverterActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    protected void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void testConversion() throws Exception {
        solo.enterText(0, "0");
        solo.clickOnButton("Convert!");
        Assert.assertTrue(solo.searchText("32.0"));
    }
}
