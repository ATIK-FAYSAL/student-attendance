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

public class search_student_code extends Activity
{
    database_helper help = new database_helper(this);
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_student_list_view);
        student_info();
    }
    public void student_info()
    {
        Cursor get_value;
        String id,name,sec,batch,course,get_data="";
        get_value = help.search_student();
        while (get_value.moveToNext())
        {
            id = get_value.getString(0);
            name = get_value.getString(1);
            sec = get_value.getString(2);
            batch = get_value.getString(3);
            course = get_value.getString(4);
            get_data+=id+"    "+name+"     "+sec+"     "+batch+"     "+course+",";
        }
        String[] value;
        if(get_data.equals(""))value = new String[] {"NO DATA FOUND"};
        else value = get_data.split(",");
        list = (ListView)findViewById(R.id.all_list);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,R.layout.search_student_textview,value);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = (String)list.getItemAtPosition(position);
                Toast.makeText(search_student_code.this,"position "+position+"value"+str,Toast.LENGTH_LONG).show();
            }
        });
    }
}
