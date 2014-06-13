package com.devoxx.android.temperatureconverter;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Temperature-conversion activity.
 */
public class ConverterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converter);


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


}
