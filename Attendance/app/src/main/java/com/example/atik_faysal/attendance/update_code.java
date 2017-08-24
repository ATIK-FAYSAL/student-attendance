package com.example.atik_faysal.attendance;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
import java.util.List;

import static com.example.atik_faysal.attendance.R.id.check;
import static com.example.atik_faysal.attendance.R.id.up;

public class update_code extends AppCompatActivity
{
    attendance_database add = new attendance_database(this);
    Toolbar toolbar;
    ArrayList<String>present_list = new ArrayList<>();
    ArrayList<String>absent_list = new ArrayList<>();
    ArrayList<String>Student_Id =  new ArrayList<>();
    ArrayList<String>Student_name = new ArrayList<>();
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_listview);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        student_list();
    }
    public void student_list()
    {
        Cursor get_value = add.attendance_value();
        String id,name,status,sec,batch,course,date,get_data="",get_status="";
        while(get_value.moveToNext())
        {
            date = get_value.getString(0);
            id = get_value.getString(1);
            name = get_value.getString(2);
            status = get_value.getString(6);
            get_status+=status+",";
            if(status.equals("P"))present_list.add(id);
            else if (status.equals("A"))absent_list.add(id);
            get_data+=date+"       "+id+"       "+name+",";
        }
        String[] value,status_value = new String[] {};
        if(get_data.equals(""))value = new String[] {"NO DATA FOUND"};
        else
        {
            value = get_data.split(",");
            status_value = get_status.split(",");
        }
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,R.layout.update_checkview, check,value);
        list = (ListView)findViewById(R.id.list);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        list.setAdapter(adapter);
        for(int i=0;i<status_value.length;i++)
        {
            if(status_value[i].equals("P"))list.setItemChecked(i,true);
            else if (status_value[i].equals("A"))list.setItemChecked(i,false);
        }
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String  str = (String)list.getItemAtPosition(position);
                 CheckedTextView check = (CheckedTextView)findViewById(R.id.check);
                //Toast.makeText(update_code.this,str,Toast.LENGTH_LONG).show();
                String[] string = str.split("       ");
                if(Student_Id.contains(string[1]))
                {

                }
                else Student_Id.add(string[1]);
                if(Student_name.contains(string[2]))
                {

                }
                else Student_name.add(string[2]);
            }
        });
    }
  /* public void update (View v)
    {
        //add.delete_attendance();
        //String sec,date,batch,course;
        /*sec = attendance_page_code.return_section();
        date = attendance_page_code.return_date();
        batch = attendance_page_code.return_batch();
        course = attendance_page_code.return_course();
        //for(int i=0;i<present_id.size();i++)add.insert_value(date,present_id.get(i),present_name.get(i),sec,batch,course,"P");
        //for(int i=0;i<absent_id.size();i++)add.insert_value(date,absent_id.get(i),absent_name.get(i),sec,batch,course,"A");
        //Toast.makeText(this,"Update successful",Toast.LENGTH_LONG).show();

    }*/
  public void update()
  {
      int i,j;
      for(i=0;i<Student_Id.size();i++)
      {
          boolean flag = false;
          for(j=0;j<present_list.size();j++)
          {
              if(Student_Id.get(i).equals(present_list.get(j)))
              {
                    add.update_value(present_list.get(j),"A");
                    flag = true;
                    break;
              }
          }
         if(flag==false)
         {
             for(j=0;j<absent_list.size();j++)
             {
                 if(Student_Id.get(i).equals(absent_list.get(j)))
                 {
                     add.update_value(absent_list.get(j),"P");
                     break;
                 }
             }
         }
      }
      Toast.makeText(update_code.this,"Update successful",Toast.LENGTH_LONG).show();
  }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.update,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int res_id;
        res_id = item.getItemId();
        if(res_id==R.id.update)
        {
            update();
        }
        return true;
    }
}
