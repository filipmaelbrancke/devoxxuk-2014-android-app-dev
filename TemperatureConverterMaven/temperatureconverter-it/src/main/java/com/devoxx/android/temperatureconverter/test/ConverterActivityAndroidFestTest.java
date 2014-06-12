package com.devoxx.android.temperatureconverter.test;

import static org.fest.assertions.api.ANDROID.assertThat;

import android.app.Activity;
import android.content.res.Resources;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.devoxx.android.temperatureconverter.*;
import com.devoxx.android.temperatureconverter.R;
import com.robotium.solo.Solo;

/**
 * Fest assertions for Android.
 */
public class ConverterActivityAndroidFestTest extends ActivityInstrumentationTestCase2<ConverterActivity> {

    private Solo solo;
    private TextView fahrenheitField;


    public ConverterActivityAndroidFestTest() {
        super(ConverterActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
        fahrenheitField = (TextView) getActivity().findViewById(R.id.fahrenheit_textview);
    }

    @Override
    protected void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void testConvertButtonIsVisibleRegularJUnit() {
        org.junit.Assert.assertEquals(View.VISIBLE, fahrenheitField.getVisibility());
    }

    public void testConvertButtonIsVisibleRegularFest() {
        org.fest.assertions.api.Assertions.assertThat(fahrenheitField.getVisibility()).isEqualTo(View.VISIBLE);
    }

    public void testConvertButtonIsVisibleAndroidFest() {
        org.fest.assertions.api.ANDROID.assertThat(fahrenheitField).isVisible();
    }

    public void testFahrenheitFieldAlignment() {
        Resources resources = getInstrumentation().getContext().getResources();

        Activity act = solo.getCurrentActivity();
        int leftMargin = (int) act.getResources().getDimension(R.dimen.activity_horizontal_margin);
        
        //float leftMargin = resources.getDimension(R.dimen.activity_horizontal_margin);
        //int pixels = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftMargin, resources.getDisplayMetrics());
        assertThat(fahrenheitField).isVisible()
                .hasLeft(leftMargin);
    }

    public void testConversion() throws Exception {
        solo.enterText(0, "0");
        solo.clickOnButton("Convert!");
        solo.sleep(200);
        assertThat(fahrenheitField).containsText("32.0");
    }

}
