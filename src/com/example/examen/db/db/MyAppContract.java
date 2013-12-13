package com.example.examen.db.db;

import android.provider.BaseColumns;

public class MyAppContract {
	public MyAppContract() {
		// this empty constructor prevent accidentally instantiating the contract class
	}
	
	public static abstract class Place implements BaseColumns {
		public static final String TABLE_NAME = "place";
		public static final String COLUMN_NAME_NAME= "name";
		public static final String COLUMN_NAME_DESCRIPTION = "description";
		
	}
	public static abstract class Compras implements BaseColumns {
        public static final String TABLE_NAME = "compras";
        public static final String COLUMN_NAME_COMPRA = "compra";
        public static final String COLUMN_NAME_DESCRIPTIONS = "descriptions";
}



}
