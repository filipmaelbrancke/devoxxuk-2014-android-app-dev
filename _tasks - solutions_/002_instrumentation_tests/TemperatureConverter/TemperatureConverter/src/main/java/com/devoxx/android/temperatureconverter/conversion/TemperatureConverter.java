package com.devoxx.android.temperatureconverter.conversion;

/**
 * Temperature converter.
 */
public class TemperatureConverter implements CelsiusFahrenheitConverter {

    public static final float ABSOLUTE_ZERO_CELSIUS = -273.15f;
    public static final float ABSOLUTE_ZERO_FAHRENHEIT = -459.67f;

    @Override
    public float convertCelsiusToFahrenheit(float c) {
        if (c < ABSOLUTE_ZERO_CELSIUS) {
            throw new TemperatureConversionException("Not possible to have a temperature below absolute zero");
        }
        return (c * 1.8f + 32);
    }

    @Override
    public float convertFahrenheitToCelsius(float f) {
        if (f < ABSOLUTE_ZERO_FAHRENHEIT) {
            throw new TemperatureConversionException("Not possible to have a temperature below absolute zero");
        }
        return ((f - 32) / 1.8f);
    }
}
