package com.example.examen.db.db;

import java.util.ArrayList;
import java.util.List;

import com.example.examen.db.db.MyAppContract.Place;
import com.example.examen.db.model.Lugar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class MyAppDataSource {
	
	private MyAppDbHelper dbHelper;
	private SQLiteDatabase db;
	
	private String[] allColumns = {
		    Place._ID,
		    Place.COLUMN_NAME_NAME,
		    Place.COLUMN_NAME_DESCRIPTION
		    
		    };

	public MyAppDataSource(Context context) {
		this.dbHelper = new MyAppDbHelper(context);
	}
	
	public void open() throws SQLException {
		this.db = dbHelper.getWritableDatabase();
	}
	
	public void close() {
		dbHelper.close();
	}

	public Lugar createLugar(String name1, String description1) {
		ContentValues values = new ContentValues();
		values.put(Place.COLUMN_NAME_NAME, name1);
		values.put(Place.COLUMN_NAME_DESCRIPTION, description1);
		
		
	    long insertId = db.insert(Place.TABLE_NAME, null, values);
	    
	    Cursor c = db.query(
	    		Place.TABLE_NAME,
	    		this.allColumns, Place._ID + " = " + insertId, 
	    		null,
	    		null, 
	    		null, 
	    		null
	    	);
	    c.moveToFirst();
	    
	    Lugar l = cursorToLugar(c);
	    c.close();
	    
	    return l;
	}
	public Lugar updateLugar(Lugar l, String name1, String description1) {
		ContentValues values = new ContentValues();
		values.put(Place.COLUMN_NAME_NAME, name1);
		values.put(Place.COLUMN_NAME_DESCRIPTION,description1);
		
		
	    db.update(Place.TABLE_NAME, values, Place._ID + " = " + l.getId(), null);
	    
	    l.setName(name1);
	    l.setDescription(description1);
	    
	    return l;
	}
	
	public List<Lugar> getPlace() {
	    List<Lugar> lugar = new ArrayList<Lugar>();
	    
	    String sortOrder = Place.COLUMN_NAME_NAME + " DESC";
	    
	    Cursor c = db.query(
			    Place.TABLE_NAME,	// The table to query
			    this.allColumns,			// The columns to return
			    null,				// The columns for the WHERE clause
			    null,				// The values for the WHERE clause
			    null,				// don't group the rows
			    null,				// don't filter by row groups
			    sortOrder			// The sort order
		    );

	    c.moveToFirst();
	    while (!c.isAfterLast()) {
	      Lugar l = cursorToLugar(c);
	      lugar.add(l);
	      c.moveToNext();
	    }
	    
	    // make sure to close the cursor
	    c.close();
	    
	    return lugar;
	}
	
	public Lugar deleteLugar(Lugar l) {
	    long id = l.getId();
	    db.delete(Place.TABLE_NAME, Place._ID + " = " + id, null);
	    l.setId(0);
	    return l;
	}

	
	private Lugar cursorToLugar(Cursor cursor) {
		Lugar l = new Lugar();
	    l.setId(cursor.getLong(0));
	    l.setName(cursor.getString(1));
	    l.setDescription(cursor.getString(2));
	    return l;
	   
	}

}



