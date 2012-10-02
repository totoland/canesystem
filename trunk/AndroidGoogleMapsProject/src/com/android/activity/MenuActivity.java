package com.android.activity;

import com.android.gen.formgenerator.FormActivity;
import com.android.utils.AndroidConstant;
import com.nu.activity.MenuListActivity;
import com.nu.activity.Note1Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends FormActivity {
	
	private Button btnMenu1;
	private Button btnMenu2;
	private Button btnMenu3;
	private Button btnMenu4;
	private Button btnMenu5;
	private Button btnMenu6;
	private Button btnMenu7;
	private Button btnMenu8;
	private Button btnMenu9;
	private Button btnMenu10;
	private Button imageButtonTagging;
    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        addListenerOnButton();
    }
    
	public void addListenerOnButton() {
		btnMenu1 = (Button) findViewById(R.id.btnMenu1);
		btnMenu1.setOnClickListener(new OnClickListener() {
 			public void onClick(View v) {
 				Intent myIntent = new Intent(v.getContext(), GMapsActivity.class);
 				myIntent.putExtra(AndroidConstant.MODE, AndroidConstant.LOAD_PLANG_POLYGON);
 				startActivityForResult(myIntent, 0);
 			}
 		});
 		
		btnMenu2 = (Button) findViewById(R.id.btnMenu2);
		btnMenu2.setOnClickListener(new OnClickListener() {
 			public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), ReportMenuActivity.class);
                startActivityForResult(myIntent, 0);
 			}
 		});
		//รายงานแผนที่
		btnMenu3 = (Button) findViewById(R.id.btnMenu3);
		btnMenu3.setOnClickListener(new OnClickListener() {
 			public void onClick(View v) {
// 				Intent myIntent = new Intent(v.getContext(), GMapsActivity.class);
// 				myIntent.putExtra(AndroidConstant.MODE, AndroidConstant.LOAD_PLANG_POLYGON);
// 				startActivityForResult(myIntent, 0);
 			}
 		});
		btnMenu4 = (Button) findViewById(R.id.btnMenu4);
		btnMenu4.setOnClickListener(new OnClickListener() {
 			public void onClick(View v) {
 				Intent myIntent = new Intent(v.getContext(), MenuListActivity.class);
 				startActivityForResult(myIntent, 0);
 			}
 		});
		btnMenu6 = (Button)findViewById(R.id.btnMenu6);
		btnMenu6.setOnClickListener(new OnClickListener() {
 			public void onClick(View v) {
 				Intent myIntent = new Intent(v.getContext(), GMapsActivity.class);
                startActivityForResult(myIntent, 0);
 			}
 		});
		btnMenu9 = (Button)findViewById(R.id.btnMenu9);
		btnMenu9.setOnClickListener(new OnClickListener() {
 			public void onClick(View v) {
 				Intent myIntent = new Intent(v.getContext(), GMapsActivity.class);
 				myIntent.putExtra(AndroidConstant.MODE, AndroidConstant.TAGGING);
 				startActivityForResult(myIntent, 1);
 			}
 		});
		btnMenu10 =  (Button) findViewById(R.id.btnMenu10);
		btnMenu10.setOnClickListener(new OnClickListener() {

                public void onClick(View v) {
                      
                }
        });

 	}
 	
	void CatchError(String Exception)
	{
		Dialog diag=new Dialog(this);
		diag.setTitle("Error Message");
		TextView txt=new TextView(this);
		txt.setText(Exception);
		diag.setContentView(txt);
		diag.show();
	}
	@Override
	public void onBackPressed() {
	    new AlertDialog.Builder(this)
	        .setIcon(android.R.drawable.ic_dialog_alert)
	        .setTitle("แจ้งเตือน!!")
	        .setMessage("คุณต้องการออกจากระบบ?")
	        .setPositiveButton("ออกจากระบบ", new DialogInterface.OnClickListener()
	    {
	        public void onClick(DialogInterface dialog, int which) {
	        	finish();
	        	android.os.Process.killProcess(android.os.Process.myPid());
	        	System.exit(0);
    
	        }

	    })
	    .setNegativeButton("ปืดหน้าต่าง", null)
	    .show();
	}
}