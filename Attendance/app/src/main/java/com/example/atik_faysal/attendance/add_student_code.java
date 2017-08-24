package com.example.atik_faysal.attendance;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class add_student_code extends AppCompatActivity
{
    Toolbar toolbar;
    public String st_name,st_id,st_sec,st_batch,st_cours;
    public String st_name1,st_id1,st_sec1,st_batch1,st_cours1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_student);
        select_batch();
        select_sec();
        select_course();
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void select_sec()
    {
        Spinner spinner = (Spinner)findViewById(R.id.section);
        ArrayAdapter<CharSequence>adapter;
        adapter = ArrayAdapter.createFromResource(this,R.array.section_name,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                st_sec = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void select_batch()
    {
        Spinner spinner = (Spinner)findViewById(R.id.batch);
        ArrayAdapter<CharSequence>adapter;
        adapter = ArrayAdapter.createFromResource(this,R.array.batch_name,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                st_batch = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
   public void select_course()
    {
        Spinner spinner = (Spinner)findViewById(R.id.all_course);
        ArrayAdapter<CharSequence>adapter;
        adapter = ArrayAdapter.createFromResource(this,R.array.course_code,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                st_cours = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    /*public void set_id(String s)
    {
        st_id1 = s;
    }
    public void set_name(String s)
    {
        st_name1 = s;
    }
    public void set_sec(String  s)
    {
        st_sec1 = s;
    }
    public void set_batch(String s)
    {
        st_batch1 = s;
    }
    public void set_course(String s)
    {
        st_cours1 = s;
    }*/

    public add_student_code() {

    }

    public void save_data()
    {
        EditText name = (EditText)findViewById(R.id.name);
        EditText id = (EditText)findViewById(R.id.id);
        st_name = name.getText().toString();
        st_id = id.getText().toString();
        int i;
        boolean flag1=false,flag2=false;
        for(i=0;i<st_name.length();i++)
        {
            if((st_name.charAt(i)>='A'&&st_name.charAt(i)<='Z')||(st_name.charAt(i)>='a'&&st_name.charAt(i)<='z')||st_name.charAt(i)=='.'||st_name.charAt(i)==' ')
            {
                flag1 = true;
            }
            else
            {
                flag1=false;
                break;
            }
        }
        for(i=0;i<st_id.length();i++)
        {
            if((st_id.charAt(i)>='0'&&st_id.charAt(i)<='9')||(st_id.charAt(i)=='-')&&st_id.length()==11)
            {
                flag2 = true;
            }
            else
            {
                flag2 = false;
                break;
            }
        }
        boolean flag = true;
        if(st_sec.equals("SECTION")||st_batch.equals("BATCH")||st_cours.equals("COURSE"))flag = false;
        if(flag1==true&&flag2==true&&flag==true)
        {
            database_helper data = new database_helper(this);
            data.add_student_data(st_id,st_name,st_sec,st_batch,st_cours);
            Toast.makeText(this,"Data saved successfully",Toast.LENGTH_LONG).show();
        }
        else Toast.makeText(this,"Please insert valid data.",Toast.LENGTH_LONG).show();
    }
    public void reset_method()
    {
        EditText name = (EditText)findViewById(R.id.name);
        EditText id = (EditText)findViewById(R.id.id);
        name.setText("");
        id.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.save_reset,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int res_id = item.getItemId();
        if(res_id==R.id.save)
        {
            save_data();
        }
        else if(res_id==R.id.reset)
        {
            reset_method();
        }
        return  true;
    }
}

