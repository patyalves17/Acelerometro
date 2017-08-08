package paty.fiap.com.br.acelerometro;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doAcelerometro(View v){
        Log.i("acelerometro", "ACELEROMETRO");
        startActivity(new Intent(MainActivity.this, AcelerometroActivity.class));
    }

    public void doShake(View v){
        Log.i("Shake", "Shake");
        startActivity(new Intent(MainActivity.this, ShakeActivity.class));
    }

    public void doTts(View v){
        Log.i("doTts", "doTts");
        startActivity(new Intent(MainActivity.this, TextSpeechActivity.class));
    }

    public void doStt(View v){
        Log.i("doTts", "doTts");
        startActivity(new Intent(MainActivity.this, TextSpeechActivity.class));
    }



}
