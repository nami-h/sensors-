package com.example.mypc.sesnsors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;


import android.hardware.SensorEventListener;

public class menu extends AppCompatActivity
{
    private Button button3, button4,button6,button8,button11;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.v("inside oncreate menu for button 3","heyy");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Log.v("after set content view","heyy");
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                open_accel();
            }
        });

        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                open_gyro();
            }
        });

        button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                open_light();
            }
        });

        button8 = findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) { open_grav();}
        });

        button11 = findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                open_mag();
            }
        });

    }
    public void open_accel()
    {
        Intent intent=new Intent(this,accelerometer.class);
        startActivity(intent);
    }

    public void open_gyro()
    {
        Intent intent = new Intent(menu.this, gyroscope.class);
        startActivity(intent);
    }

    public void open_light()
    {
        Intent intent = new Intent(menu.this, light.class);
        startActivity(intent);
    }

    public void open_grav()
    {
        Intent intent = new Intent(menu.this, gravity.class);
        startActivity(intent);
    }

    public void open_mag()
    {
        Intent intent = new Intent(menu.this, magnetometer.class);
        startActivity(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture)
    {

    }
}
