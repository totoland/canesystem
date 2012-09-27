package com.android.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class SQLiteDBHelper extends SQLiteOpenHelper {

	private static String DB_PATH = "/data/data/com.android.activity/databases/";

	private static String DB_NAME = "GISCane1.db";
	
	private static String ASSETS_DB_FOLDER = "db";
	
	private SQLiteDatabase myDataBase;

	private final Context myContext;

	
	public SQLiteDBHelper(Context context) {
		super(context, DB_NAME, null, 1);
		this.myContext = context;
	}

	
	/**
	 * Creates a empty database on the system and overwrite it with your own
	 * database.
	 **/
	public void createDatabase() throws IOException {
	    boolean dbExist = checkDatabase();
		if (!dbExist) {
			super.getReadableDatabase();
			try {
				copyDatabase();
			}
			catch (IOException e) {
				throw new Error("Error copying database");
			}
		}
	}

	/**
	 * Check if the database already exist to avoid re-copying the file each
	 * time you open the application.
	 * 
	 * @return true if it exists, false if it doesn't
	 */
	private boolean checkDatabase() {
		SQLiteDatabase checkDB = null;

		try {
			String myPath = DB_PATH + DB_NAME;
			checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY|SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		}
		catch (SQLiteException e) {
			// database does't exist yet.
		}

		if (checkDB != null) {
			checkDB.close();
		}
		return checkDB != null ? true : false;
	}

	private void copyDatabase() throws IOException {
		String[] dbFiles = myContext.getAssets().list(ASSETS_DB_FOLDER);
		String outFileName = DB_PATH + DB_NAME;
		Log.d("234",""+outFileName);
		File f = new File(DB_PATH);
		if(!f.exists()){
			f.mkdirs();
		}
		OutputStream myOutput = new FileOutputStream(outFileName);
		for(int i =0; i < dbFiles.length; i++) {
			InputStream myInput = myContext.getAssets().open(ASSETS_DB_FOLDER+"/"+dbFiles[i]);
			Log.d("ASSETS_DB_FOLDER",""+myInput);
			byte[] buffer = new byte[1024*5];
			int length;
			while ((length = myInput.read(buffer)) > 0) {
				myOutput.write(buffer, 0, length);
			}
			myInput.close();
		}
		myOutput.flush();
		myOutput.close();
	}

	public void openDatabase() throws SQLException {
		// Open the database
		String myPath = DB_PATH + DB_NAME;
		myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY|SQLiteDatabase.NO_LOCALIZED_COLLATORS);
	}

	@Override
	public synchronized void close() {
		if (myDataBase != null) myDataBase.close();
		super.close();
	}

	@Override
	public void onCreate(SQLiteDatabase db) { }

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }
	
	@Override
	public synchronized SQLiteDatabase getReadableDatabase (){
		try {
			createDatabase();
			openDatabase();
		}
		catch (SQLException e) {
			myDataBase = null;
			e.printStackTrace();
		}
		catch (IOException e) {
			myDataBase = null;
			e.printStackTrace();
		}
		return myDataBase;
	}
	@Override
	public synchronized SQLiteDatabase getWritableDatabase() {
	    SQLiteDatabase db = null;
	    if (!checkDatabase()) {
	        try {
	            copyDatabase();
	            db = super.getWritableDatabase();
	        } catch(Exception ex) {
	            Log.e("Database Log", myContext + " failed to copy correctly. " + ex.getLocalizedMessage());
	        }
	    }
	    else {
	        db = super.getWritableDatabase();
	    }

	    return db;
	}

}
