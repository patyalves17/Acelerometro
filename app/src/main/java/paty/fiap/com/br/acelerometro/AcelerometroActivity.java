package paty.fiap.com.br.acelerometro;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AcelerometroActivity extends AppCompatActivity implements SensorEventListener {
    private TextView textViewX;
    private TextView textViewY;
    private TextView textViewZ;
    private TextView textViewDetail;
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;

    private float mAccel; // acceleration apart from gravity
    private float mAccelCurrent; // current acceleration including gravity
    private float mAccelLast; // last acceleration including gravity
    int count = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acelerometro);

        textViewX = (TextView) findViewById(R.id.text_view_x);
        textViewY = (TextView) findViewById(R.id.text_view_y);
        textViewZ = (TextView) findViewById(R.id.text_view_z);
        textViewDetail = (TextView) findViewById(R.id.text_view_detail);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }
    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        Float x = event.values[0];
        Float y = event.values[1];
        Float z = event.values[2];
        textViewX.setText("Posição X: " + x.intValue() + " Float: " + x);
        textViewY.setText("Posição Y: " + y.intValue() + " Float: " + y);
        textViewZ.setText("Posição Z: " + z.intValue() + " Float: " + z);
        if(y < 0) { // O dispositivo esta de cabeça pra baixo
            if(x > 0)
                textViewDetail.setText("Virando para ESQUERDA ficando INVERTIDO");
            if(x < 0)
                textViewDetail.setText("Virando para DIREITA ficando INVERTIDO");
        } else {
            if(x > 0)
                textViewDetail.setText("Virando para ESQUERDA ");
            if(x < 0)
                textViewDetail.setText("Virando para DIREITA ");
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}




}
