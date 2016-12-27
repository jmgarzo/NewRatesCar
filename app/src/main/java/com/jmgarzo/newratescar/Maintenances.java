package com.jmgarzo.newratescar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jmgarzo.newratescar.provider.maintenance.MaintenanceColumns;

public class Maintenances extends AppCompatActivity implements MaintenancesFragment.Callback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenances);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (view.getContext(),MaintenanceDetail.class);
                startActivity(intent);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onItemSelected(Long maintenanceId) {
        Intent intent = new Intent(this, MaintenanceDetail.class);
        intent.putExtra(MaintenanceColumns._ID,maintenanceId);
        startActivity(intent);
    }
}
