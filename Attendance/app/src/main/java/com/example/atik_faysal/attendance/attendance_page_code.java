package com.example.atik_faysal.attendance;

import android.app.Activity;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class attendance_page_code extends AppCompatActivity
{
    public static String day,month,year,date;
    public static String section,batch,course;
    RadioGroup rg;
    RadioButton rb;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attendance_page);
        select_day();
        select_month();
        select_year();
        select_course();
        select_batch();
        select_section();
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    public void select_day()
    {
        ArrayAdapter<CharSequence>adapter ;
        Spinner spin ;
        spin = (Spinner)findViewById(R.id.day);
        adapter = ArrayAdapter.createFromResource(this,R.array.day,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                day = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void select_month()
    {
        ArrayAdapter<CharSequence>adapter ;
        Spinner spin ;
        spin = (Spinner)findViewById(R.id.month);
        adapter = ArrayAdapter.createFromResource(this,R.array.month,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                month = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void select_year()
    {
        ArrayAdapter<CharSequence>adapter ;
        Spinner spin ;
        spin = (Spinner)findViewById(R.id.year);
        adapter = ArrayAdapter.createFromResource(this,R.array.year,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                year = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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
        adapter = ArrayAdapter.createFromResource(this,R.array.batch_name,android.R.layout.simple_spinner_item);
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
        adapter = ArrayAdapter.createFromResource(this,R.array.course_code,android.R.layout.simple_spinner_item);
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
        if(month.equals("January"))date = year+"-"+"1"+"-"+day;
        else if (month.equals("February"))date = year+"-"+"2"+"-"+day;
        else if (month.equals("March"))date = year+"-"+"3"+"-"+day;
        else if (month.equals("April"))date = year+"-"+"4"+"-"+day;
        else if (month.equals("May"))date = year+"-"+"5"+"-"+day;
        else if (month.equals("Jun"))date = year+"-"+"6"+"-"+day;
        else if (month.equals("July"))date = year+"-"+"7"+"-"+day;
        else if (month.equals("August"))date = year+"-"+"8"+"-"+day;
        else if (month.equals("September"))date = year+"-"+"9"+"-"+day;
        else if (month.equals("October"))date = year+"-"+"10"+"-"+day;
        else if (month.equals("November"))date = year+"-"+"11"+"-"+day;
        else if (month.equals("December"))date = year+"-"+"12"+"-"+day;
        return date;
    }
    /*public void see_button(View v)
    {
        if(v.getId()==R.id.see)
        {
            try{
                Intent see = new Intent(attendance_page_code.this,present_code.class);
                startActivity(see);
            }
            catch (Exception e)
            {
                Toast.makeText(attendance_page_code.this,e.toString(),Toast.LENGTH_LONG).show();
            }
        }
        else if(v.getId()==R.id.update)
        {
            try
            {
                Intent i = new Intent(attendance_page_code.this,update_code.class);
                startActivity(i);
            }
            catch (Exception e)
            {
                Toast.makeText(attendance_page_code.this,e.toString(),Toast.LENGTH_LONG).show();
            }
        }
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.save_update,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int res_id;
        res_id = item.getItemId();
        if(res_id==R.id.show)
        {
            try{
                Intent see = new Intent(attendance_page_code.this,present_code.class);
                startActivity(see);
            }
            catch (Exception e)
            {
                Toast.makeText(attendance_page_code.this,e.toString(),Toast.LENGTH_LONG).show();
            }
        }
        else if(res_id==R.id.update)
        {
            try
            {
                Intent i = new Intent(attendance_page_code.this,update_code.class);
                startActivity(i);
            }
            catch (Exception e)
            {
                Toast.makeText(attendance_page_code.this,e.toString(),Toast.LENGTH_LONG).show();
            }
        }
        return true;
    }
}