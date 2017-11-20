package com.example.varia.imgurimages;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.varia.imgurimages.fragment.GridFragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Fragment fragmentHotelsList = getSupportFragmentManager().findFragmentById(R.id.container);
        if (fragmentHotelsList == null) {
            fragmentHotelsList = new GridFragment();
            getSupportFragmentManager().
                    beginTransaction().add(R.id.container, fragmentHotelsList)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                break;
        }


        return true;
    }
}
