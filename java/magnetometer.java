package com.example.mypc.sesnsors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import java.lang.String;
import static java.lang.Math.sqrt;

public class magnetometer extends AppCompatActivity implements SensorEventListener{
    private SensorManager mgr;
    private Sensor mag;
    TextView x_mag, y_mag, z_mag, a_mag;
    Float total_mag;
    private static final String TAG="magnetometer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magnetometer);

        x_mag=(TextView) findViewById(R.id.x_mag);
        y_mag=(TextView) findViewById(R.id.y_mag);
        z_mag=(TextView) findViewById(R.id.z_mag);
        a_mag=(TextView) findViewById(R.id.a_mag);

        Log.d(TAG, "on.Create: wait a moment");
        mgr=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mag=mgr.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        if(mgr!=null)
        {
            mgr.registerListener(magnetometer.this, mag, SensorManager.SENSOR_DELAY_NORMAL);
        }

    }
    public void onSensorChanged(SensorEvent sensorEvent)
    {
       Sensor sensor=sensorEvent.sensor;
       if(sensor.getType()==Sensor.TYPE_MAGNETIC_FIELD)
       {
        Log.d(TAG, "onSensorChanged:X:"+sensorEvent.values[0]+"Y"+sensorEvent.values[1]+"Z"+sensorEvent.values[2]);
        x_mag.setText("x= "+sensorEvent.values[0] + " \u00b5T");
        y_mag.setText("y= "+sensorEvent.values[1] + " \u00b5T");
        z_mag.setText("z= "+sensorEvent.values[2] + " \u00b5T");
        total_mag = (float) sqrt(((sensorEvent.values[0])*(sensorEvent.values[0])) + ((sensorEvent.values[1])*(sensorEvent.values[1])) + ((sensorEvent.values[2])*(sensorEvent.values[2])));
        a_mag.setText("total= " +Float.toString(total_mag) +"  \u00b5T");

       }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
