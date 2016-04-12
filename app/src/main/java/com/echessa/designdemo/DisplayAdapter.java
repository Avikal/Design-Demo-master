package com.echessa.designdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class DisplayAdapter extends BaseAdapter {
	private Context mContext;
	// private ArrayList<String> id;
	private ArrayList<String> message;

	// private ArrayList<String> lastName;

	public DisplayAdapter(Context c, ArrayList<String> message) {
		this.mContext = c;

		// this.id = id;
		this.message = message;
		// this.lastName = lname;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return message.size();
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public View getView(int pos, View child, ViewGroup parent) {
		Holder mHolder;
		LayoutInflater layoutInflater;
		if (child == null) {
			layoutInflater = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			child = layoutInflater.inflate(R.layout.listcell_xml, null);
			mHolder = new Holder();
			// mHolder.txt_id = (TextView) child.findViewById(R.id.txt_id);
			// mHolder.txt_fName = (TextView)
			// child.findViewById(R.id.txt_fName);
			mHolder.txt_message = (TextView) child
					.findViewById(R.id.txt_message);
			child.setTag(mHolder);
		} else {
			mHolder = (Holder) child.getTag();
		}
		// mHolder.txt_id.setText(id.get(pos));
		// mHolder.txt_fName.setText(firstName.get(pos));
		mHolder.txt_message.setText(message.get(pos));

		return child;
	}

	public class Holder {
		// TextView txt_id;
		// TextView txt_fName;
		TextView txt_message;
	}

}