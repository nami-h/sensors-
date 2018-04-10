package com.example.mypc.sesnsors;


import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import java.lang.String;
import static java.lang.Math.sqrt;


public class accelerometer extends AppCompatActivity implements SensorEventListener{

    private static final String TAG = "accelerometer";
    TextView x, y, z, a;
    Float total;
    private SensorManager mgr;
    private Sensor accel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        x=(TextView) findViewById(R.id.x);
        y=(TextView) findViewById(R.id.y);
        z=(TextView) findViewById(R.id.z);
        a=(TextView) findViewById(R.id.a);

        mgr = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accel = mgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        if(mgr!=null)
        {
            mgr.registerListener(accelerometer.this, accel, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor,int i) {

    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent){

        {
            Sensor sensor=sensorEvent.sensor;

            if(sensor.getType()==Sensor.TYPE_ACCELEROMETER)
            {
                Log.d(TAG, "onSensorChanged:X=" + sensorEvent.values[0] + "Y=" + sensorEvent.values[1] + "Z=" + sensorEvent.values[2]);
                x.setText("x= " + sensorEvent.values[0] + "  m/s\u00B2");
                y.setText("y= " + sensorEvent.values[1] + "  m/s\u00B2");
                z.setText("z= " + sensorEvent.values[2] + "  m/s\u00B2");
                total = (float) sqrt(((sensorEvent.values[0])*(sensorEvent.values[0])) + ((sensorEvent.values[1])*(sensorEvent.values[1])) + ((sensorEvent.values[2])*(sensorEvent.values[2])));
                a.setText("total= " +Float.toString(total) +"  m/s\u00B2");
            }
        }

    }
}