package com.devoxx.android.temperatureconverter.test;

import static android.test.ViewAsserts.assertOnScreen;
import static android.test.ViewAsserts.assertLeftAligned;
import static android.test.ViewAsserts.assertRightAligned;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.devoxx.android.temperatureconverter.ConverterActivity;
import com.devoxx.android.temperatureconverter.R;
import com.devoxx.android.temperatureconverter.conversion.CelsiusFahrenheitConverter;
import com.devoxx.android.temperatureconverter.conversion.TemperatureConverter;

import junit.framework.Assert;

/**
 * Instrumentation tests for the ConverterActivity.
 */
public class ConverterActivityTests extends ActivityInstrumentationTestCase2<ConverterActivity> {

    private ConverterActivity mActivity;
    private EditText mCelsiusField;
    private TextView mFahrenheitField;
    private TextView mCelsiusLabel;
    private TextView mFahrenheitLabel;
    private Button mConvertButton;


    public ConverterActivityTests() {
        this("ConverterActivityTests");
    }

    public ConverterActivityTests(String name) {
        super(ConverterActivity.class);
        setName(name);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mActivity = getActivity();
        mCelsiusField = (EditText) mActivity.findViewById(R.id.celsius_textview);
        mFahrenheitField = (TextView) mActivity.findViewById(R.id.fahrenheit_textview);
        mCelsiusLabel = (TextView) mActivity.findViewById(R.id.celsius_label);
        mFahrenheitLabel = (TextView) mActivity.findViewById(R.id.fahrenheit_label);
        mConvertButton = (Button) mActivity.findViewById(R.id.conversion_button);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testPrecondition() {
        assertNotNull(mActivity);
    }

    public void testHasCelsiusInputField() {
        assertNotNull(mCelsiusField);
    }

    public void testCelsiusFieldStartsEmpty() {
        assertEquals("", mCelsiusField.getText().toString());
        assertEquals("", mFahrenheitField.getText().toString());
    }

    public void testFieldsAreOnTheScreen() {
        final Window window = mActivity.getWindow();
        final View topLevelView = window.getDecorView();
        assertOnScreen(topLevelView, mCelsiusField);
        assertOnScreen(topLevelView, mFahrenheitField);
    }

    public void testFieldsAlignment() {
        assertLeftAligned(mCelsiusLabel, mCelsiusField);
        assertLeftAligned(mFahrenheitLabel, mFahrenheitField);
        assertLeftAligned(mCelsiusField, mFahrenheitField);
        assertRightAligned(mCelsiusField, mFahrenheitField);
    }

    public void testButtonOccupiesWholeScreenWidth() {
        final int expectedWidth = ViewGroup.LayoutParams.MATCH_PARENT;
        final ViewGroup.LayoutParams layoutParams = mConvertButton.getLayoutParams();
        assertEquals("Celsius input field layout width is not MATCH_PARENT", expectedWidth, layoutParams.width);
    }

    @UiThreadTest
    public void testCelsiusToFahrenheitConversion() {
        final String celsiusValue = "0";
        mCelsiusField.requestFocus();
        mCelsiusField.setText(celsiusValue);
        CelsiusFahrenheitConverter converter = new TemperatureConverter();
        final float expectedFahrenheit = converter.convertCelsiusToFahrenheit(0f);
        mConvertButton.performClick();
        final String actualFahrenheit = mFahrenheitField.getText().toString();
        Assert.assertEquals(expectedFahrenheit, Float.valueOf(actualFahrenheit), 0.001f);
    }
}
