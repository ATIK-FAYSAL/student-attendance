package com.example.atik_faysal.attendance;


import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class set_student_list_code extends Activity
{
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_list);
        show_list();
    }
    public void show_list()
    {
        database_helper help = new database_helper(this);
        Cursor get_value = help.get_id_name();
        String[] value;
        String name,id,sec,batch,get_data="";
        while(get_value.moveToNext())
        {
            id = get_value.getString(0);
            name = get_value.getString(1);
            get_data+= id+"                           "+name+",";
        }
        if(get_data.equals(""))value = new String[] {"  NO DATA FOUND"};
        else value = get_data.split(",");
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,R.layout.show_student,value);
        list = (ListView)findViewById(R.id.stuent_list);
        list.setAdapter(adapter);
        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String str = (String)list.getItemAtPosition(position);
                Toast.makeText(set_student_list_code.this,"position "+position+"value"+str,Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
