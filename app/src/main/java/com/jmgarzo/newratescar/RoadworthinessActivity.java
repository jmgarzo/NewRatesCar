package com.jmgarzo.newratescar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jmgarzo.newratescar.provider.roadworthiness.RoadworthinessColumns;

public class RoadworthinessActivity extends AppCompatActivity implements RoadworthinessFragment.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roadworthiness);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (view.getContext(),RoadworthinesDetail.class);
                startActivity(intent);

//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    @Override
    public void onItemSelected(Long roadId) {
        Intent intent = new Intent(this, RoadworthinesDetail.class);
        intent.putExtra(RoadworthinessColumns._ID,roadId);
        startActivity(intent);
    }



}
