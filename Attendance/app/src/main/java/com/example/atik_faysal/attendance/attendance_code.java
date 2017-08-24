package com.example.atik_faysal.attendance;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class attendance_code extends AppCompatActivity
{
    Toolbar toolbar;
    database_helper help = new database_helper(this);
    attendance_database data = new attendance_database(this);
    absent_database add = new absent_database(this);
    ArrayList<String>present_student_id = new ArrayList<>();
    ArrayList<String>present_student_name = new ArrayList<>();
    ArrayList<String>absent_student_id =  new ArrayList<>();
    ArrayList<String>absent_student_name = new ArrayList<>();
    boolean temp;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attendance_listview);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        get_student();
    }
    @Override
    public void onBackPressed()
    {
        confirm();
    }
    public void get_student()
    {
        Cursor get_value;
        get_value = help.student();
        String name,id,get_data="";
        while(get_value.moveToNext())
        {
            id = get_value.getString(0);
            name = get_value.getString(1);
            get_data+=id+"       "+name+",";
        }
        String[] value;
        if(get_data.equals(""))value = new String[] {"NO DATA FOUND"};
        else value = get_data.split(",");
        list = (ListView)findViewById(R.id.list);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,R.layout.attendance_checkview,R.id.checkbox,value);
        list.setAdapter(adapter);
        CheckedTextView check = (CheckedTextView) findViewById(R.id.checkbox);
        for(int i=0;i<value.length;i++)list.setItemChecked(i,true);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //CheckedTextView check = (CheckedTextView) findViewById(R.id.checkbox);
                String str = (String)list.getItemAtPosition(position);
                    int i;
                    String get_id="",get_name="";
                    for(i=0;i<11;i++)get_id+=str.charAt(i);
                    for(i=18;i<str.length();i++)get_name+=str.charAt(i);
                    absent_student_id.add(get_id);
                    absent_student_name.add(get_name);
            }
        });
    }
   public void absent_student()
   {
       Cursor get_value = help.get_student();
       String id,get_id="",get_name="",name;
       while(get_value.moveToNext())
       {
           id = get_value.getString(0);
           name = get_value.getString(1);
           get_id+=id+",";
           get_name+=name+",";
       }
       String[] value;
       String[] name_value;
       value = get_id.split(",");
       name_value = get_name.split(",");
       ArrayList<String>list = new ArrayList<>();
       ArrayList<String>name_list = new ArrayList<>();
       int i,j;
       for(i=0;i<value.length;i++)
       {
           list.add(value[i]);
       }
       for(i=0;i<name_value.length;i++)
       {
           name_list.add(name_value[i]);
       }
       boolean flag;
       for(i=0;i<list.size();i++)
       {
           flag = false;
           for(j=0;j<absent_student_id.size();j++)
           {
               if(list.get(i).equals(absent_student_id.get(j)))
               {
                   flag = true;
                   break;
               }
           }
           if(flag==false)
           {
               present_student_id.add(list.get(i));
               present_student_name.add(name_list.get(i));
           }
       }
       String sec,batch,course,date;
       date = id_call_code.return_date();
       sec = id_call_code.return_section();
       batch = id_call_code.return_batch();
       course = id_call_code.return_course();
       for(i=0;i<present_student_id.size();i++) data.insert_value(date,present_student_id.get(i),present_student_name.get(i),sec,batch,course,"P");
       for(i=0;i<absent_student_id.size();i++)data.insert_value(date,absent_student_id.get(i),absent_student_name.get(i),sec,batch,course,"A");
       Toast.makeText(this,"Data saved",Toast.LENGTH_LONG).show();
       temp = true;
   }
   public void confirm ()
   {
       if(temp==true)
       {
           //Intent see = new Intent(attendance_code.this,id_call_code.class);
           //startActivity(see);
           finish();
       }
       else
       {
           AlertDialog.Builder builder = new AlertDialog.Builder(attendance_code.this);
           builder.setTitle("Alert");
           builder.setMessage("Are you sure,you want to back without saving data?");
           builder.setPositiveButton("YES",new DialogInterface.OnClickListener()
           {
               @Override
               public void onClick(DialogInterface dialog,int which)
               {
                   finish();
               }
           });
           builder.setNegativeButton("NO",null);
           AlertDialog alertDialog = builder.create();
           alertDialog.show();
       }
   }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.save,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int res_id;
        res_id = item.getItemId();
        if(res_id==R.id.save)
        {
            absent_student();
        }
        return  true;
    }
}
