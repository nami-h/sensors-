package com.example.mypc.sesnsors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.content.Context;

public class light extends AppCompatActivity implements SensorEventListener{

    private static final String TAG="light";
    private Sensor light_sens;
    private SensorManager mgr;
    TextView light;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);

        light=(TextView) findViewById(R.id.light);

        mgr=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        light_sens=mgr.getDefaultSensor(Sensor.TYPE_LIGHT);

        if(mgr!=null)
        {
            mgr.registerListener(light.this, light_sens, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }
    public void onSensorChanged(SensorEvent sensorEvent)
    {
        Sensor sensor=sensorEvent.sensor;
        if(sensor.getType()==Sensor.TYPE_LIGHT)
        {
            Log.d(TAG, "onSensorChanged:X:"+sensorEvent.values[0]);
            light.setText("x= "+sensorEvent.values[0]+ " lx");

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
