package com.example.examen.db.db;

import java.util.ArrayList;
import java.util.List;

import com.example.examen.db.db.MyAppContract.Compras;
import com.example.examen.db.db.MyAppContract.Place;
import com.example.examen.db.model.Compra;
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
	 private String[] allColumns1 = {
             Compras._ID,
             Compras.COLUMN_NAME_COMPRA,
             Compras.COLUMN_NAME_DESCRIPTIONS,
             };






 public Compra createCompra(String compra1, String descriptions1) {
         ContentValues values = new ContentValues();
         values.put(Compras.COLUMN_NAME_COMPRA, compra1);
         values.put(Compras.COLUMN_NAME_DESCRIPTIONS, descriptions1);                
         
         
 
         
     long insertId = db.insert(Compras.TABLE_NAME, null, values);
     
     Cursor c = db.query(
                     Compras.TABLE_NAME,
                     this.allColumns1, Compras._ID + " = " + insertId, 
                     null,
                     null, 
                     null, 
                     null
             );
     c.moveToFirst();
     
     Compra co = cursorToCompra(c);
     c.close();
     
     return co;
 
 }
 
 public Compra updateCompra(Compra co, String compra1, String descriptions1) {
         ContentValues values = new ContentValues();
         values.put(Compras.COLUMN_NAME_COMPRA, compra1);
         values.put(Compras.COLUMN_NAME_DESCRIPTIONS, descriptions1);   
         
         
         
     db.update(Compras.TABLE_NAME, values, Compras._ID + " = " + co.getId(), null);
     
     co.setCompra(compra1);
     co.setDescriptions(descriptions1);
    
     
     return co;
 }
 
 public List<Compra> getCompras() {
     List<Compra> compras = new ArrayList<Compra>();
     
     String sortOrder = Compras.COLUMN_NAME_COMPRA + " DESC";
     
     Cursor c = db.query(
                     Compras.TABLE_NAME,        // The table to query
                     this.allColumns,                        // The columns to return
                     null,                                // The columns for the WHERE clause
                     null,                                // The values for the WHERE clause
                     null,                                // don't group the rows
                     null,                                // don't filter by row groups
                     sortOrder                        // The sort order
             );


     c.moveToFirst();
     while (!c.isAfterLast()) {
       Compra co = cursorToCompra(c);
       compras.add(co);
       c.moveToNext();
     }
     
     // make sure to close the cursor
     c.close();
     
     return compras;
 }
 
 public Compra deleteCompra(Compra co) {
     long id = co.getId();
     db.delete(Compras.TABLE_NAME, Compras._ID + " = " + id, null);
     co.setId(0);
     return co;
 }


 
 private Compra cursorToCompra(Cursor cursor) {
         Compra co = new Compra();
     co.setId(cursor.getLong(0));//
     co.setCompra(cursor.getString(1));
     co.setDescriptions(cursor.getString(2));
     
     return co;
 }
}






