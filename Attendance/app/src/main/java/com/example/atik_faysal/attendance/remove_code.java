package com.example.atik_faysal.attendance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class remove_code extends Activity
{
    public static String section,batch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remove_page);
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

    public static String return_section()
    {
        return section;
    }
    public static String return_batch()
    {
        return batch;
    }
    public void show_student(View v)
    {
        if(v.getId()==R.id.student_list)
        {
            Intent page = new Intent(remove_code.this,remove_student_code.class);
            startActivity(page);
        }
    }
}
