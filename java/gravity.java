package com.example.mypc.sesnsors;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;
import java.lang.String;
import static java.lang.Math.sqrt;

public class gravity extends AppCompatActivity implements SensorEventListener{

    private static final String TAG = "gravity";
    TextView x_grav,y_grav,z_grav,a_grav;
    Float total_grav;
    private SensorManager mgr;
    private Sensor grav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravity);

        x_grav=(TextView) findViewById(R.id.x_grav);
        y_grav=(TextView) findViewById(R.id.y_grav);
        z_grav=(TextView) findViewById(R.id.z_grav);
        a_grav=(TextView) findViewById(R.id.a_grav);

        mgr = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        grav = mgr.getDefaultSensor(Sensor.TYPE_GRAVITY);

        if(mgr!=null)
        {
            mgr.registerListener(gravity.this, grav, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor,int i) {

    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent){

        {
            Sensor sensor=sensorEvent.sensor;

            if(sensor.getType()==Sensor.TYPE_GRAVITY)
            {
                Log.d(TAG, "onSensorChanged:X=" + sensorEvent.values[0] + "Y=" + sensorEvent.values[1] + "Z=" + sensorEvent.values[2]);
                x_grav.setText("x= " + sensorEvent.values[0] + "  m/s\u00B2");
                y_grav.setText("y= " + sensorEvent.values[1] + "  m/s\u00B2");
                z_grav.setText("z= " + sensorEvent.values[2] + "  m/s\u00B2");
                total_grav = (float) sqrt(((sensorEvent.values[0])*(sensorEvent.values[0])) + ((sensorEvent.values[1])*(sensorEvent.values[1])) + ((sensorEvent.values[2])*(sensorEvent.values[2])));
                a_grav.setText("total= " +Float.toString(total_grav) +"  m/s\u00B2");
            }
        }

    }
}



