package com.alaa.restaurant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	public static final String database_name="restaurant",
			table1_name="category",
			t1col1="id",
			t1col2="name",
			table2_name="items",
			t2col1="id",
			t2col2="name";
	public static final int	database_version=1;
	public SQLiteDatabase db;
	
	public DatabaseHelper(Context context) {
		super(context, database_name, null, database_version);
		
		db=this.getWritableDatabase();
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		//db.execSQL("create table "+table1_name+"("+t1col1+" integer NOT NULL PRIMARY KEY AUTOINCREMENT,"+t1col2+" text NOT NULL);");
		//db.execSQL("create table "+table2_name+"("+t2col1+" integer NOT NULL PRIMARY KEY AUTOINCREMENT,"+t2col2+" text NOT NULL)");
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table if exists "+table1_name);
		db.execSQL("drop table if exists "+table2_name);
		onCreate(db);
	}
	
	public boolean AddCategory(String name){
		db.execSQL("insert into "+table1_name+"("+t1col2+") values("+name+")");
		return true;
	}
}
