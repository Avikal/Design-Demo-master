package com.echessa.designdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.echessa.designdemo.MainActivity;
import com.echessa.designdemo.R;
import com.echessa.designdemo.fragments.RecyclerViewAdapter;

/**
 * Created by avikal on 12/22/2015.
 */
public class NotificationActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView planets_list;
    RecyclerView.LayoutManager layout_manager;
    RecyclerViewAdapter adapter;
//    CollapsingToolbarLayout collapsing_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technique5);
        this.overridePendingTransition(R.anim.animation_enter,
                R.anim.animation_leave);
        toolbar = (Toolbar) findViewById(R.id.technique_five_toolbar);
        planets_list = (RecyclerView) findViewById(R.id.days_list_5);
//        collapsing_container = (CollapsingToolbarLayout) findViewById(R.id.collapsing_container);

        layout_manager = new LinearLayoutManager(this);
        planets_list.setLayoutManager(layout_manager);

        adapter = new RecyclerViewAdapter(getResources().getStringArray(R.array.notification_list));
        planets_list.setAdapter(adapter);

        setSupportActionBar(toolbar);

        TextView text = new TextView(this);
        text.setText("Notification");
        text.setTextAppearance(this, android.R.style.TextAppearance_Material_Widget_ActionBar_Title_Inverse);

        toolbar.addView(text);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });
    }
    @Override
    public void onBackPressed(){
        Intent main = new Intent(NotificationActivity.this, MainActivity.class);
        startActivity(main);
        finish();
    }
}
