package com.example.atik_faysal.attendance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class show_student_code extends Activity
{
    public static  String batch,section;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_student_page);
        select_batch();
        select_section();
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
    public void show_list(View v)
    {
        if(v.getId()==R.id.see)
        {
            Intent i = new Intent(show_student_code.this,set_student_list_code.class);
            startActivity(i);
        }
    }
    public static  String get_section()
    {
        return section;
    }
    public static String get_batch()
    {
        return batch;
    }
}
