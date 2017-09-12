package brandon.example.com.locking;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivityRegistroExito extends AppCompatActivity {

    private TextView textView;
    private Button button;

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //Seteo orientacion
        requestWindowFeature(Window.FEATURE_NO_TITLE); //Le quito el titulo para que se vea completo
        setContentView(R.layout.activity_splash_registro_exito);

        textView = (TextView) findViewById(R.id.textView2);

        prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        if(user!=null){
            String name = user.getDisplayName().toString();
            String[] onlyname = name.split(" ");
            String email = user.getEmail();
            if(name==null){
                String username = prefs.getString("username","");
                textView.setText("Hi "+username+", now you are ready to hit the streets");
            }else{
                textView.setText("Hi "+onlyname[0]+", now you are ready to hit the streets");
            }

        }else{
            //Ir a la pantalla de login
            Intent intent = new Intent(SplashActivityRegistroExito.this, MainActivity.class);
            startActivity(intent);
        }


        button = (Button) findViewById(R.id.buttonNext2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashActivityRegistroExito.this, InteresesActivity.class);
                startActivity(intent);
            }
        });


/*


        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivityRegistroExito.this, InteresesActivity.class);
                startActivity(intent);
                finish();//Matamos la actividad para que no pueda regresar
            }

        };

        Timer timer= new Timer();
        timer.schedule(task, 3000);*/

    }



}
