package com.alaa.restaurant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.category;
import static android.R.attr.name;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String database_name = "restaurant",
			table1_name="category",
			t1col1="id",
			t1col2="name",
			table2_name="items",
			t2col1="id",
			t2col2="name";
    private static final int database_version = 1;
	
	public DatabaseHelper(Context context) {
		super(context, database_name, null, database_version);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table IF NOT EXISTS " + table1_name + "(" + t1col1 + " integer NOT NULL PRIMARY KEY AUTOINCREMENT," + t1col2 + " text NOT NULL);");
        db.execSQL("create table IF NOT EXISTS " + table2_name + "(" + t2col1 + " integer NOT NULL PRIMARY KEY AUTOINCREMENT," + t2col2 + " text NOT NULL)");
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table if exists "+table1_name);
		db.execSQL("drop table if exists "+table2_name);
		onCreate(db);
	}
	
    public boolean AddCategory(SQLiteDatabase db, String name) {
        db.execSQL("insert into " + table1_name + "(" + t1col2 + ") values(\"" + name + "\");");
		return true;
	}
}
