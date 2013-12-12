package com.example.examen.db.db;

import com.example.examen.db.db.MyAppContract.Place;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyAppDbHelper extends SQLiteOpenHelper{
	// If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MyApp.db";
    
//  private static final String NULL_TYPE = " NULL";
	private static final String TEXT_TYPE = " TEXT";
//	private static final String INTEGER_TYPE = " INTEGER";
//	private static final String REAL_TYPE = " REAL";
//	private static final String BLOB_TYPE = " BLOB";
	
	private static final String COMMA_SEPARATOR = ",";
	
	private static final String SQL_CREATE_PLACE =
		    "CREATE TABLE " + Place.TABLE_NAME + " (" +
		    Place._ID + " INTEGER PRIMARY KEY," +
		    Place.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEPARATOR +
		    Place.COLUMN_NAME_DESCRIPTION + TEXT_TYPE + COMMA_SEPARATOR +
		      
		    " )";
	
	private static final String SQL_DROP_PLACE =
		    "DROP TABLE IF EXISTS " + Place.TABLE_NAME;
    
    public MyAppDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PLACE);
    }
    
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    	Log.w(
    			MyAppDbHelper.class.getName(),
    			"Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data"
    	);

    	db.execSQL(SQL_DROP_PLACE);
    	onCreate(db);
    }
    
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
	
	

}



