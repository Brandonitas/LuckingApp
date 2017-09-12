package brandon.example.com.locking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class InteresesActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn11, btn12, btn13,btn14,btn15,btn16,btn17,btn19;
    ImageView imageView;

    private ArrayList<String> listaInteres = new ArrayList<String>();

    private int a=0;
    private int b=0;
    private int c=0;
    private int d=0;
    private int e=0;
    private int f=0;
    private int g=0;
    private int h=0;
    private int i=0;
    private int j=0;
    private int k=0;
    private int l=0;
    private int m=0;
    private int o=0;
    private int p=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intereses);

        button = (Button) findViewById(R.id.buttonNext);

        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);
        btn11 = (Button) findViewById(R.id.button11);
        btn12 = (Button) findViewById(R.id.button12);
        btn13 = (Button) findViewById(R.id.button13);
        btn14 = (Button) findViewById(R.id.button14);
        btn15 = (Button) findViewById(R.id.button15);
        btn16 = (Button) findViewById(R.id.button16);
        btn17 = (Button) findViewById(R.id.button17);
        btn19 = (Button) findViewById(R.id.button19);

        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);
        btn14.setOnClickListener(this);
        btn15.setOnClickListener(this);
        btn16.setOnClickListener(this);
        btn17.setOnClickListener(this);
        btn19.setOnClickListener(this);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InteresesActivity.this, ConfigurationActivity.class);
                intent.putExtra("arreglo", listaInteres);
                startActivity(intent);
                Log.e("MyLog",listaInteres+"");
            }
        });





    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button3:


                if(a==0) {
                    btn3.setBackgroundResource(R.color.rosa);
                    listaInteres.add(btn3.getText().toString());
                    a=1;
                }else{
                    btn3.setBackgroundResource(R.color.negro);
                    listaInteres.remove(btn3.getText().toString());
                    a=0;
                }


                break;
            case R.id.button4:


                if(b==0) {
                    btn4.setBackgroundResource(R.color.rosa);
                    listaInteres.add(btn4.getText().toString());
                    b=1;
                }else{
                    btn4.setBackgroundResource(R.color.negro);
                    listaInteres.remove(btn4.getText().toString());
                    b=0;
                }

                break;
            case R.id.button5:

                if(c==0) {
                    btn5.setBackgroundResource(R.color.rosa);
                    listaInteres.add(btn5.getText().toString());
                    c=1;
                }else{
                    btn5.setBackgroundResource(R.color.negro);
                    listaInteres.remove(btn5.getText().toString());
                    c=0;
                }

                break;
            case R.id.button6:

                if(d==0) {
                    btn6.setBackgroundResource(R.color.rosa);
                    listaInteres.add(btn6.getText().toString());
                    d=1;
                }else{
                    btn6.setBackgroundResource(R.color.negro);
                    listaInteres.remove(btn6.getText().toString());
                    d=0;
                }

                break;
            case R.id.button7:

                if(e==0) {
                    btn7.setBackgroundResource(R.color.rosa);
                    listaInteres.add(btn7.getText().toString());
                    e=1;
                }else{
                    btn7.setBackgroundResource(R.color.negro);
                    listaInteres.remove(btn7.getText().toString());
                    e=0;
                }

                break;
            case R.id.button8:

                if(f==0) {
                    btn8.setBackgroundResource(R.color.rosa);
                    listaInteres.add(btn8.getText().toString());
                    f=1;
                }else{
                    btn8.setBackgroundResource(R.color.negro);
                    listaInteres.remove(btn8.getText().toString());
                    f=0;
                }

                break;

            case R.id.button9:


                if(g==0) {
                    btn9.setBackgroundResource(R.color.rosa);
                    listaInteres.add(btn9.getText().toString());
                    g=1;
                }else{
                    btn9.setBackgroundResource(R.color.negro);
                    listaInteres.remove(btn9.getText().toString());
                    g=0;
                }

                break;

            case R.id.button11:

                if(h==0) {
                    btn11.setBackgroundResource(R.color.rosa);
                    listaInteres.add(btn11.getText().toString());
                    h=1;
                }else{
                    btn11.setBackgroundResource(R.color.negro);
                    listaInteres.remove(btn11.getText().toString());
                    h=0;
                }

                break;
            case R.id.button12:

                if(i==0) {
                    btn12.setBackgroundResource(R.color.rosa);
                    listaInteres.add(btn12.getText().toString());
                    i=1;
                }else{
                    btn12.setBackgroundResource(R.color.negro);
                    listaInteres.remove(btn12.getText().toString());
                    i=0;
                }

                break;
            case R.id.button13:


                if(j==0) {
                    btn13.setBackgroundResource(R.color.rosa);
                    listaInteres.add(btn13.getText().toString());
                    j=1;
                }else{
                    btn13.setBackgroundResource(R.color.negro);
                    listaInteres.remove(btn13.getText().toString());
                    j=0;
                }



                break;
            case R.id.button14:


                if(k==0) {
                    btn14.setBackgroundResource(R.color.rosa);
                    listaInteres.add(btn14.getText().toString());
                    k=1;
                }else{
                    btn14.setBackgroundResource(R.color.negro);
                    listaInteres.remove(btn14.getText().toString());
                    k=0;
                }

                break;
            case R.id.button15:


                if(l==0) {
                    btn15.setBackgroundResource(R.color.rosa);
                    listaInteres.add(btn15.getText().toString());
                    l=1;
                }else{
                    btn15.setBackgroundResource(R.color.negro);
                    listaInteres.remove(btn15.getText().toString());
                    l=0;
                }

                break;
            case R.id.button16:


                if(m==0) {
                    btn16.setBackgroundResource(R.color.rosa);
                    listaInteres.add(btn16.getText().toString());
                    m=1;
                }else{
                    btn16.setBackgroundResource(R.color.negro);
                    listaInteres.remove(btn16.getText().toString());
                    m=0;
                }

                break;
            case R.id.button17:

                if(o==0) {
                    btn17.setBackgroundResource(R.color.rosa);
                    listaInteres.add(btn17.getText().toString());
                    o=1;
                }else{
                    btn17.setBackgroundResource(R.color.negro);
                    listaInteres.remove(btn17.getText().toString());
                    o=0;
                }

                break;
            case R.id.button19:

                if(p==0) {
                    btn19.setBackgroundResource(R.color.rosa);
                    listaInteres.add(btn19.getText().toString());
                    p=1;
                }else{
                    btn19.setBackgroundResource(R.color.negro);
                    listaInteres.remove(btn19.getText().toString());
                    p=0;
                }

                break;
        }
    }
}
