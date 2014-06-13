package com.devoxx.android.temperatureconverter.test;

import android.test.ActivityInstrumentationTestCase2;
import com.devoxx.android.temperatureconverter.*;

public class ConverterActivityTest extends ActivityInstrumentationTestCase2<ConverterActivity> {

    public ConverterActivityTest() {
        super(ConverterActivity.class);
    }

    public void testActivity() {
        ConverterActivity activity = getActivity();
        assertNotNull(activity);
    }
}

