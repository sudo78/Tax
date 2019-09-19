package com.mytax.sudo.incometax;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void incometaxClick(View view) {
        Intent i = new Intent(MainActivity.this, NavigationDrawerActivity.class);
        startActivity(i);
    }

    public void salestaxClick(View view) {

        //Intent i = new Intent(MainActivity.this, SalesTax.class);
        //startActivity(i);
    }
}
