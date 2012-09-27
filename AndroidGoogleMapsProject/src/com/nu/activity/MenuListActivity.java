package com.nu.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;

public class MenuListActivity extends ListActivity {

	static final String[] MEMU_LIST = new String[] { "บันทึกข้อมูลอ้อย", "กิจกรรมอ้อยปลูกใหม่ครั่งที่1",
			"กิจกรรมอ้อยปลูกใหม่ครั่งที่2", "กิจกรรมอ้อยตอครั้งที่1" ,"กิจกรรมอ้อยตอครั้งที่2"};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//setListAdapter(new ArrayAdapter<String>(this, R.layout.list_mobile,
		//		R.id.label, MOBILE_OS));

		//this.set
		setListAdapter(new MobileArrayAdapter(this, MEMU_LIST));

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		//get selected items
//		String selectedValue = (String) getListAdapter().getItem(position);
//		Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();
		String[] values;
		String s = MEMU_LIST[position];
		if (s.equals("บันทึกข้อมูลอ้อย")) {
            Intent myIntent = new Intent(v.getContext(), Note1Activity.class);
            startActivityForResult(myIntent, 0);	
		}else if (s.equals("กิจกรรมอ้อยปลูกใหม่ครั่งที่1")) {
            Intent myIntent = new Intent(v.getContext(), Note2Activity.class);
            startActivityForResult(myIntent, 0);		
		}else if (s.equals("กิจกรรมอ้อยปลูกใหม่ครั่งที่2")) {		
            Intent myIntent = new Intent(v.getContext(), Note3Activity.class);
            startActivityForResult(myIntent, 0);
		}else if (s.equals("กิจกรรมอ้อยตอครั้งที่1")) {		
            Intent myIntent = new Intent(v.getContext(), Note3Activity.class);
            startActivityForResult(myIntent, 0);
		}else if (s.equals("กิจกรรมอ้อยตอครั้งที่2")) {		
            Intent myIntent = new Intent(v.getContext(), Note3Activity.class);
            startActivityForResult(myIntent, 0);
		}
		

	}

}