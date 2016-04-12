package com.echessa.designdemo.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.echessa.designdemo.AnimationBanner;
import com.echessa.designdemo.R;
import com.echessa.designdemo.activity.BannerActivity1;
import com.echessa.designdemo.activity.BannerActivity2;
import com.echessa.designdemo.activity.BannerActivity3;

import java.util.ArrayList;
import java.util.List;


public class TwoFragment extends Fragment {

    ListView listview;
    Context context;
//    ListViewAdapter adapter;
    private AnimationBanner mBanner;
    View rootView;
    private List<ImageView> mImageViews;
    //    private ViewFlipper mViewFlipper;
//    private GestureDetector mGestureDetector;
    RelativeLayout realtivelist1,realtivelist2,realtivelist3,realtivelist4;
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    int[] resources = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5

    };

    public TwoFragment() {
    }

    public TwoFragment(Context context) {
        // Required empty public constructor
        this.context = context;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView rv = (RecyclerView) inflater.inflate(
                R.layout.fragment_two, container, false);
        setupRecyclerView(rv);
        return rv;

    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new SimpleStringRecyclerViewAdapter(context));
    }


    public class SimpleStringRecyclerViewAdapter extends RecyclerView.Adapter<SimpleStringRecyclerViewAdapter.ViewHolder> {

        private final TypedValue mTypedValue = new TypedValue();
        private int mBackground;
        private List<String> mValues;
        Context context;

        public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView service_Name, service_Title;


            public ViewHolder(View view) {
                super(view);
                rootView = view;
//                service_Name = (TextView) rootView.findViewById(R.id.service_name);
//                service_Title = (TextView) rootView.findViewById(R.id.service_charge);



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
                    .inflate(R.layout.rat_list, parent, false);



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


    /*private class ListViewAdapter extends BaseAdapter {

        // Declare Variables
        Context context;
        String[] values;

        LayoutInflater inflater;

        TextView time_text,member_text,non_member_text;
        ImageView image_icon;
        String[] time = { "45 Min", "30 Min",
                "45 Min", "20 Min",
                "30 Min", "10 Min",
                "45 Min", "30 Min",
                "20 Min", "10 Min",
                "15 Min", "20 Min" };

        String[] member_price = {
                "360 INR","360 INR",
                "360 INR","360 INR",
                "360 INR","360 INR",
                "360 INR","360 INR",
                "360 INR","360 INR",
                "360 INR","360 INR"
        };

        String[] regular_price = {
                "450 INR","450 INR",
                "450 INR","450 INR",
                "450 INR","450 INR",
                "450 INR","450 INR",
                "450 INR","450 INR",
                "450 INR","450 INR"
        };
        public ListViewAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return time.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        public View getView(final int position, View convertView,
                            ViewGroup parent) {
            inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View itemView = inflater.inflate(R.layout.rat_list_item,
                    parent, false);
//            image_icon = (ImageView) itemView.findViewById(R.id.list_image);
            time_text = (TextView) itemView.findViewById(R.id.text_time);
            member_text = (TextView) itemView.findViewById(R.id.text_member);
            non_member_text = (TextView) itemView.findViewById(R.id.text_non_member);


            time_text.setText(time[position]);
            member_text.setText(member_price[position]);
            non_member_text.setText(regular_price[position]);
            return itemView;
        }

    }*/


}
