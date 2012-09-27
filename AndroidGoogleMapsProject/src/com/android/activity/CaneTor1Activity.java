package com.android.activity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class CaneTor1Activity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cane_tor1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_cane_tor1, menu);
        return true;
    }
}
