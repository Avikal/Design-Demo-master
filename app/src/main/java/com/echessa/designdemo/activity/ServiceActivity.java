package com.echessa.designdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.echessa.designdemo.MainActivity;
import com.echessa.designdemo.R;
import com.echessa.designdemo.fragments.RecyclerViewAdapter;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by avikal on 12/22/2015.
 */
public class ServiceActivity  extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView planets_list;
    RecyclerView.LayoutManager layout_manager;
    RecyclerViewAdapter adapter;
    CollapsingToolbarLayout collapsing_container;
    LinearLayout lineaer1,lineaer2,lineaer3,lineaer4,lineaer5,lineaer6,lineaer7,lineaer8,lineaer9,lineaer10,lineaer11,lineaer12,lineaer13,lineaer14,lineaer15,
            lineaer16,lineaer17,lineaer18,lineaer19,lineaer20,lineaer21,lineaer22,lineaer23,lineaer24,lineaer25,lineaer26,lineaer27,lineaer28,lineaer29,lineaer30,lineaer31,
            lineaer32,lineaer33,lineaer34;
    RelativeLayout realtivelist1,realtivelist2,realtivelist3,realtivelist4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technique5);
        this.overridePendingTransition(R.anim.animation_leave,
                R.anim.animation_enter);
        toolbar = (Toolbar) findViewById(R.id.technique_five_toolbar);
        planets_list = (RecyclerView) findViewById(R.id.days_list_5);
        collapsing_container = (CollapsingToolbarLayout) findViewById(R.id.collapsing_container);

        layout_manager = new LinearLayoutManager(this);
        planets_list.setLayoutManager(layout_manager);

        planets_list.setLayoutManager(new LinearLayoutManager(planets_list.getContext()));
        planets_list.setAdapter(new SimpleStringRecyclerViewAdapter(ServiceActivity.this));
//        adapter = new RecyclerViewAdapter(getResources().getStringArray(R.array.notification_list));
//        planets_list.setAdapter(adapter);

        setSupportActionBar(toolbar);

        TextView text = new TextView(this);
        text.setText("Serivce");
        text.setTextColor(Color.parseColor("#ffffff"));
//
        text.setTextAppearance(this, android.R.style.TextAppearance_Material_Widget_ActionBar_Title_Inverse);
//
        toolbar.addView(text);
//        toolbar.setTitle("Services");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }

        });
    }
    public class SimpleStringRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleStringRecyclerViewAdapter.ViewHolder> {

        private final TypedValue mTypedValue = new TypedValue();
        private int mBackground;
        private List<String> mValues;
        Context context;
        View rootView;
        public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView service_Name, service_Title;
            public CircleImageView service_Image;

            public ViewHolder(View view) {
                super(view);
                rootView = view;
                lineaer1 = (LinearLayout) rootView.findViewById(R.id.linear1);
                lineaer2 = (LinearLayout) rootView.findViewById(R.id.linear2);
                lineaer3 = (LinearLayout) rootView.findViewById(R.id.linear3);
                lineaer4 = (LinearLayout) rootView.findViewById(R.id.linear4);
                lineaer5 = (LinearLayout) rootView.findViewById(R.id.linear5);
                lineaer6 = (LinearLayout) rootView.findViewById(R.id.linear6);
                lineaer7 = (LinearLayout) rootView.findViewById(R.id.linear7);
                lineaer8 = (LinearLayout) rootView.findViewById(R.id.linear8);
                lineaer9 = (LinearLayout) rootView.findViewById(R.id.linear9);
                lineaer10 = (LinearLayout) rootView.findViewById(R.id.linear10);
                lineaer11 = (LinearLayout) rootView.findViewById(R.id.linear11);
                lineaer12 = (LinearLayout) rootView.findViewById(R.id.linear12);
                lineaer13= (LinearLayout) rootView.findViewById(R.id.linear13);
                lineaer14= (LinearLayout) rootView.findViewById(R.id.linear14);
                lineaer15 = (LinearLayout) rootView.findViewById(R.id.linear15);
                lineaer16 = (LinearLayout) rootView.findViewById(R.id.linear16);
                lineaer17 = (LinearLayout) rootView.findViewById(R.id.linear17);
                lineaer18 = (LinearLayout) rootView.findViewById(R.id.linear18);
                lineaer19 = (LinearLayout) rootView.findViewById(R.id.linear19);
                lineaer20 = (LinearLayout) rootView.findViewById(R.id.linear20);
                lineaer21 = (LinearLayout) rootView.findViewById(R.id.linear21);
                lineaer22 = (LinearLayout) rootView.findViewById(R.id.linear22);
                lineaer23 = (LinearLayout) rootView.findViewById(R.id.linear23);
                lineaer24 = (LinearLayout) rootView.findViewById(R.id.linear24);
                lineaer25 = (LinearLayout) rootView.findViewById(R.id.linear25);
                lineaer26 = (LinearLayout) rootView.findViewById(R.id.linear26);
                lineaer27 = (LinearLayout) rootView.findViewById(R.id.linear27);
                lineaer28 = (LinearLayout) rootView.findViewById(R.id.linear28);
                lineaer29 = (LinearLayout) rootView.findViewById(R.id.linear29);
                lineaer30 = (LinearLayout) rootView.findViewById(R.id.linear30);
                lineaer31 = (LinearLayout) rootView.findViewById(R.id.linear31);
                lineaer32 = (LinearLayout) rootView.findViewById(R.id.linear32);
                lineaer33 = (LinearLayout) rootView.findViewById(R.id.linear33);
                lineaer34 = (LinearLayout) rootView.findViewById(R.id.linear34);

                lineaer1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer13.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer14.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer15.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer16.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer17.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer18.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer19.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer20.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer21.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer22.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer23.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer24.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer25.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer26.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer27.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer28.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer29.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer30.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer31.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer32.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer33.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,BannerActivity1.class);
                        startActivity(intent);
                    }
                });
                lineaer34.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, BannerActivity1.class);
                        startActivity(intent);
                    }
                });
//                service_Name = (TextView) rootView.findViewById(R.id.service_name);
//                service_Title = (TextView) rootView.findViewById(R.id.service_charge);
//                service_Image = (CircleImageView) rootView.findViewById(R.id.service_image);


            }
        }

        public String getValueAt(int position) {
            return mValues.get(position);
        }

        public SimpleStringRecyclerViewAdapter(Context context) {
            this.context = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            rootView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.service_list, parent, false);
//            init();


            return new ViewHolder(rootView);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
//        holder.mBoundString = mValues.get(position);
//        holder.mTextView.setText(mValues.get(position));

//        holder.mView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Context context = v.getContext();
//                Intent intent = new Intent(context, CheeseDetailActivity.class);
//                intent.putExtra(CheeseDetailActivity.EXTRA_NAME, holder.mBoundString);
//
//                context.startActivity(intent);
//            }
//        });

//        Glide.with(holder.mImageView.getContext())
//                .load(Cheeses.getRandomCheeseDrawable())
//                .fitCenter()
//                .into(holder.mImageView);
        }

        @Override
        public int getItemCount() {
//        return mValues.size();

            return 1;
        }
    }
    @Override
    public void onBackPressed(){
        Intent main = new Intent(ServiceActivity.this, MainActivity.class);
        startActivity(main);
        finish();
    }
}
