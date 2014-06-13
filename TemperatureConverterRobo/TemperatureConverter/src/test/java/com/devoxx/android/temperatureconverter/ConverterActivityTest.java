package com.devoxx.android.temperatureconverter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.devoxx.android.temperatureconverter.conversion.CelsiusFahrenheitConverter;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * Roboelectric test.
 */
@Config(emulateSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class ConverterActivityTest {

    private static final String APP_NAME = "Temperature Converter";

    @Test
    public void testHasCorrectAppName() throws Exception {
        // given
        ConverterActivity activity = Robolectric.buildActivity(ConverterActivity.class).create().get();

        // when
        activity.onCreate(null);

        // then
        String appName = activity.getResources().getString(R.string.app_name);
        assertThat(appName, equalTo(APP_NAME));
    }

    @Test
    public void testMockedConverter() throws Exception {
        // expectations
        final float expected_result = 32.0f;

        // given
        ConverterActivity activity = Robolectric.buildActivity(ConverterActivity.class).create().get();
        activity.onCreate(new Bundle());
        EditText celsiusField = (EditText) activity.findViewById(R.id.celsius_textview);
        celsiusField.setText("0");

        CelsiusFahrenheitConverter mockConverter = Mockito.mock(CelsiusFahrenheitConverter.class);
        Mockito.when(mockConverter.convertCelsiusToFahrenheit(Mockito.anyFloat())).thenReturn(expected_result);
        activity.setConverter(mockConverter);

        // when
        Button convertButton = (Button) activity.findViewById(R.id.conversion_button);
        convertButton.performClick();

        // then
        Mockito.verify(mockConverter, Mockito.times(1)).convertCelsiusToFahrenheit(Mockito.anyFloat());
        TextView fahrenheitField = (TextView) activity.findViewById(R.id.fahrenheit_textview);
        String fahrenheitString = fahrenheitField.getText().toString();
        assertThat(fahrenheitString, equalTo(String.valueOf(expected_result)));
    }
}
