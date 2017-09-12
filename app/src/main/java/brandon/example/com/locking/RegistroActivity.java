package brandon.example.com.locking;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edt_email, edt_password, edt_confirmpass;
    private Button button;
    private TextView tv6, tv7, tv8, tv10;




    //private FirebaseAuth firebaseAuth;

    FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);



        mAuthListener = new FirebaseAuth.AuthStateListener(){

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user!=null){
                    Log.e("MYLOG","sesion iniciada ");
                    Intent intent = new Intent(RegistroActivity.this, SplashActivityRegistroExito.class);
                    startActivity(intent);
                }else{
                    Log.e("MYLOG","sesion cerrada");
                }
            }
        };

       // firebaseAuth = FirebaseAuth.getInstance();



        edt_email = (EditText) findViewById(R.id.editTextEmailRegis);
        edt_password = (EditText) findViewById(R.id.editTextPassRegis);
        edt_confirmpass = (EditText) findViewById(R.id.editTextConfirmPass);
        tv6 = (TextView) findViewById(R.id.textView6);
        tv7 = (TextView) findViewById(R.id.textView7);
        tv8 = (TextView) findViewById(R.id.textView8);
        tv10 = (TextView) findViewById(R.id.textView10);

        button = (Button) findViewById(R.id.buttonRegister);

        Typeface typefaceBold = Typeface.createFromAsset(getAssets(),"Raleway-Bold.ttf");
        Typeface typefaceRegular = Typeface.createFromAsset(getAssets(),"Raleway-Regular.ttf");

        tv6.setTypeface(typefaceRegular);
        tv7.setTypeface(typefaceRegular);
        tv8.setTypeface(typefaceRegular);
        tv10.setTypeface(typefaceRegular);
        //edt_name.setTypeface(typefaceRegular);
        //edt_mail.setTypeface(typefaceRegular);
        edt_password.setTypeface(typefaceRegular);
        button.setTypeface(typefaceBold);

        button.setOnClickListener(this);
        tv10.setOnClickListener(this);

    }


    private void registar(String email, String pass){
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(RegistroActivity.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(RegistroActivity.this, "No se pudo registrar el usuario", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }







    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonRegister:
                String email = edt_email.getText().toString();
                String pass = edt_password.getText().toString();
                String confirmpass = edt_confirmpass.getText().toString();

                if(pass.equals(confirmpass)){
                    registar(email,pass);
                }
                else{
                    Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.textView10:

                break;
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mAuthListener!=null){
             FirebaseAuth.getInstance().removeAuthStateListener(mAuthListener);
        }
    }

}
