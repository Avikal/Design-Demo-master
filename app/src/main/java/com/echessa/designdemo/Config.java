package com.echessa.designdemo;

public interface Config {

	
	// CONSTANTShttp://sigmamtech.com/gcm_server_files/register.php
//	static final String YOUR_SERVER_URL =  "YOUR_SERVER_URL/gcm_server_files/register.php";
//	static final String YOUR_SERVER_URL =  "http://sigmamtech.com/gcm_server_files/register.php";
    static final String YOUR_SERVER_URL =  "http://sigmamtech.com/citylook/gcm_server_files/register.php";
	// YOUR_SERVER_URL : Server url where you have placed your server files
    // Google project id
    static final String GOOGLE_SENDER_ID = "59669889692";  // Place here your Google project id

    /**
     * Tag used on log messages.
     */
    static final String TAG = "Simahasth 2016 News";

    static final String DISPLAY_MESSAGE_ACTION =
            "com.androidexample.gcm.DISPLAY_MESSAGE";

    static final String EXTRA_MESSAGE = "message";
		
	
}
