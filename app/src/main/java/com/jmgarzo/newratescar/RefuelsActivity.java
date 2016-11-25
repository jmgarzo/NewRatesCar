package com.jmgarzo.newratescar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class RefuelsActivity extends AppCompatActivity implements RefuelsFragment.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refuels);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (view.getContext(),RefuelDetailActivity.class);
                startActivity(intent);

            }
        });


    }

    @Override
    public void onItemSelected(Long vehicleId) {
//        Intent intent = new Intent(this, VehicleDetailActivity.class);
//        intent.putExtra(VehicleColumns._ID,vehicleId);
//        startActivity(intent);
    }

}
