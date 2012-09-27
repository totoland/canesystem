package com.nu.activity;

import java.util.ArrayList;

import com.android.activity.R;
import com.nu.dao.FieldDAO;
import com.nu.dto.Field;

import android.R.color;
import android.app.Activity;
import android.graphics.Color;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

public class DrawForm {

	public LinearLayout doDraw(Activity activity, LinearLayout mainLayout,
			String formName, int width, int height) {
		LinearLayout.LayoutParams pram = new LinearLayout.LayoutParams(width,
				ViewGroup.LayoutParams.WRAP_CONTENT);
		// pram = new AbsoluteLayout.LayoutParams(
		// ViewGroup.LayoutParams.FILL_PARENT ,
		// ViewGroup.LayoutParams.WRAP_CONTENT);
		ScrollView scroll_main = new ScrollView(activity);
		scroll_main.setVerticalScrollBarEnabled(true);
		scroll_main.setHorizontalScrollBarEnabled(true);
		mainLayout.addView(scroll_main, pram);

		AbsoluteLayout abs2 = new AbsoluteLayout(activity);
		AbsoluteLayout.LayoutParams pram2;
		pram2 = new AbsoluteLayout.LayoutParams(width,
				ViewGroup.LayoutParams.WRAP_CONTENT, 0, 0);
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
		TextView redStar;
		Spinner sp;
		ImageButton imBut;
		CheckBox cb;
		EditText et;
		Button bt;
		FieldDAO fieldDAO = new FieldDAO();
		ArrayList fieldList = fieldDAO.getFieldByAcivityName(formName);
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

				tv = new TextView(activity);
				tv.setGravity(Gravity.RIGHT);
				tv.setTextColor(Color.BLACK);
				tv.setText(field.getLabel());
				
	
				
				x_lebel = this.getX_leble(field.getColumn());
				param_abs_lable = new AbsoluteLayout.LayoutParams(
						Config.LABLE_WIDTH, Config.LABLE_HIGHT, x_lebel, y);
				abs2.addView(tv, param_abs_lable);
				//Add RedStar
			  	if(field.isRequest()==true){
				      redStar = new TextView(activity);	
				      redStar.setGravity(Gravity.RIGHT);
				      redStar.setTextColor(Color.RED);	
				      redStar.setText("*");	
					 // x_lebel = this.getX_leble(field.getColumn());
					  param_abs_lable = new AbsoluteLayout.LayoutParams(
								Config.LABLE_WIDTH, Config.LABLE_HIGHT, x_lebel+8, y-9);
						abs2.addView(redStar, param_abs_lable);
				}
				
				// Add EditText
				et = new EditText(activity);
				et.setId(200 + i);
				x_field = this.getX_field(field.getColumn());
				param_abs_field = new AbsoluteLayout.LayoutParams(
						Config.FIELD_WIDE, Config.FIELD_HIGTH, x_field, y);
				abs2.addView(et, param_abs_field);
				
			} else if (field.getType().equalsIgnoreCase("Date")) {
				// Add TextView
				tv = new TextView(activity);
				tv.setGravity(Gravity.RIGHT);
				tv.setText(field.getLabel());
				tv.setTextColor(Color.BLACK);
				tv.setId(100 + i);
				x_lebel = this.getX_leble(field.getColumn());
				param_abs_lable = new AbsoluteLayout.LayoutParams(
						Config.LABLE_WIDTH, Config.LABLE_HIGHT, x_lebel, y);
				abs2.addView(tv, param_abs_lable);
				//Add RedStar
			  	if(field.isRequest()==true){
				      redStar = new TextView(activity);	
				      redStar.setGravity(Gravity.RIGHT);
				      redStar.setTextColor(Color.RED);	
				      redStar.setText("*");	
					 // x_lebel = this.getX_leble(field.getColumn());
					  param_abs_lable = new AbsoluteLayout.LayoutParams(
								Config.LABLE_WIDTH, Config.LABLE_HIGHT, x_lebel+8, y-9);
						abs2.addView(redStar, param_abs_lable);
				}
				// Add EditText
				et = new EditText(activity);
				et.setId(200 + i);
				//et.setTextSize(15);
				x_field = this.getX_field(field.getColumn());

				param_abs_field = new AbsoluteLayout.LayoutParams(
						Config.FIELD_DATE_WIDE, Config.FIELD_DATE_HIGTH,
						x_field, y);
				abs2.addView(et, param_abs_field);

				imBut = new ImageButton(activity);
				imBut.setBackgroundResource(R.drawable.calendar16);
				param_abs_calendar = new AbsoluteLayout.LayoutParams(
						Config.FIELD_DATE_HIGTH, Config.FIELD_DATE_HIGTH,
						x_field + Config.FIELD_DATE_WIDE, y);

				imBut.setId(300 + i);
				abs2.addView(imBut, param_abs_calendar);

			} else if (field.getType().equalsIgnoreCase("Spinner")) {
				tv = new TextView(activity);
				tv.setGravity(Gravity.RIGHT);
				tv.setTextColor(Color.BLACK);
				tv.setText(field.getLabel());
				tv.setId(100 + field.getId());
				x_lebel = this.getX_leble(field.getColumn());
				param_abs_lable = new AbsoluteLayout.LayoutParams(
						Config.LABLE_WIDTH, Config.LABLE_HIGHT, x_lebel, y);
				abs2.addView(tv, param_abs_lable);
				//Add RedStar
			  	if(field.isRequest()==true){
				      redStar = new TextView(activity);	
				      redStar.setGravity(Gravity.RIGHT);
				      redStar.setTextColor(Color.RED);	
				      redStar.setText("*");	
					 // x_lebel = this.getX_leble(field.getColumn());
					  param_abs_lable = new AbsoluteLayout.LayoutParams(
								Config.LABLE_WIDTH, Config.LABLE_HIGHT, x_lebel+8, y-9);
						abs2.addView(redStar, param_abs_lable);
				}
				// Add EditText
				sp = new Spinner(activity);
				sp.setId(200 + field.getId());

				x_field = this.getX_field(field.getColumn());
				param_abs_spinner = new AbsoluteLayout.LayoutParams(
						Config.FIELD_WIDE, Config.FIELD_HIGTH, x_field, y);
				abs2.addView(sp, param_abs_spinner);

			} else if (field.getType().equalsIgnoreCase("CheckBox")) {
				// TextView
				tv = new TextView(activity);
				tv.setGravity(Gravity.RIGHT);
				tv.setTextColor(Color.BLACK);
				tv.setText(field.getLabel());
				tv.setId(100 + field.getId());
				x_lebel = this.getX_leble(field.getColumn());
				param_abs_lable = new AbsoluteLayout.LayoutParams(
						Config.LABLE_WIDTH, Config.LABLE_HIGHT, x_lebel, y);
				abs2.addView(tv, param_abs_lable);
				//Add RedStar
			  	if(field.isRequest()==true){
				      redStar = new TextView(activity);	
				      redStar.setGravity(Gravity.RIGHT);
				      redStar.setTextColor(Color.RED);	
				      redStar.setText("*");	
					 // x_lebel = this.getX_leble(field.getColumn());
					  param_abs_lable = new AbsoluteLayout.LayoutParams(
								Config.LABLE_WIDTH, Config.LABLE_HIGHT, x_lebel+8, y-9);
						abs2.addView(redStar, param_abs_lable);
				}
				// Add Group CheckBOx
				x_field = this.getX_field(field.getColumn());

				pramCheckBox = new AbsoluteLayout.LayoutParams(400, 300,
						x_field, y);
				y = y + 270;

				scroll_checkbox = new ScrollView(activity);
				// scroll_checkbox.setVerticalScrollBarEnabled(true);
				// scroll_checkbox.setHorizontalScrollBarEnabled(true);
				//scroll_checkbox.setBackgroundColor(Color.argb(220, 180, 220,220));

				// scroll_checkbox.setScrollBar
				abs2.addView(scroll_checkbox, pramCheckBox);

				linearCheckBox = new LinearLayout(activity);
				linearCheckBox.setOrientation(LinearLayout.VERTICAL);
				paramInnerCheckBox = new LinearLayout.LayoutParams(
						ViewGroup.LayoutParams.FILL_PARENT,
						ViewGroup.LayoutParams.WRAP_CONTENT);

				// LinearLayout.LayoutParams paramInnerCheckBox = new
				// LinearLayout.LayoutParams(400,800);
				// paramInnerCheckBox.
				linearCheckBox.setOrientation(LinearLayout.VERTICAL);
				// linearCheckBox.t

				// ScrollView scroll_checkbox = new ScrollView(this);
				// scroll_checkbox.setVerticalScrollBarEnabled(true);
				// scroll_checkbox.setHorizontalScrollBarEnabled(true);
				scroll_checkbox.addView(linearCheckBox);

				paramInnerCheckBoxInner = new LinearLayout.LayoutParams(
						ViewGroup.LayoutParams.WRAP_CONTENT, 58);
				// paramInnerCheckBoxInner.topMargin = 2;
				if (field.getDefaultData() != null) {
					String[] dataArr = field.getDefaultData().split("[|]");
					for (int j = 0; j < dataArr.length; j++) {
						cb = new CheckBox(activity);
						cb.setText(dataArr[j]);
						cb.setId(j);
						//cb.setTextSize(14);
						cb.setTextColor(Color.BLACK);
						// cb
						// cb.setTextColor(Color.BLACK);
						// cb.setTextColor(000000);
						linearCheckBox.addView(cb, paramInnerCheckBoxInner);
					}

				}

			} else if (field.getType().equalsIgnoreCase("TextArea")) {
				// android:layout_width="fill_parent"
				// android:layout_height="wrap_content"
				// android:gravity="center"
				// android:singleLine="false"
				// android:lines="5"
				// android:layout_marginLeft="10dip"
				// android:layout_marginRight="10dip"

				tv = new TextView(activity);
				tv.setGravity(Gravity.RIGHT);
				tv.setTextColor(Color.BLACK);
				tv.setText(field.getLabel());
				tv.setId(100 + i);
				x_lebel = this.getX_leble(field.getColumn());
				param_abs_lable = new AbsoluteLayout.LayoutParams(
						Config.LABLE_WIDTH, Config.LABLE_HIGHT, x_lebel, y);
				abs2.addView(tv, param_abs_lable);
				//Add RedStar
			  	if(field.isRequest()==true){
				      redStar = new TextView(activity);	
				      redStar.setGravity(Gravity.RIGHT);
				      redStar.setTextColor(Color.RED);	
				      redStar.setText("*");	
					 // x_lebel = this.getX_leble(field.getColumn());
					  param_abs_lable = new AbsoluteLayout.LayoutParams(
								Config.LABLE_WIDTH, Config.LABLE_HIGHT, x_lebel+8, y-9);
						abs2.addView(redStar, param_abs_lable);
				}
				// Add EditText
				et = new EditText(activity);
				// et.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
				// et.setHorizontallyScrolling(false);
				et.setSingleLine(false);
				et.setLines(5);
				et.setGravity(Gravity.CENTER);
				et.setPadding(1, 1, 1, 1);
				et.setId(200 + i);
				x_field = this.getX_field(field.getColumn());
				param_abs_field = new AbsoluteLayout.LayoutParams(
						Config.FIELD_WIDE, 250, x_field, y);
				abs2.addView(et, param_abs_field);
				y = y + 230;
			} else if (field.getType().equalsIgnoreCase("Button")) {

				if (field.getDefaultData() != null) {
					String[] dataArr = field.getDefaultData().split("[|]");
					
					int x_button = 10;
					for (int j = 0; j < dataArr.length; j++) {
						    //imBut = new ImageButton(activity);
						    //bt = new Button(activity);
//						if (dataArr[j].equalsIgnoreCase("save")) {
//
//							imBut.setBackgroundResource(R.drawable.save);
//						} else if (dataArr[j].equalsIgnoreCase("back")) {
//							imBut.setBackgroundResource(R.drawable.back);
//						} else if (dataArr[j].equalsIgnoreCase("camera")) {
//							imBut.setBackgroundResource(R.drawable.camera);
//
//						}
//						    if (dataArr[j].equalsIgnoreCase("save")) {
//						    	bt.setText("บันทึก");
//						    	bt.setTextColor(color.black);
//							} else if (dataArr[j].equalsIgnoreCase("back")) {
//								bt.setText("กลับหน้าหลัก");
//								bt.setTextColor(color.black);
//							} else if (dataArr[j].equalsIgnoreCase("camera")) {
//								bt.setText("ถ่ายภาพ");
//								bt.setTextColor(color.black);
//							}
						    
						param_abs_calendar = new AbsoluteLayout.LayoutParams(
								Config.BUTTON_WIDE, Config.BUTTON_HIGTH,
								x_button, y);
						x_button = x_button +Config.BUTTON_WIDE+Config.BUTTON_SPACE;
						//imBut.setId(300 + i);
						//abs2.addView(imBut, param_abs_calendar);
					}

				}

			}
			// <EditText android:layout_height="wrap_content"
			// android:id="@+id/editText1" android:inputType="textMultiLine"
			// android:layout_x="348dp" android:layout_y="98dp"
			// android:layout_width="81dp"></EditText>
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

		// setCurrentDateOnView();
		// addListenerOnButton();
		// addItemsOnSpinner1();
		// addItemsOnSpinner2();
		return mainLayout;
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
}
