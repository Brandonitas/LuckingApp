package brandon.example.com.locking;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class FirstActivity extends AppCompatActivity {



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //Seteo orientacion
        requestWindowFeature(Window.FEATURE_NO_TITLE); //Le quito el titulo para que se vea completo
        setContentView(R.layout.activity_first);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(FirstActivity.this, MainActivity.class);
                startActivity(intent);
                finish();//Matamos la actividad para que no pueda regresar
            }

        };

        Timer timer= new Timer();
        timer.schedule(task, 2000);


    }
}
