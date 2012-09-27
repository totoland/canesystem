package com.android.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "GISCane";
	private static final int DATABASE_VERSION = 1;

		private static final String SEQ_CREATE_SQL = "CREATE TABLE sqlite_sequence(name,seq) INSERT INTO sqlite_sequence VALUES('tbl_state',4481)";
		private static final String SEQ_CREATE_STATE = " "+
											 " CREATE TABLE tbl_point ( "+
											 " pointID	integer NOT NULL, "+
											 " lat		nvarchar(50) COLLATE NOCASE, "+
											 " lng nvarchar(50) COLLATE NOCASE, "+
											 " StateID		integer )";
	private static final String CREATE_TABLE = "CREATE TABLE tbl_state ( "+
												"StateID		integer PRIMARY KEY AUTOINCREMENT NOT NULL, "+
												"quotacode		nvarchar(255) COLLATE NOCASE,"+
												"name		nvarchar(255) COLLATE NOCASE, "+
												"plotid		nvarchar(255) COLLATE NOCASE, "+
												"plotcode		nvarchar(255) COLLATE NOCASE, "+
												"canename		nvarchar(255) COLLATE NOCASE, "+
												"plotdatecut		nvarchar(255) COLLATE NOCASE, "+
												"canetypename		nvarchar(255) COLLATE NOCASE, "+
												"locationmainname	nvarchar(255) COLLATE NOCASE, "+
												"locationname		nvarchar(255) COLLATE NOCASE, "+
												"codestaff		nvarchar(255) COLLATE NOCASE, "+
												"satffname		nvarchar(255) COLLATE NOCASE, "+
												"color		nvarchar(255) COLLATE NOCASE, "+
												"strokecolor		nvarchar(255) COLLATE NOCASE );";
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//db.execSQL(SEQ_CREATE_SQL);
		//db.execSQL(SEQ_CREATE_STATE);
		//db.execSQL(CREATE_TABLE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(DatabaseHelper.class.getName(),
				"Upgread database version from version" + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS tbl_point");
		db.execSQL("DROP TABLE IF EXISTS tbl_state");
		onCreate(db);

	}

}
