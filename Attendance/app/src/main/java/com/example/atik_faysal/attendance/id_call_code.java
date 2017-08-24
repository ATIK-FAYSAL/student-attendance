package com.example.atik_faysal.attendance;


import android.app.Activity;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


import java.util.Calendar;
import java.util.Date;

public class id_call_code extends AppCompatActivity
{
    public static String section,batch,course,date;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.id_call);
        select_section();
        select_batch();
        select_course();
        get_date();
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    public void select_section()
    {
        Spinner spinner = (Spinner)findViewById(R.id.section);
        ArrayAdapter<CharSequence>adapter;
        adapter = ArrayAdapter.createFromResource(this,R.array.section_name,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                section = parent.getItemAtPosition(position).toString();
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
        adapter = ArrayAdapter.createFromResource(this, R.array.batch_name,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                batch = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void select_course()
    {
        Spinner spinner = (Spinner)findViewById(R.id.course);
        ArrayAdapter<CharSequence>adapter;
        adapter = ArrayAdapter.createFromResource(this, R.array.course_code,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                course = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void get_date()
    {
        TextView dd = (TextView) findViewById(R.id.date);
        final Calendar cal = Calendar.getInstance();
        dd.setText(new StringBuilder()
                .append(cal.get(Calendar.YEAR)).append("-").append(cal.get(Calendar.MONTH)+ 1).append("-")
                .append(cal.get(Calendar.DAY_OF_MONTH)));
        date = dd.getText().toString();
    }
    public static String return_section()
    {
        return section;
    }
    public static String return_batch()
    {
        return batch;
    }
    public static String return_course()
    {
        return course;
    }
    public static String return_date()
    {
        return date;
    }
    /*public void set_page(View v)
    {
        Intent page = new Intent(id_call_code.this,attendance_code.class);
        startActivity(page);
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int res_id;
        res_id = item.getItemId();
        if(res_id==R.id.attendance)
        {
            Intent page = new Intent(id_call_code.this,attendance_code.class);
            startActivity(page);
        }
        return true;
    }
}
