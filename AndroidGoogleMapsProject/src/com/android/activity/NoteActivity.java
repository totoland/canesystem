package com.android.activity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class NoteActivity extends Activity {
	
	static final int DATE_DIALOG_ID_1 = 111;
	static final int DATE_DIALOG_ID_2 = 222;
	static final int DATE_DIALOG_ID_3 = 333;
	
	private ImageButton btnDate1;
	private ImageButton btnDate2;
	private ImageButton btnDate3;
	
	private TextView textDate1;
	private TextView textDate2;
	private TextView textDate3;
	
	private int year_1;
	private int month_1;
	private int day_1;
	
	private int year_2;
	private int month_2;
	private int day_2;
	
	private int year_3;
	private int month_3;
	private int day_3;
	//Spinner-------------------
	private Spinner spinner1,spinner2;
	
    /** Called when the activity is first created. */
   
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note);
        spinner1=(Spinner)findViewById(R.id.spinner1); 
		setCurrentDateOnView();
		addListenerOnButton();
	    addItemsOnSpinner1();
		addItemsOnSpinner2(); 
	
    }
    
//   
//  		public void onStart()
//  		{
//  			try
//  			{
//  			super.onStart();
//  			dbHelper=new DatabaseHelper(this);
//  			//txtEmps.setText(txtEmps.getText()+String.valueOf(dbHelper.getEmployeeCount()));
//  			
//  			Cursor c= dbHelper.getAllFormulaFertilizer();
//  			startManagingCursor(c);
//  			
//  			
//  			
//  			//SimpleCursorAdapter ca=new SimpleCursorAdapter(this,android.R.layout.simple_spinner_item, c, new String [] {DatabaseHelper.colDeptName}, new int []{android.R.id.text1});
//  			SimpleCursorAdapter ca=new SimpleCursorAdapter(this,R.layout.deptspinnerrow, c, new String [] {DatabaseHelper.colDeptName,"_id"}, new int []{R.id.txtDeptName});
//  			//ca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//  			spinner1.setAdapter(ca);
//  			spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
//
//  				@Override
//  				public void onItemSelected(AdapterView<?> parent, View selectedView,
//  						int position, long id) {
//  					// TODO Auto-generated method stub
//  					
//  				}
//
//  				@Override
//  				public void onNothingSelected(AdapterView<?> arg0) {
//  					// TODO Auto-generated method stub
//  					
//  				}
//  			});
//  			
//  			}
//  			catch(Exception ex)
//  			{
//  				CatchError(ex.toString());
//  			}
//  		}
  	    
  		 	//Start Spinner
	public void addItemsOnSpinner1() {
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		List<String> list = new ArrayList<String>();
		list.add("กรุณาเลือก");
		list.add("16-16-2");
		list.add("16-16-10");
		list.add("16-16-16");
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(dataAdapter);
	}
  			
    
    
	public void addItemsOnSpinner2() {

		spinner2 = (Spinner) findViewById(R.id.spinner2);
		List<String> list = new ArrayList<String>();
		list.add("กรุณาเลือก");
		list.add("เรือใบ");
		list.add("รุ่งอรุณ");
		list.add("ค้างคาว");
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner2.setAdapter(dataAdapter);
	}
  			
  			 
  		 	//End Spinner
 // display current date
 	public void setCurrentDateOnView() {

 		textDate1 = (TextView) findViewById(R.id.textDate1);
 		textDate2 = (TextView) findViewById(R.id.textDate2);
 		textDate3 = (TextView) findViewById(R.id.textDate3);
 

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
 	public void backToMainMenu(View view){
 		Intent mapN = new Intent(getBaseContext(), MenuActivity.class);
		startActivity(mapN);
 	}
 	public void addListenerOnButton() {
 		btnDate1 = (ImageButton) findViewById(R.id.btnDate1);
 		btnDate1.setOnClickListener(new OnClickListener() {

 			public void onClick(View v) {

 				showDialog(DATE_DIALOG_ID_1);
 			}
 		});
 		
 		btnDate2 = (ImageButton) findViewById(R.id.btnDate2);
 		btnDate2.setOnClickListener(new OnClickListener() {
 		
 			public void onClick(View v) {
 				showDialog(DATE_DIALOG_ID_2);
 			}
 		});
 		
 		btnDate3 = (ImageButton) findViewById(R.id.btnDate3);
 		btnDate3.setOnClickListener(new OnClickListener() {
 		
 			public void onClick(View v) {
 				showDialog(DATE_DIALOG_ID_3);
 			}
 		});

 	}


 	protected Dialog onCreateDialog(int id) {
 		switch (id) {
 		case DATE_DIALOG_ID_1:
 			return new DatePickerDialog(this, date1PickerListener, year_1, month_1,day_1);
 		case DATE_DIALOG_ID_2:
 			return new DatePickerDialog(this, date2PickerListener, year_2, month_2,day_3);
 		case DATE_DIALOG_ID_3:
 			return new DatePickerDialog(this, date3PickerListener, year_3, month_2,day_3);
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
 	
	void CatchError(String Exception)
	{
		Dialog diag=new Dialog(this);
		diag.setTitle("Error Message");
		TextView txt=new TextView(this);
		txt.setText(Exception);
		diag.setContentView(txt);
		diag.show();
	}

}