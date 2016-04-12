package com.echessa.designdemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by avikal on 1/7/2016.
 */
public class OfferActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView days_list;
    ImageView location_icn1,location_icn2;

    JSONObject jsonobject;
    JSONArray jsonarray;
    ListView listview;
    ListViewAdapter adapter;
    ProgressDialog mProgressDialog;
    ArrayList<HashMap<String, String>> arraylist;
    static String DESCRIPTION = "description";
    static String ADDRESS1 = "address1";
    static String ADDRESS2 = "address2";
    static String WARD_NO = "ward_number";
    static String COLONY_NAME = "colony_name";
    static String CITY = "city";
    static String STATE = "state";
    //	static String COUNTRY = "address1";
//	static String POPULATION = "city";
    static String ID = "complain_id";
    //	static String FLAG = "flag";
    public static String img_url = "http://sigmamtech.com/indoreCity/uploads/";
    public static String img;
    ImageView icon_back;
    View rootView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.offers_xml);
        this.overridePendingTransition(R.anim.animation_leave,
                R.anim.animation_enter);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.title_activity_contact);
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_action_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

                Intent offers = new Intent(OfferActivity.this, MainActivity.class);
                startActivity(offers);

            }
        });

        listview = (ListView)findViewById(R.id.listview);

        new DownloadJSON().execute();
    }

    private class DownloadJSON extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(OfferActivity.this);
            // Set progressdialog title
//			mProgressDialog.setTitle("Android JSON Parse Tutorial");
            // Set progressdialog message http://www.androidbegin.com/tutorial/jsonparsetutorial.txt
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            // Create an array
            arraylist = new ArrayList<HashMap<String, String>>();
            // Retrieve JSON Objects from the given URL address
            jsonobject = JSONfunctions
                    .getJSONfromURL("http://sigmamtech.com/citylook/android_api/offers/");

            try {
                // Locate the array name in JSON
                jsonarray = jsonobject.getJSONArray("offers");

                for (int i = 0; i < jsonarray.length(); i++) {
                    HashMap<String, String> map = new HashMap<String, String>();
                    jsonobject = jsonarray.getJSONObject(i);
                    // Retrive JSON Objects
                    map.put("complain_id", jsonobject.getString("offer_title"));
                    map.put("description", jsonobject.getString("offer_image"));
                    map.put("address1", jsonobject.getString("offer_desc"));
                    map.put("address2", jsonobject.getString("offer_discount"));
//					map.put("ward_number", jsonobject.getString("ward_number"));
//					map.put("colony_name", jsonobject.getString("colony_name"));
//					map.put("city", jsonobject.getString("city"));
//					map.put("state", jsonobject.getString("state"));
//					map.put("flag", img_url);

                    System.out.println("Country List MAin actviity k andar =  "+jsonobject.getString("offer_image"));
//					map.put("city", jsonobject.getString("city"));
//					map.put("complain_id", jsonobject.getString("complain_id"));
//					Integer comlain_id = jsonobject.getInt("complain_id");
//					img = img_url+comlain_id+".png";
//					map.put("flag", img_url);
                    // Set the JSON Objects into the array
                    arraylist.add(map);
                }
            } catch (JSONException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void args) {
            // Locate the listview in listview_main.xml

            // Pass the results into ListViewAdapter.java
            adapter = new ListViewAdapter(OfferActivity.this, arraylist);
            // Set the adapter to the ListView
            listview.setAdapter(adapter);
            // Close the progressdialog
            mProgressDialog.dismiss();
        }
    }
}
