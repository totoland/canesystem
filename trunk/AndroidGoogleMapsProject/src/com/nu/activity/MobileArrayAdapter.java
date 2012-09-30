package com.nu.activity;

import com.android.activity.R;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MobileArrayAdapter extends ArrayAdapter<String> {
	private final Context context;
	private final String[] values;

	public MobileArrayAdapter(Context context, String[] values) {
		super(context, R.layout.list_menu_report, values);
		this.context = context;
		this.values = values;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.list_menu_report, parent, false);
		if(position%2==0){
			rowView.setBackgroundResource(R.drawable.bg_row1);
		}
		else{
			rowView.setBackgroundResource(R.drawable.bg_row2);
		}
		TextView textView = (TextView) rowView.findViewById(R.id.label);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
		textView.setText(values[position]);

		// Change icon based on name
		String s = values[position];

		//System.out.println(s);
		imageView.setImageResource(R.drawable.arrowyellow);
		if (s.equals("WindowsMobile")) {
			//imageView.setImageResource(R.drawable.arrow_right);
		} else if (s.equals("iOS")) {
			//imageView.setImageResource(R.drawable.ios_logo);
		} else if (s.equals("Blackberry")) {
			//imageView.setImageResource(R.drawable.blackberry_logo);
		} else {
			//imageView.setImageResource(R.drawable.android_logo);
		}

		return rowView;
	}
}
