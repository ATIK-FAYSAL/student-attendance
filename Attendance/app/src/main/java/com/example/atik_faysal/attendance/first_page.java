package com.example.atik_faysal.attendance;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class first_page extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static String enter_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    /*@Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }*/
    @Override
    public void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(first_page.this);
        builder.setTitle("EXIT");
        builder.setMessage("Are you sure , you want to Exit?");
        builder.setPositiveButton("YES",new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog,int which)
            {
                finish();
            }
        });
        builder.setNegativeButton("NO",null);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.first_page, menu);
        return true;
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.first_button)
        {
            Intent see = new Intent(first_page.this,id_call_code.class);
            startActivity(see);
        }
        else if (id == R.id.second_button)
        {
            Intent see = new Intent(first_page.this,attendance_page_code.class);
            startActivity(see);
        }
        else if (id == R.id.third_button)
        {
            Intent see = new Intent(first_page.this,add_student_code.class);
            startActivity(see);
        }
        else if (id == R.id.fourth_button)
        {
            Intent page = new Intent(first_page.this,remove_code.class);
            startActivity(page);
        }
        else if (id == R.id.fifth_button)
        {
            Intent see = new Intent(first_page.this,show_student_code.class);
            startActivity(see);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void student(View v)
    {
        EditText id = (EditText)findViewById(R.id.txt_enter_id);
        enter_id = id.getText().toString();
        Intent page = new Intent(first_page.this,search_student_code.class);
        startActivity(page);
    }
    public static String return_id()
    {
        return enter_id;
    }
}
