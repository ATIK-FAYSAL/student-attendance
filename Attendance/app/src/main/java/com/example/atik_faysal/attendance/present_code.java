package com.example.atik_faysal.attendance;

import android.app.Activity;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.List;

public class present_code extends AppCompatActivity
{
    attendance_database add = new attendance_database(this);
    ListView list;
    Toolbar toolbar;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.present_listview);
        show_list();
    }
    public void show_list()
    {
        Cursor get_value = add.attendance_value();
        String id,name,status,sec,batch,course,date,get_data="";
        while(get_value.moveToNext())
        {
            date = get_value.getString(0);
            id = get_value.getString(1);
            name = get_value.getString(2);
            status = get_value.getString(6);
            get_data+=date+"    "+id+"    "+name+"         "+status+",";
        }
        String[] value;
        if(get_data.equals(""))
        value = new String[] {"NO DATA FOUND"};
        else value = get_data.split(",");
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,R.layout.present_textview,value);
        list = (ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String str = (String)list.getItemAtPosition(position);
                Toast.makeText(present_code.this,"position "+position+"value"+str,Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
