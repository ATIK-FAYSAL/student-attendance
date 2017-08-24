package com.example.atik_faysal.attendance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class database_helper extends SQLiteOpenHelper
{

    private static final int Database_version=1;
    private static final String database_name ="information";
    private static final String student_name ="st_name";
    private static final String student_id ="st_id";
    private static final String student_sec ="st_sec";
    private static final String student_batch ="st_batch";
    private static final String student_course = "st_course";
    private static final String table_name = "student_info";
    public database_helper(Context context) {
        super(context,database_name, null, Database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "create table "+table_name+" ("+student_id+" Text,"+student_name+" Text,"+student_sec+" Text,"+student_batch+" Text,"+student_course+" Text)";
        db.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void add_student_data(String id,String name,String sec,String batch,String course)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(student_id,id);
        value.put(student_name,name);
        value.put(student_sec,sec);
        value.put(student_batch,batch);
        value.put(student_course,course);
        db.insert(table_name,null,value);
        db.close();

    }
    public Cursor get_id_name()
    {
        String section,batch;
        section = show_student_code.get_section();
        batch = show_student_code.get_batch();
        String sql = "SELECT * FROM "+table_name+" where "+student_sec+"= '"+section+"'and "+student_batch+" = '"+batch+"'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor get_value = db.rawQuery(sql,null);
        return get_value;
    }
    public Cursor search_student()
    {
        String id ;
        id = first_page.return_id();
        String sql = "SELECT * FROM "+table_name+" where "+student_id + " = '"+id+"'";
        Cursor cursor;
        SQLiteDatabase db = this.getWritableDatabase();
        cursor = db.rawQuery(sql,null);
        return  cursor;
    }
    public Cursor remove_student_method()
    {
        String section,batch;
        section = remove_code.return_section();
        batch = remove_code.return_batch();
        String sql = "SELECT * FROM "+table_name+" where "+student_sec+"= '"+section+"'and "+student_batch+" = '"+batch+"'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor get_value = db.rawQuery(sql,null);
        return get_value;
    }
    public int  remove_student()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String get_id = remove_student_code.return_list_value();
        return  db.delete(table_name,student_id+" = ?",new String[] {get_id});
    }
    public Cursor student()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String section,batch,course;
        section = id_call_code.return_section();
        batch = id_call_code.return_batch();
        course = id_call_code.return_course();
        String sql = "SELECT * FROM "+table_name+" where "+student_sec+" = '"+section+"' and "+student_batch+" = '"+batch+"' and "+student_course+" = '"+course+"'";
        Cursor get_value = db.rawQuery(sql,null);
        return get_value;
    }
    public Cursor get_student()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String sec,batch,course;
        sec = id_call_code.return_section();
        batch = id_call_code.return_batch();
        course = id_call_code.return_course();
        String sql = "SELECT * FROM "+table_name+" where "+student_sec+" = '"+sec+"' and "+student_batch+"='"+batch+"' and "+student_course+"='"+course+"'";
        Cursor cursor = db.rawQuery(sql,null);
        return cursor;
    }

}
