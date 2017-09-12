package brandon.example.com.locking;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editMail, editPass;
    private Button button;

    FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editMail = (EditText) findViewById(R.id.editTextEmail);
        editPass = (EditText) findViewById(R.id.editTextPass);
        button = (Button) findViewById(R.id.buttonLogin);

        mAuthListener = new FirebaseAuth.AuthStateListener(){

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user!=null){
                    Log.e("MYLOG","sesion iniciada ");
                    Intent intent = new Intent(LoginActivity.this, SplashActivityRegistroExito.class);
                    startActivity(intent);
                }else{
                    Log.e("MYLOG","sesion cerrada");
                }
            }
        };

        button.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonLogin:
                String email = editMail.getText().toString();
                String pass = editPass.getText().toString();
                iniciosesion(email,pass);
                break;

        }
    }


    private void iniciosesion(String email, String pass){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Login exitoso", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LoginActivity.this, "Correo o contraseña invalidos", Toast.LENGTH_SHORT).show();
                }

            }
        });
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
