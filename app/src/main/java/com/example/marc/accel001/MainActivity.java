package com.example.marc.accel001;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.text.Html;
import android.view.Menu;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class MainActivity extends Activity implements SensorEventListener {

    private SensorManager sensorManager;

    TextView x;
    TextView y;
    TextView z;

    String sx, sy, sz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        x = (TextView) findViewById (R.id.textView2);
        y = (TextView) findViewById (R.id.textView3);
        z = (TextView) findViewById (R.id.textView4);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        sensorManager.registerListener(this, sensorManager.getDefaultSensor
                (Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public void onAccuracyChanged(Sensor arg0, int arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // TODO Auto-generated method stub

        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){

            float xVal = event.values[0];
            float yVal = event.values[1];
            float zVal = event.values[2];

            int xInt = (int) xVal;
            int yInt = (int) yVal;
            int zInt = (int) zVal;

            sx = "X Value : <font color = '#800080'> " + xInt + "</font>";
            sy = "Y Value : <font color = '#800080'> " + yInt + "</font>";
            sz = "Z Value : <font color = '#800080'> " + zInt + "</font>";

            x.setText(Html.fromHtml(sx));
            y.setText(Html.fromHtml(sy));
            z.setText(Html.fromHtml(sz));
        }
    }
}
