/**
 * Author: Ravi Tamada
 * URL: www.androidhive.info
 * twitter: http://twitter.com/ravitamada
 * */
package com.echessa.designdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {

	String srt;
	// All Static variables
	// Database Version.
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "News_api";

	// Login table name
	private static final String TABLE_LOGIN = "news_message";

	// Login Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_MESSAGE = "message";
	// private static final String KEY_EMAIL = "email";
	// private static final String KEY_UID = "uid";
	// private static final String KEY_CREATED_AT = "created_at";
	public Context context;

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.context = context;
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_LOGIN_TABLE = "CREATE TABLE " + TABLE_LOGIN + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_MESSAGE + " TEXT"
				+ ")";
		db.execSQL(CREATE_LOGIN_TABLE);
	}

	public DatabaseHandler open() throws SQLException {
		SQLiteDatabase db = this.getReadableDatabase();
		return this;
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGIN);

		// Create tables again
		onCreate(db);
	}

	/**
	 * Storing user details in database
	 * */
	public void addUser(String message) {
		SQLiteDatabase db = this.getWritableDatabase();
//		Toast.makeText(context, "DataBase Insert "+message, 2000).show();
		ContentValues values = new ContentValues();
		values.put(KEY_MESSAGE, message); // Name
		// values.put(KEY_EMAIL, email); // Email
		// values.put(KEY_UID, uid); // Email
		// values.put(KEY_CREATED_AT, created_at); // Created At
		Toast.makeText(context, "Avikal "+message, 1000).show();
		// Inserting Row
		db.insert(TABLE_LOGIN, null, values);
		db.close(); // Closing database connection
	}

	public long updateUser2(String name, String newEmail) {
		long d = 0;
		SQLiteDatabase db = this.getWritableDatabase();

		// Cursor cursor=db.query("login_table", null, " name=?", new
		// String[]{person.getEmail()}, null, null, null);
		ContentValues values = new ContentValues();

		// values.put(KEY_NAME, name);
		// values.put(KEY_PHONE, person.getPhoneNo());
		// values.put(KEY_EMAIL, newEmail);
		// values.put(KEY_PASS, person.getPass());
		String name1 = name;
		Toast.makeText(context, name1, 10).show();

		// d = db.update(TABLE_LOGIN, values, KEY_EMAIL + " = ?",
		// new String[] { String.valueOf(newEmail) });
		db.close();

		return d;
	}

	/**
	 * Getting user data from database
	 * */
	public ArrayList<String> getUserDetails() {
		ArrayList<String>  user = new ArrayList<String>();
		String selectQuery = "SELECT  * FROM " + TABLE_LOGIN + " ORDER BY id DESC";

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		// Move to first row
		cursor.moveToFirst();
		if (cursor.getCount() > 0) 
		do
		{
			
			 srt= cursor.getString(cursor.getColumnIndex(KEY_MESSAGE));
			user.add(srt);
		}while(cursor.moveToNext());
		cursor.close();
		db.close();
		// return user
		return user;
	}

	

	
	/**
	 * Getting user login status return true if rows are there in table
	 * */
	public int getRowCount() {
		String countQuery = "SELECT  * FROM " + TABLE_LOGIN;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		int rowCount = cursor.getCount();
		db.close();
		cursor.close();

		// return row count
		return rowCount;
	}

	/**
	 * Re crate database Delete all tables and create them again
	 * */
	public void resetTables() {
		SQLiteDatabase db = this.getWritableDatabase();
		// Delete All Rows
		db.delete(TABLE_LOGIN, null, null);
		db.close();
	}

}
