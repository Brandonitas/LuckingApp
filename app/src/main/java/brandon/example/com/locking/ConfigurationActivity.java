package brandon.example.com.locking;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import java.util.ArrayList;

public class ConfigurationActivity extends AppCompatActivity {

    private SeekBar seekBar, seekBar2;
    private TextView tv13, tv14, tv15, tv16, tv17, tv18, tv19, tv20, tv21;
    private Button button;
    private String costo, distancia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        Bundle bundle = getIntent().getExtras();
        final ArrayList<String> lista = bundle.getStringArrayList("arreglo");

        button = (Button) findViewById(R.id.buttonNext3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfigurationActivity.this, DesitionActivity.class);
                intent.putExtra("arreglo", lista);
                intent.putExtra("costo",costo);
                intent.putExtra("distancia",distancia);
                startActivity(intent);
                costo="1";
                distancia="1000";
                tv13.setTextColor(Color.GREEN);
                tv17.setTextColor(Color.YELLOW);
            }
        });





        tv13 = (TextView) findViewById(R.id.textView13);
        tv14 = (TextView) findViewById(R.id.textView14);
        tv15 = (TextView) findViewById(R.id.textView15);
        tv16 = (TextView) findViewById(R.id.textView16);

        seekBar = (SeekBar) findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            int seekBarProgress = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                seekBarProgress = progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                tv13.setTextColor(Color.GRAY);
                tv14.setTextColor(Color.GRAY);
                tv15.setTextColor(Color.GRAY);
                tv16.setTextColor(Color.GRAY);



            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(seekBarProgress==0){

                    tv13.setTextColor(Color.GREEN);
                    costo = "1";


                }else if(seekBarProgress==1){
                    tv14.setTextColor(Color.GREEN);
                    costo = "2";



                }else if(seekBarProgress==2){
                    tv15.setTextColor(Color.GREEN);
                    costo = "3";



                }else if(seekBarProgress==3) {
                    tv16.setTextColor(Color.GREEN);
                    costo = "4";


                }



            }

        });





        //Segundo SeekBar

        tv17 = (TextView) findViewById(R.id.textView17);
        tv18 = (TextView) findViewById(R.id.textView18);
        tv19 = (TextView) findViewById(R.id.textView19);
        tv20 = (TextView) findViewById(R.id.textView20);
        tv21 = (TextView) findViewById(R.id.textView21);

        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);

        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            int seekBarProgress = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                seekBarProgress = progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                tv17.setTextColor(Color.GRAY);
                tv18.setTextColor(Color.GRAY);
                tv19.setTextColor(Color.GRAY);
                tv20.setTextColor(Color.GRAY);
                tv21.setTextColor(Color.GRAY);



            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(seekBarProgress==0){

                    tv17.setTextColor(Color.YELLOW);
                    distancia = "1000";


                }else if(seekBarProgress==1){
                    tv18.setTextColor(Color.YELLOW);
                    distancia = "2000";



                }else if(seekBarProgress==2){
                    tv19.setTextColor(Color.YELLOW);
                    distancia = "3000";



                }else if(seekBarProgress==3) {
                    tv20.setTextColor(Color.YELLOW);

                    distancia = "4000";

                }else if(seekBarProgress==4){
                    tv21.setTextColor(Color.YELLOW);
                    distancia = "5000";

                }



            }

        });





    }
}
