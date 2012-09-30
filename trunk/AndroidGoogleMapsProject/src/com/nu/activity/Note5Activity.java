package com.nu.activity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import com.android.activity.MenuActivity;
import com.android.activity.R;
import com.android.gen.formgenerator.FormActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class Note5Activity extends FormActivity {
	/** Called when the activity is first created. */
	// Start Date
	static final int DATE_DIALOG_ID_1 = 111;
	static final int DATE_DIALOG_ID_2 = 222;
	static final int DATE_DIALOG_ID_3 = 333;

	private ImageButton btnDate1;
	private ImageButton btnDate2;
	private ImageButton btnDate3;

	private EditText textDate1;
	private EditText textDate2;
	private EditText textDate3;

	private int year_1;
	private int month_1;
	private int day_1;

	private int year_2;
	private int month_2;
	private int day_2;

	private int year_3;
	private int month_3;
	private int day_3;
	// End Date

	private Spinner spinner1, spinner2;

	@Override
	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.main);
//
//		Display display = getWindowManager().getDefaultDisplay();
//		Point size = new Point();
//		int width = display.getWidth();// size.x;
//		int height = display.getHeight();
//		
//		LinearLayout mainLayout = (LinearLayout) findViewById(R.id.widget0);
//		mainLayout =  new DrawForm().doDraw(this, mainLayout, Note5Activity.class.getSimpleName(), width, height);
//		
////		setCurrentDateOnView();
////		addListenerOnButton();
////		addItemsOnSpinner1();
////		addItemsOnSpinner2();
		super.onCreate( savedInstanceState );
        generateForm( FormActivity.parseFileToString( this, "schemas.json" ) );
        save();
	}

//	private int getX_leble(int column) {
//		if (column == 1) {
//			return Config.X_LABEL_1;
//		} else if (column == 2) {
//			return Config.X_LABEL_2;
//		} else if (column == 3) {
//			return Config.X_LABEL_3;
//		}
//
//		return 0;
//	}
//
//	private int getX_field(int column) {
//		if (column == 1) {
//			return Config.X_FIELD_1;
//		} else if (column == 2) {
//			return Config.X_FIELD_2;
//		} else if (column == 3) {
//			return Config.X_FIELD_3;
//		}
//
//		return 0;
//	}

	public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.save_back_cap_menu, menu);
        return true;
    }

	public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.item_save) {
        }else if(item.getItemId()==R.id.item_cap){
    
        }else if(item.getItemId()==R.id.item_back_home){
        	 Intent myIntent = new Intent(this, MenuActivity.class);
             startActivityForResult(myIntent, 0);
        }
        return true;
    }
	
	public void setCurrentDateOnView() {

		textDate1 = (EditText) findViewById(202);
		textDate2 = (EditText) findViewById(203);
		textDate3 = (EditText) findViewById(204);

		final Calendar c = Calendar.getInstance();
		year_1 = c.get(Calendar.YEAR);
		month_1 = c.get(Calendar.MONTH);
		day_1 = c.get(Calendar.DAY_OF_MONTH);

		year_2 = c.get(Calendar.YEAR);
		month_2 = c.get(Calendar.MONTH);
		day_2 = c.get(Calendar.DAY_OF_MONTH);

		year_3 = c.get(Calendar.YEAR);
		month_3 = c.get(Calendar.MONTH);
		day_3 = c.get(Calendar.DAY_OF_MONTH);

		// set current date into textview
		textDate1.setText(new StringBuilder()
				// Month is 0 based, just add 1
				.append(month_1 + 1).append("-").append(day_1).append("-")
				.append(year_1).append(" "));
		textDate2.setText(new StringBuilder()
				// Month is 0 based, just add 1
				.append(month_2 + 1).append("-").append(day_2).append("-")
				.append(year_2).append(" "));
		textDate3.setText(new StringBuilder()
				// Month is 0 based, just add 1
				.append(month_3 + 1).append("-").append(day_3).append("-")
				.append(year_3).append(" "));

	}

	public void addListenerOnButton() {
		btnDate1 = (ImageButton) findViewById(302);
		btnDate1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {

				showDialog(DATE_DIALOG_ID_1);
			}
		});

		btnDate2 = (ImageButton) findViewById(303);
		btnDate2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				showDialog(DATE_DIALOG_ID_2);
			}
		});

		btnDate3 = (ImageButton) findViewById(304);
		btnDate3.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				showDialog(DATE_DIALOG_ID_3);
			}
		});

	}

	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DATE_DIALOG_ID_1:
			return new DatePickerDialog(this, date1PickerListener, year_1,
					month_1, day_1);
		case DATE_DIALOG_ID_2:
			return new DatePickerDialog(this, date2PickerListener, year_2,
					month_2, day_3);
		case DATE_DIALOG_ID_3:
			return new DatePickerDialog(this, date3PickerListener, year_3,
					month_2, day_3);
		}
		return null;
	}

	private DatePickerDialog.OnDateSetListener date1PickerListener = new DatePickerDialog.OnDateSetListener() {
		public void onDateSet(DatePicker view, int selectedYear,
				int selectedMonth, int selectedDay) {
			year_1 = selectedYear;
			month_1 = selectedMonth;
			day_1 = selectedDay;
			textDate1.setText(new StringBuilder().append(month_1 + 1)
					.append("-").append(day_1).append("-").append(year_1)
					.append(" "));
		}
	};

	private DatePickerDialog.OnDateSetListener date2PickerListener = new DatePickerDialog.OnDateSetListener() {
		public void onDateSet(DatePicker view, int selectedYear,
				int selectedMonth, int selectedDay) {
			year_2 = selectedYear;
			month_2 = selectedMonth;
			day_2 = selectedDay;
			textDate2.setText(new StringBuilder().append(month_2 + 1)
					.append("-").append(day_2).append("-").append(year_2)
					.append(" "));
		}
	};

	private DatePickerDialog.OnDateSetListener date3PickerListener = new DatePickerDialog.OnDateSetListener() {
		public void onDateSet(DatePicker view, int selectedYear,
				int selectedMonth, int selectedDay) {
			year_3 = selectedYear;
			month_3 = selectedMonth;
			day_3 = selectedDay;
			textDate3.setText(new StringBuilder().append(month_3 + 1)
					.append("-").append(day_3).append("-").append(year_3)
					.append(" "));
		}
	};

	// Start Spinner
	public void addItemsOnSpinner1() {
		spinner1 = (Spinner) findViewById(200 + 6);
		List<String> list = new ArrayList<String>();
		list.add("��س����͡");
		list.add("16-16-2");
		list.add("16-16-10");
		list.add("16-16-16");
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(dataAdapter);
	}

	public void addItemsOnSpinner2() {

		spinner2 = (Spinner) findViewById(200 + 7);
		List<String> list = new ArrayList<String>();
		list.add("��س����͡");
		list.add("��������");
		list.add("��е���");
		list.add("���������");
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner2.setAdapter(dataAdapter);
	}
	// End Sprinner
}