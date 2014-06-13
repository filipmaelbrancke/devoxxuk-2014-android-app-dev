package com.devoxx.android.temperatureconverter.conversion;

/**
 * Celsius - Fahrenheit converter.
 */
public interface CelsiusFahrenheitConverter {

    public float convertCelsiusToFahrenheit(float c);

    public float convertFahrenheitToCelsius(float f);
}
