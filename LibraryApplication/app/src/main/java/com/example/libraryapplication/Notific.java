package com.example.libraryapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class Notific extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Window window;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notific);

        drawerLayout=findViewById(R.id.drawer_layout);
        if(Build.VERSION.SDK_INT>=21){
            window =this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.color));
        }
    }
    public void onBackPressed() {
        Intent intent  = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }

    public void ClikMenu(View view){
        MainActivity2.openDrawer(drawerLayout);
    }
    public void Clicklogo(View view){
        MainActivity2.closeDrawer(drawerLayout);
    }
    public void Clicksearch(View view){
        Intent intent  = new Intent(this,Searsh.class);
        startActivity(intent);
    }
    public void ClickHome(View view){
        Intent intent  = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }

    public void ClickNotif(View view){
        recreate();
    }
    public void ClickReqEbook(View view){

        Intent intent  = new Intent(this,Requestebook.class);
        startActivity(intent);
    }
    public void ClickAboutUs(View view){
        Intent intent  = new Intent(this,AboutUs.class);
        startActivity(intent);
    }
    public void ClickExit(View view){
        MainActivity2.exit(this);
    }
    public void ClickLogout(View view){
        MainActivity2.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        MainActivity2.closeDrawer(drawerLayout);
    }
}