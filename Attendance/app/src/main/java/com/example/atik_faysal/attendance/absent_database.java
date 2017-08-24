package com.example.atik_faysal.attendance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class absent_database extends SQLiteOpenHelper
{
    private static final int DatabaseVersion = 3;
    private static final String database_name = "absent_info";
    private static final String Date = "date";
    private static final String id = "id";
    private static final String name = "name";
    private static final String section = "section";
    private static final String batch = "batch";
    private static final String course = "course";
    private static final String status = "status";
    private static final String table_name = "absent_table";

    public absent_database(Context context) {
        super(context, database_name,null,DatabaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table "+table_name+"( "+Date+" Text,"+id+" Text,"+name+" Text,"+section+" Text,"+batch+" Text,"+course+" Text,"+status+" Text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insert_value_absent(String date,String Id,String Name,String sec,String Batch,String Course,String Status)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(Date,date);
        value.put(id,Id);
        value.put(name,Name);
        value.put(section,sec);
        value.put(batch,Batch);
        value.put(course,Course);
        value.put(status,Status);
        db.insert(table_name,null,value);
    }
    public Cursor absent_value()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String sec,bat,cour,date;
        sec = attendance_page_code.return_section();
        bat = attendance_page_code.return_batch();
        cour = attendance_page_code.return_course();
        date = attendance_page_code.return_date();
        String sql = "SELECT * FROM "+table_name+" where "+Date+"= '"+date+"' and "+section+" ='"+sec+"' and "+batch+"= '"+bat+"'and "+course+"='"+cour+"'";
        Cursor cursor;
        cursor = db.rawQuery(sql,null);
        return cursor;
    }
}
