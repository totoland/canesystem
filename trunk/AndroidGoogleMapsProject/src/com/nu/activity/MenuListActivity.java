package com.nu.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;

public class MenuListActivity extends ListActivity {

	static final String[] MEMU_LIST = new String[] { "�ѹ�֡����������", "�Ԩ�������»�١������觷��1",
			"�Ԩ�������»�١������觷��2", "�Ԩ�������µͤ��駷��1" ,"�Ԩ�������µͤ��駷��2"};

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
		if (s.equals("�ѹ�֡����������")) {
            Intent myIntent = new Intent(v.getContext(), Note1Activity.class);
            startActivityForResult(myIntent, 0);	
		}else if (s.equals("�Ԩ�������»�١������觷��1")) {
            Intent myIntent = new Intent(v.getContext(), Note2Activity.class);
            startActivityForResult(myIntent, 0);		
		}else if (s.equals("�Ԩ�������»�١������觷��2")) {		
            Intent myIntent = new Intent(v.getContext(), Note3Activity.class);
            startActivityForResult(myIntent, 0);
		}else if (s.equals("�Ԩ�������µͤ��駷��1")) {		
            Intent myIntent = new Intent(v.getContext(), Note3Activity.class);
            startActivityForResult(myIntent, 0);
		}else if (s.equals("�Ԩ�������µͤ��駷��2")) {		
            Intent myIntent = new Intent(v.getContext(), Note3Activity.class);
            startActivityForResult(myIntent, 0);
		}
		

	}

}