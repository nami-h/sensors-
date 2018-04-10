package com.example.mypc.sesnsors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.util.Log;
import android.widget.TextView;

import static java.lang.Math.sqrt;

public class gyroscope extends AppCompatActivity implements SensorEventListener{

    private static final String TAG="gyroscope";
    private SensorManager mgr;
    TextView x_gyro, y_gyro, z_gyro, a_gyro;
    Float total_gyro;

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    private Sensor gyro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);

        x_gyro = (TextView) findViewById(R.id.x_gyro);
        y_gyro = (TextView) findViewById(R.id.y_gyro);
        z_gyro = (TextView) findViewById(R.id.z_gyro);
        a_gyro = (TextView) findViewById(R.id.a_gyro);

        mgr = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        gyro = mgr.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if (mgr != null) {
            mgr.registerListener(gyroscope.this, gyro, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent){

        {
            Sensor sensor=sensorEvent.sensor;

            if(sensor.getType()==Sensor.TYPE_GYROSCOPE)
            {
                Log.d(TAG, "onSensorChanged:X=" + sensorEvent.values[0] + "Y=" + sensorEvent.values[1] + "Z=" + sensorEvent.values[2]);
                x_gyro.setText("x= " + sensorEvent.values[0]+ " \u00b0/s");
                y_gyro.setText("y= " + sensorEvent.values[1]+ " \u00b0/s");
                z_gyro.setText("z= " + sensorEvent.values[2]+ " \u00b0/s");
                total_gyro = (float) sqrt(((sensorEvent.values[0])*(sensorEvent.values[0])) + ((sensorEvent.values[1])*(sensorEvent.values[1])) + ((sensorEvent.values[2])*(sensorEvent.values[2])));
                a_gyro.setText("total= " +Float.toString(total_gyro) +" \u00b0/s");

            }
        }
    }
}
