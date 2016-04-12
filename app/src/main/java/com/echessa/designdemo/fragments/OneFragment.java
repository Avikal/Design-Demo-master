package com.echessa.designdemo.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.echessa.designdemo.AnimationBanner;
import com.echessa.designdemo.DesignDemoRecyclerAdapter;
import com.echessa.designdemo.MainActivity;
import com.echessa.designdemo.R;
import com.echessa.designdemo.SlidingImage_Adapter;
import com.echessa.designdemo.activity.BannerActivity1;
import com.echessa.designdemo.activity.BannerActivity2;
import com.echessa.designdemo.activity.BannerActivity3;
import com.echessa.designdemo.activity.BannerActivity4;
import com.echessa.designdemo.model.ListItem;
import com.echessa.designdemo.model.NetworkCheckActivity;
import com.viewpagerindicator.CirclePageIndicator;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import de.hdodenhof.circleimageview.CircleImageView;


public class OneFragment extends Fragment {

    ListView listview;
    Context context;
    //    ListViewAdapter adapter;
    private AnimationBanner mBanner;
    View rootView;
    private List<ImageView> mImageViews;
    //    private ViewFlipper mViewFlipper;
//    private GestureDetector mGestureDetector;
    LinearLayout lineaer1,lineaer2,lineaer3,lineaer4,lineaer5,lineaer6,lineaer7,lineaer8,lineaer9,lineaer10,lineaer11,lineaer12,lineaer13,lineaer14,lineaer15,
            lineaer16,lineaer17,lineaer18,lineaer19,lineaer20,lineaer21,lineaer22,lineaer23,lineaer24,lineaer25,lineaer26,lineaer27,lineaer28,lineaer29,lineaer30,lineaer31,
            lineaer32,lineaer33,lineaer34;
    RelativeLayout realtivelist1,realtivelist2,realtivelist3,realtivelist4;
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES = {R.drawable.banner1, R.drawable.banner2, R.drawable.banner3};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    private ArrayList<String> ImagesArray1 = new ArrayList<String>();
    private ArrayList<ListItem> listData = new ArrayList<ListItem>();
    int[] resources = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5

    };
    public NetworkCheckActivity network;
    boolean isNetworkAvailable;
    public OneFragment() {
    }

    public OneFragment(Context context) {
        // Required empty public constructor
        this.context = context;
    }

    String[] name1 = {"John", "John1",
            "John2", "John3",
            "John4", "John5",
            "John6", "John6",
            "John7", "John8",
            "John9", "john10"};
    String[] date1 = {
            "Feb 12, 2015-10.30", "Feb 12, 2015-10.30",
            "Feb 12, 2015-10.30", "Feb 12, 2015-10.30",
            "Feb 12, 2015-10.30", "Feb 12, 2015-10.30",
            "Feb 12, 2015-10.30", "Feb 12, 2015-10.30",
            "Feb 12, 2015-10.30", "Feb 12, 2015-10.30",
            "Feb 12, 2015-10.30", "Feb 12, 2015-10.30"
    };
    private final Integer[] IMAGES_ICON1 = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4,
            R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4};
    TextView service_Name, service_Title;
    CircleImageView service_Image;
    RecyclerView planets_list;
    String[] imaages_url;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView rv = (RecyclerView) inflater.inflate(
                R.layout.fragment_one, container, false);
        network = new NetworkCheckActivity(context);
        isNetworkAvailable = network.isConnectingInternet();
        setupRecyclerView(rv);

        return rv;

    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new SimpleStringRecyclerViewAdapter(context));
    }


    public class SimpleStringRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleStringRecyclerViewAdapter.ViewHolder> {

        private final TypedValue mTypedValue = new TypedValue();
        private int mBackground;
        private List<String> mValues;
        Context context;

        public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView service_Name, service_Title;
            public CircleImageView service_Image;

            public ViewHolder(View view) {
                super(view);
                rootView = view;

//                service_Name = (TextView) rootView.findViewById(R.id.service_name);
////                service_Title = (TextView) rootView.findViewById(R.id.service_charge);
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
                    .inflate(R.layout.list_patient, parent, false);
            init();
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
                    Intent intent = new Intent(context,BannerActivity1.class);
                    startActivity(intent);
                }
            });
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

    private void init() {

        ListItem bannerdata = new ListItem();
        imaages_url = getResources().getStringArray(R.array.images_array);
        mPager = (ViewPager) rootView.findViewById(R.id.pager);
        if(isNetworkAvailable) {
            for (int i = 0; i < imaages_url.length; i++) {

//                bannerdata.setUrl(imaages_url[i]);
                ImagesArray1.add(imaages_url[i]);
            }

            mPager.setAdapter(new SlidingImage_Adapter(context, ImagesArray1,isNetworkAvailable));
        }
        else
        {
            for (int i = 0; i < IMAGES.length; i++)
                ImagesArray.add(IMAGES[i]);

            mPager.setAdapter(new SlidingImage_Adapter(context, ImagesArray));
        }










        CirclePageIndicator indicator = (CirclePageIndicator)
                rootView.findViewById(R.id.indicator);

        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

        indicator.setRadius(5 * density);


        NUM_PAGES = IMAGES.length;


        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 6000, 6000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });


    }
}
