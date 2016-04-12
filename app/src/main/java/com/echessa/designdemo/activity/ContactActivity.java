package com.echessa.designdemo.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.echessa.designdemo.MainActivity;
import com.echessa.designdemo.R;

/**
 * Created by avikal on 12/22/2015.
 */
public class ContactActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView days_list;
    ImageView location_icn1,location_icn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        this.overridePendingTransition(R.anim.animation_leave,
                R.anim.animation_enter);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setSupportActionBar(toolbar);

        location_icn1 = (ImageView) findViewById(R.id.location1);
        location_icn2 = (ImageView) findViewById(R.id.location2);

        toolbar.setTitle(R.string.title_activity_contact);
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_action_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });

        location_icn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent map1 = new Intent(ContactActivity.this,GoogleMapClass.class);
                    map1.putExtra("location_city",true);

                    startActivity(map1);
            }
        });
        location_icn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent map2 = new Intent(ContactActivity.this,GoogleMapClass.class);
                map2.putExtra("location_city", false);
                startActivity(map2);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Intent main = new Intent(ContactActivity.this, MainActivity.class);
            startActivity(main);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed(){
        Intent main = new Intent(ContactActivity.this, MainActivity.class);
        startActivity(main);
        finish();
    }
}