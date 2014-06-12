package com.devoxx.android.temperatureconverter;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.devoxx.android.temperatureconverter.conversion.CelsiusFahrenheitConverter;
import com.devoxx.android.temperatureconverter.conversion.TemperatureConverter;

/**
 * Temperature-conversion activity.
 */
public class ConverterActivity extends Activity {

    private static final String TAG = ConverterActivity.class.getSimpleName();

    private EditText mCelsiusField;
    private TextView mFahrenheitField;
    private Button mConvertButton;
    private CelsiusFahrenheitConverter mConverter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converter);

        mCelsiusField = (EditText) findViewById(R.id.celsius_textview);
        mFahrenheitField = (TextView) findViewById(R.id.fahrenheit_textview);
        mConvertButton = (Button) findViewById(R.id.conversion_button);
        mConvertButton.setOnClickListener(new ConvertButtonListener());
        mConverter = new TemperatureConverter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.converter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_info:
                showInfoDialog();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Show the info dialog.
     */
    private void showInfoDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.action_info)
                .setMessage(R.string.info)
                .show();
    }

    private final class ConvertButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (mConverter != null) {
                final String celsius = mCelsiusField.getText().toString();
                try {
                    final float celsiusValue = Float.parseFloat(celsius);
                    final float result = mConverter.convertCelsiusToFahrenheit(celsiusValue);
                    mFahrenheitField.setText(String.valueOf(result));
                } catch (NumberFormatException e) {
                    Log.e(TAG, "Could not parse celsius value for " + celsius);
                }
            }
        }
    }

}
