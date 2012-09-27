package com.nu.activity;

import java.util.ArrayList;

import com.android.activity.R;
import com.nu.dao.FieldDAO;
import com.nu.dto.Field;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.sax.TextElementListener;
import android.view.Display;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class LinearLayoutActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		//display.getSize(size);
		int width = display.getWidth();//size.x;
		int height = display.getHeight();
		System.out.println("width ="+width);
		System.out.println("height ="+height);
		// http://stackoverflow.com/questions/7850024/adding-scrollview-to-layout-using-java-code
		AbsoluteLayout abs = (AbsoluteLayout) findViewById(R.id.widget0);
		AbsoluteLayout.LayoutParams pram = new AbsoluteLayout.LayoutParams(width, height-50, 0, 0);
//		pram = new AbsoluteLayout.LayoutParams(	ViewGroup.LayoutParams.FILL_PARENT ,
//				ViewGroup.LayoutParams.WRAP_CONTENT);
		ScrollView scroll_main = new ScrollView(this);
		scroll_main.setVerticalScrollBarEnabled(true);
		scroll_main.setHorizontalScrollBarEnabled(true);
		abs.addView(scroll_main, pram);
		
		
		AbsoluteLayout abs2 = new AbsoluteLayout(this);
		AbsoluteLayout.LayoutParams pram2;
		pram2 = new AbsoluteLayout.LayoutParams(width, height-100, 0, 0);
		scroll_main.addView(abs2,pram2);
		
//		LinearLayout inner = new LinearLayout(this);
//		LinearLayout.LayoutParams innserParam = new LinearLayout.LayoutParams(
//				ViewGroup.LayoutParams.FILL_PARENT,
//				ViewGroup.LayoutParams.WRAP_CONTENT);
		
		
		
		
//		LinearLayout inner = new LinearLayout(this);
//		LinearLayout.LayoutParams innserParam = new LinearLayout.LayoutParams(
//				ViewGroup.LayoutParams.FILL_PARENT,
//				ViewGroup.LayoutParams.WRAP_CONTENT);
//		
//		
//		innserParam.topMargin = 2;
//		inner.setOrientation(LinearLayout.VERTICAL);
//
//		for (int i = 0; i < 10; i++) {
//			CheckBox cb = new CheckBox(this);
//			cb.setText("I'm dynamic!" + i);
//			cb.setId(i);
//
//			// cb.setTextColor(Color.BLACK);
//			// cb.setTextColor(000000);
//			inner.addView(cb);
//		}
//		
//		ScrollView scroll_checkbox = new ScrollView(this);
//		scroll_checkbox.setVerticalScrollBarEnabled(true);
//		scroll_checkbox.setHorizontalScrollBarEnabled(true);
//		scroll_checkbox.addView(inner, innserParam);
		
		
	
		// ll.setOrientation(LinearLayout.VERTICAL);
		AbsoluteLayout.LayoutParams param_abs_lable;
		AbsoluteLayout.LayoutParams param_abs_field;
		
		FieldDAO fieldDAO = new FieldDAO();
		ArrayList fieldList = fieldDAO.getFieldByAcivityName(LinearLayoutActivity.class.getSimpleName());
		Field field = null;
		int x_lebel = 0;
		int x_field = 0;
		int y = 0;
		int newColumn = 0;
		int oldColumn = 0;
		int count = 0;
		for (int i = 0; i < fieldList.size() ; i++) {
			field = (Field)fieldList.get(i);
			
			newColumn = field.getColumn();
			if(newColumn != oldColumn){
				count = 0;				
			}
			oldColumn = newColumn;
			count ++;
			y = count*50;
			if(field.getType().equals("EditText")){
				//Add TextView
				
				TextView tv = new TextView(this);
				tv.setText(field.getLabel());
				tv.setId(i);
				x_lebel = this.getX_leble(field.getColumn());
				param_abs_lable = new AbsoluteLayout.LayoutParams(Config.LABLE_WIDTH, Config.LABLE_HIGHT, x_lebel,y );
				abs2.addView(tv, param_abs_lable);
				//Add EditText
				EditText et = new EditText(this);
				et.setId(i);
				x_field = this.getX_field(field.getColumn());
				param_abs_field = new AbsoluteLayout.LayoutParams(Config.FIELD_WIDE, Config.FIELD_HIGTH, x_field,y );
				abs2.addView(et, param_abs_field);	
			}else if(field.getType().equals("Date")){
				//Add TextView
				TextView tv = new TextView(this);
				tv.setText(field.getLabel());
				tv.setId(i);
				x_lebel = this.getX_leble(field.getColumn());
				param_abs_lable = new AbsoluteLayout.LayoutParams(Config.LABLE_WIDTH, Config.LABLE_HIGHT, x_lebel,y );
				abs2.addView(tv, param_abs_lable);
				//Add EditText
				EditText et = new EditText(this);
				et.setId(i);
				x_field = this.getX_field(field.getColumn());
				param_abs_field = new AbsoluteLayout.LayoutParams(Config.FIELD_WIDE, Config.FIELD_HIGTH, x_field,y );
				abs2.addView(et, param_abs_field);
				
				
				
			}	
			
			//TextView tv = new TextView(this);

			// cb.setTextColor(Color.BLACK);
			// cb.setTextColor(000000);
			// cb.scrollBy(100, i+100);

		}
//
//		for (int i = 0; i < 10; i++) {
//			EditText et = new EditText(this);
//			// et.setText("I'm dynamic!" + i);
//			et.setId(i);
//			// cb.setTextColor(Color.BLACK);
//			// cb.setTextColor(000000);
//			// cb.scrollBy(100, i+100);
//			param_abs2 = new AbsoluteLayout.LayoutParams(150, 50, 200, i * 50);
//
//			abs2.addView(et, param_abs2);
//		}

		
		
//		for (int i = 0; i < 10; i++) {
//			TextView tv = new TextView(this);
//			tv.setText("I'm dynamic!" + i);
//			tv.setId(i);
//			// cb.setTextColor(Color.BLACK);
//			// cb.setTextColor(000000);
//			// cb.scrollBy(100, i+100);
//			pram = new AbsoluteLayout.LayoutParams(150, 50, 400, i * 50);
//
//			abs.addView(tv, pram);
//		}
	}
	private int getX_leble(int column){
		if(column ==1){
			return Config.X_LABEL_1;
		}else if(column ==2){
			return Config.X_LABEL_2;
		}else if(column ==3){
			return Config.X_LABEL_3;
		}
		
		return 0 ; 
	}
	
	private int getX_field(int column){
		if(column ==1){
			return Config.X_FIELD_1;
		}else if(column ==2){
			return Config.X_FIELD_2;
		}else if(column ==3){
			return Config.X_FIELD_3;
		}
		
		return 0 ;  
	}
	
}