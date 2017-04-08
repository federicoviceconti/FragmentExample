package com.example.personale.fragmentexample.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.personale.fragmentexample.R;
import com.example.personale.fragmentexample.adapter.AdapterPosition;
import com.example.personale.fragmentexample.adapter.AdapterRequest;
import com.example.personale.fragmentexample.utilities.Utility;

/**
 * Created by personale on 05/04/2017.
 */

public class MainActivity extends AppCompatActivity {

    private double x, y;
    private AdapterPosition adapterPosition;
    private AdapterRequest adapterRequest;
    private Menu menu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .addToBackStack("FragmentTab")
                .add(R.id.container, new FragmentTab())
                .commit();

        adapterPosition = new AdapterPosition(this);
        adapterRequest = new AdapterRequest(this);

        initialize();
    }

    private void initialize() {
        SharedPreferences preferences = getSharedPreferences(getString(R.string.preferences), Context.MODE_PRIVATE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Utility.setStatusBar(this, preferences.getInt(getString(R.string.preferences_dark), getColor(R.color.colorPrimaryDark)));
        }

        Utility.setToolbar(getSupportActionBar(), preferences.getInt(getString(R.string.preferences_primary), getResources().getColor(R.color.colorPrimaryDark)));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.menu = menu;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.setting:

                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(
                                R.anim.animation,
                                R.anim.animation1
                        )
                        .addToBackStack("Setting")
                        .replace(R.id.container, new SettingFragment())
                        .commit();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount() > 0){
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    public double getDataX(){
        return x;
    }

    public double getDataY(){
        return y;
    }

    public void setDataX(double x){
        this.x = x;
    }

    public void setDataY(double y){
        this.y = y;
    }

    public AdapterPosition getAdapterPosition(){
        return adapterPosition;
    }

    public Menu getMenu() {
        return menu;
    }

    public AdapterRequest getAdapterRequest() {
        return adapterRequest;
    }
}
