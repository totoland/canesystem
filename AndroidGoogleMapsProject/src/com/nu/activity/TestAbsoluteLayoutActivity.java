package com.nu.activity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.android.activity.R;
import com.nu.dao.FieldDAO;
import com.nu.dto.Field;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.sax.TextElementListener;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AbsoluteLayout;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

public class TestAbsoluteLayoutActivity extends Activity {
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
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		// display.getSize(size);
		int width = display.getWidth();// size.x;
		int height = display.getHeight();

		// http://stackoverflow.com/questions/7850024/adding-scrollview-to-layout-using-java-code
//		AbsoluteLayout abs = (AbsoluteLayout) findViewById(R.id.widget0);
//		AbsoluteLayout.LayoutParams pram = new AbsoluteLayout.LayoutParams(
//				width, height - 50, 0, 0);
		LinearLayout abs = (LinearLayout) findViewById(R.id.widget0);
		LinearLayout.LayoutParams pram = new LinearLayout.LayoutParams(
				width, ViewGroup.LayoutParams.WRAP_CONTENT);
		// pram = new AbsoluteLayout.LayoutParams(
		// ViewGroup.LayoutParams.FILL_PARENT ,
		// ViewGroup.LayoutParams.WRAP_CONTENT);
		ScrollView scroll_main = new ScrollView(this);
		scroll_main.setVerticalScrollBarEnabled(true);
		scroll_main.setHorizontalScrollBarEnabled(true);
		abs.addView(scroll_main, pram);

		AbsoluteLayout abs2 = new AbsoluteLayout(this);
		AbsoluteLayout.LayoutParams pram2;
		pram2 = new AbsoluteLayout.LayoutParams(width,ViewGroup.LayoutParams.WRAP_CONTENT, 0, 0);
		scroll_main.addView(abs2, pram2);

		// LinearLayout inner = new LinearLayout(this);
		// LinearLayout.LayoutParams innserParam = new
		// LinearLayout.LayoutParams(
		// ViewGroup.LayoutParams.FILL_PARENT,
		// ViewGroup.LayoutParams.WRAP_CONTENT);

		// LinearLayout inner = new LinearLayout(this);
		// LinearLayout.LayoutParams innserParam = new
		// LinearLayout.LayoutParams(
		// ViewGroup.LayoutParams.FILL_PARENT,
		// ViewGroup.LayoutParams.WRAP_CONTENT);
		//
		//
		// innserParam.topMargin = 2;
		// inner.setOrientation(LinearLayout.VERTICAL);
		//
		// for (int i = 0; i < 10; i++) {
		// CheckBox cb = new CheckBox(this);
		// cb.setText("I'm dynamic!" + i);
		// cb.setId(i);
		//
		// // cb.setTextColor(Color.BLACK);
		// // cb.setTextColor(000000);
		// inner.addView(cb);
		// }
		//
		// ScrollView scroll_checkbox = new ScrollView(this);
		// scroll_checkbox.setVerticalScrollBarEnabled(true);
		// scroll_checkbox.setHorizontalScrollBarEnabled(true);
		// scroll_checkbox.addView(inner, innserParam);

		// ll.setOrientation(LinearLayout.VERTICAL);
		AbsoluteLayout.LayoutParams param_abs_lable;
		AbsoluteLayout.LayoutParams param_abs_field;
		AbsoluteLayout.LayoutParams param_abs_calendar;
		AbsoluteLayout.LayoutParams param_abs_spinner;
		ScrollView scroll_checkbox;
		AbsoluteLayout.LayoutParams pramCheckBox; 
		LinearLayout linearCheckBox;
		LinearLayout.LayoutParams paramInnerCheckBox;
		LinearLayout.LayoutParams paramInnerCheckBoxInner;
		TextView tv;
		Spinner sp;
		ImageButton imBut;
		CheckBox cb;

		FieldDAO fieldDAO = new FieldDAO();
		ArrayList fieldList = fieldDAO
				.getFieldByAcivityName(TestAbsoluteLayoutActivity.class.getSimpleName());
		Field field = null;
		int x_lebel = 0;
		int x_field = 0;
		int y = 0;
		int newColumn = 0;
		int oldColumn = 0;
		int count = 0;
	
		for (int i = 0; i < fieldList.size(); i++) {
			field = (Field) fieldList.get(i);

			newColumn = field.getColumn();
			if (newColumn != oldColumn) {
				y = 0;
			}
			oldColumn = newColumn;
			count++;
			y = y + 50;
			if (field.getType().equals("EditText")) {
				// Add TextView

			    tv = new TextView(this);
			    tv.setTextColor(Color.BLACK);
				tv.setText(field.getLabel());
				tv.setId(100 + i);
				x_lebel = this.getX_leble(field.getColumn());
				param_abs_lable = new AbsoluteLayout.LayoutParams(
						Config.LABLE_WIDTH, Config.LABLE_HIGHT, x_lebel, y);
				abs2.addView(tv, param_abs_lable);
				// Add EditText
				EditText et = new EditText(this);
				et.setId(200 + i);
				x_field = this.getX_field(field.getColumn());
				param_abs_field = new AbsoluteLayout.LayoutParams(
						Config.FIELD_WIDE, Config.FIELD_HIGTH, x_field, y);
				abs2.addView(et, param_abs_field);
			} else if (field.getType().equalsIgnoreCase("Date")) {
				// Add TextView
			    tv = new TextView(this);
				tv.setText(field.getLabel());
				tv.setTextColor(Color.BLACK);
				tv.setId(100 + i);
				x_lebel = this.getX_leble(field.getColumn());
				param_abs_lable = new AbsoluteLayout.LayoutParams(
						Config.LABLE_WIDTH, Config.LABLE_HIGHT, x_lebel, y);
				abs2.addView(tv, param_abs_lable);
				// Add EditText
				EditText et = new EditText(this);
				et.setId(200 + i);
				et.setTextSize(15);
				x_field = this.getX_field(field.getColumn());
				
				param_abs_field = new AbsoluteLayout.LayoutParams(
						Config.FIELD_DATE_WIDE, Config.FIELD_DATE_HIGTH,
						x_field, y);
				abs2.addView(et, param_abs_field);

			    imBut = new ImageButton(this);
			    imBut.setBackgroundResource(R.drawable.calendar16);
				param_abs_calendar = new AbsoluteLayout.LayoutParams(
						Config.FIELD_DATE_HIGTH, Config.FIELD_DATE_HIGTH,
						x_field + 180, y);
				
				imBut.setId(300 + i);
				abs2.addView(imBut, param_abs_calendar);

			} else if (field.getType().equalsIgnoreCase("Spinner")) {
			    tv = new TextView(this);
			    tv.setTextColor(Color.BLACK);
				tv.setText(field.getLabel());
				tv.setId(100 + field.getId());
				x_lebel = this.getX_leble(field.getColumn());
				param_abs_lable = new AbsoluteLayout.LayoutParams(
						Config.LABLE_WIDTH, Config.LABLE_HIGHT, x_lebel, y);
				abs2.addView(tv, param_abs_lable);
				// Add EditText
			    sp = new Spinner(this);
				sp.setId(200 + field.getId());

				x_field = this.getX_field(field.getColumn());
				param_abs_spinner = new AbsoluteLayout.LayoutParams(
						Config.FIELD_WIDE, Config.FIELD_HIGTH, x_field, y);
				abs2.addView(sp, param_abs_spinner);

			} else if (field.getType().equalsIgnoreCase("CheckBox")) {
				// TextView
			    tv = new TextView(this);
			    tv.setTextColor(Color.BLACK);
				tv.setText(field.getLabel());
				tv.setId(100 + field.getId());
				x_lebel = this.getX_leble(field.getColumn());
				param_abs_lable = new AbsoluteLayout.LayoutParams(
						Config.LABLE_WIDTH, Config.LABLE_HIGHT, x_lebel, y);
				abs2.addView(tv, param_abs_lable);
				// Add Group CheckBOx
				x_field = this.getX_field(field.getColumn());
				
				
			    pramCheckBox = new AbsoluteLayout.LayoutParams(
						400, 300, x_field, y);
				y = y + 270;
		
			    scroll_checkbox = new ScrollView(this);
				scroll_checkbox.setVerticalScrollBarEnabled(true);
				scroll_checkbox.setHorizontalScrollBarEnabled(true);
				scroll_checkbox.setBackgroundColor(Color.argb(220, 180, 220, 220));
			
				//scroll_checkbox.setScrollBar
				abs2.addView(scroll_checkbox, pramCheckBox);

			    linearCheckBox = new LinearLayout(this);
				paramInnerCheckBox = new LinearLayout.LayoutParams(
				ViewGroup.LayoutParams.FILL_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
					//	ViewGroup.LayoutParams.WRAP_CONTENT);
				//LinearLayout.LayoutParams paramInnerCheckBox = new LinearLayout.LayoutParams(400,800);
				//paramInnerCheckBox.
				linearCheckBox.setOrientation(LinearLayout.VERTICAL);
				//linearCheckBox.t

				// ScrollView scroll_checkbox = new ScrollView(this);
//				scroll_checkbox.setVerticalScrollBarEnabled(true);
//				scroll_checkbox.setHorizontalScrollBarEnabled(true);
				scroll_checkbox.addView(linearCheckBox, paramInnerCheckBox);
				
				
			    paramInnerCheckBoxInner = new LinearLayout.LayoutParams(
						ViewGroup.LayoutParams.WRAP_CONTENT,58);
				//paramInnerCheckBoxInner.topMargin = 2;
				if(field.getDefaultData() != null){				
					String[] dataArr = field.getDefaultData().split("[|]");
					for (int j = 0; j < dataArr.length; j++) {
					    cb = new CheckBox(this);
						cb.setText(dataArr[j]);
						cb.setId(j);
						cb.setTextSize(14);
						cb.setTextColor(Color.BLACK);
						//cb
						// cb.setTextColor(Color.BLACK);
						// cb.setTextColor(000000);
						linearCheckBox.addView(cb,paramInnerCheckBoxInner);
					}

				}

				
				
				
	
			}

			// TextView tv = new TextView(this);

			// cb.setTextColor(Color.BLACK);
			// cb.setTextColor(000000);
			// cb.scrollBy(100, i+100);

		}
		// try {Thread.sleep(1000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// for (int i = 0; i < 10; i++) {
		// EditText et = new EditText(this);
		// // et.setText("I'm dynamic!" + i);
		// et.setId(i);
		// // cb.setTextColor(Color.BLACK);
		// // cb.setTextColor(000000);
		// // cb.scrollBy(100, i+100);
		// param_abs2 = new AbsoluteLayout.LayoutParams(150, 50, 200, i * 50);
		//
		// abs2.addView(et, param_abs2);
		// }

		// for (int i = 0; i < 10; i++) {
		// TextView tv = new TextView(this);
		// tv.setText("I'm dynamic!" + i);
		// tv.setId(i);
		// // cb.setTextColor(Color.BLACK);
		// // cb.setTextColor(000000);
		// // cb.scrollBy(100, i+100);
		// pram = new AbsoluteLayout.LayoutParams(150, 50, 400, i * 50);
		//
		// abs.addView(tv, pram);
		// }

//		setCurrentDateOnView();
//		addListenerOnButton();
//		addItemsOnSpinner1();
//		addItemsOnSpinner2();
	}

	private int getX_leble(int column) {
		if (column == 1) {
			return Config.X_LABEL_1;
		} else if (column == 2) {
			return Config.X_LABEL_2;
		} else if (column == 3) {
			return Config.X_LABEL_3;
		}

		return 0;
	}

	private int getX_field(int column) {
		if (column == 1) {
			return Config.X_FIELD_1;
		} else if (column == 2) {
			return Config.X_FIELD_2;
		} else if (column == 3) {
			return Config.X_FIELD_3;
		}

		return 0;
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
		list.add("�?รุณาเลือ�?");
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
		list.add("�?รุณาเลือ�?");
		list.add("ตราเรือใบ");
		list.add("�?ระต่าย");
		list.add("ตราหัววัว");
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner2.setAdapter(dataAdapter);
	}
	// End Sprinner
}