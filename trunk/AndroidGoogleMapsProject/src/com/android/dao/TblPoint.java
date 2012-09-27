package com.android.dao;

import com.android.utils.SQLiteDBHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TblPoint {
	private SQLiteDBHelper dbHelper;
	private SQLiteDatabase database;
	
	public static final String STUDENT_TABLE = "tbl_point";
	public String SQL_POINT_JOIN_STATE = "select * from tbl_state inner join tbl_point "+
								  "on tbl_state.StateID = tbl_point.StateID "+
								  "where tbl_state.StateID <= ?";
	public TblPoint(Context context){
		dbHelper = new SQLiteDBHelper(context);
		database = dbHelper.getWritableDatabase();
	}
	
	public Cursor findStateWhereState(String stateID) {
		String arr[] = {};
		if(stateID!=null){
			arr = new String[]{stateID};
		}
		Cursor mCursor = database.rawQuery(SQL_POINT_JOIN_STATE, arr);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;

	}
}
