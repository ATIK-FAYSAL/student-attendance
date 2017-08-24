package com.example.atik_faysal.attendance;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class remove_student_code extends Activity
{
    database_helper help = new database_helper(this);
    ListView list;
    public static String list_value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remove_listview);
        student_list();
    }
    public void student_list()
    {
        Cursor get_value;
        get_value = help.remove_student_method();
        String id,name,get_data="";
        String[] value ;
        while(get_value.moveToNext())
        {
            id = get_value.getString(0);
            name = get_value.getString(1);
            get_data+=id+"    "+name+",";
        }
        if(get_data.equals(""))value = new String[] {"   NO DATA"};
        else value = get_data.split(",");
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,R.layout.remove_textview,value);
        list = (ListView)findViewById(R.id.all_list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                list_value = (String)list.getItemAtPosition(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(remove_student_code.this);
                builder.setTitle("Remove Alert");
                builder.setMessage("Are you sure,you want to remove this ID ?");
                builder.setPositiveButton("YES",new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog,int which)
                    {
                        int x;
                        x = help.remove_student();
                        if(x!=0)Toast.makeText(remove_student_code.this,"Data removed successfully",Toast.LENGTH_LONG).show();
                        else Toast.makeText(remove_student_code.this,"No data found",Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("NO",null);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
    public static String return_list_value()
    {
        String str = "";
        int i;
        for(i=0;i<list_value.length();i++)
        {
            if(list_value.charAt(i)==' ')break;
            str+=list_value.charAt(i);
        }
        return str;
    }

}
