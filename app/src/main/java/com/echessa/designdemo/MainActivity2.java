package com.echessa.designdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gcm.GCMRegistrar;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ListView userList;
    DatabaseHandler db;
    Controller aController;
    AsyncTask<Void, Void, Void> mRegisterTask;
    ArrayList<String> user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_notification);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        aController = (Controller) getApplicationContext();
        // Check internet Collection is Available or Not
        if (!aController.isConnectingToInternet()) {
            // Internet Connection is not present
            aController.showAlertDialog(MainActivity2.this,
                    "Internet Connection Error",
                    "Please connect to working Internet connection", false);

            // stop executing code by return
            return;
        }

        // Check if GCM configuration is set
        if (Config.YOUR_SERVER_URL == null || Config.GOOGLE_SENDER_ID == null
                || Config.YOUR_SERVER_URL.length() == 0
                || Config.GOOGLE_SENDER_ID.length() == 0) {

            // GCM sernder id / server url is missing
            aController.showAlertDialog(MainActivity2.this,
                    "Configuration Error!",
                    "Please set your Server URL and GCM Sender ID", false);

            // stop executing code by return
            return;
        }

        userList = (ListView) findViewById(R.id.List);
        db = new DatabaseHandler(getApplicationContext());
        // Get Global Controller Class object (see application tag in
        // AndroidManifest.xml)
        aController = (Controller) getApplicationContext();
        db = db.open();
        user = new ArrayList<String>();
        user = db.getUserDetails();
        DisplayAdapter disadpt = new DisplayAdapter(MainActivity2.this,user);
        userList.setAdapter(disadpt);

        // Make sure the device has the proper dependencies.
        GCMRegistrar.checkDevice(this);

        // Make sure the manifest permissions was properly set
        GCMRegistrar.checkManifest(this);


        registerReceiver(mHandleMessageReceiver, new IntentFilter(
                Config.DISPLAY_MESSAGE_ACTION));

        // Get GCM registration id
        final String regId = GCMRegistrar.getRegistrationId(this);
        Toast.makeText(getApplicationContext(), "Avikal " + regId, Toast.LENGTH_SHORT).show();
        // Check if regid already presents
        if (regId.equals("")) {

            // Register with GCM
            GCMRegistrar.register(this, Config.GOOGLE_SENDER_ID);

        } else {

            // Device is already registered on GCM Server
            if (GCMRegistrar.isRegisteredOnServer(this)) {

                // Skips registration.
//						Toast.makeText(getApplicationContext(),
//								"Already registered with GCM Server", Toast.LENGTH_LONG)
//								.show();

            } else {

                // Try to register again, but not in the UI thread.
                // It's also necessary to cancel the thread onDestroy(),
                // hence the use of AsyncTask instead of a raw thread.

                final Context context = this;
                mRegisterTask = new AsyncTask<Void, Void, Void>() {

                    @Override
                    protected Void doInBackground(Void... params) {

                        // Register on our server
                        // On server creates a new user
                        aController.register(context, "Nitizart", "Mobile", regId);

                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void result) {
                        mRegisterTask = null;
                    }

                };

                // execute AsyncTask
                mRegisterTask.execute(null, null, null);
            }
        }
    }

    // Create a broadcast receiver to get message and show on screen
    private final BroadcastReceiver mHandleMessageReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {

            String newMessage = intent.getExtras().getString(
                    Config.EXTRA_MESSAGE);

            // Waking up mobile if it is sleeping
            aController.acquireWakeLock(getApplicationContext());
//			 db.addUser(newMessage);
            // Display message on the screen
//			lblMessage.append(newMessage + "\n");

            // Log.d("Avikal ", userNa);
            // lblMessage.setText(userNa);
//			Toast.makeText(getApplicationContext(),
//					"Got Message: " + newMessage, Toast.LENGTH_LONG).show();

            // Releasing wake lock
            aController.releaseWakeLock();
        }
    };

    @Override
    protected void onDestroy() {
        // Cancel AsyncTask
        if (mRegisterTask != null) {
            mRegisterTask.cancel(true);
        }
        try {
            // Unregister Broadcast Receiver
            unregisterReceiver(mHandleMessageReceiver);

            // Clear internal resources.
            GCMRegistrar.onDestroy(this);

        } catch (Exception e) {
//            Log.e("UnRegister Receiver Error", "> " + e.getMessage());
        }
        super.onDestroy();
    }

}
