package brandon.example.com.locking;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import brandon.example.com.locking.api.ServiceGenerator;
import brandon.example.com.locking.api.ServicesInterface;
import brandon.example.com.locking.models.Ejemplo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DesitionActivity extends AppCompatActivity {

    private TextView textview, textview2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desition);

        Bundle bundle = getIntent().getExtras();
        final ArrayList<String> lista = bundle.getStringArrayList("arreglo");
        final String costo = bundle.getString("costo");
        final String distancia = bundle.getString("distancia");

        StringBuilder categorias = new StringBuilder();
        for (int i = 0; i < lista.size(); i++) {


            if(i<lista.size()-1){
                categorias.append(lista.get(i));
                categorias.append(", ");
            }else{
                categorias.append(lista.get(i));
            }

        }

        Log.e("MYLOGARREGLO",categorias+"");
        Log.e("COSTO",costo+"");
        Log.e("DISTANCIA",distancia+"");

        textview = (TextView) findViewById(R.id.textViewDirection);
        textview2 = (TextView) findViewById(R.id.textView26);

        loadDataSingleton(costo,distancia,categorias);


    }

    public void loadDataSingleton(final String costo, final String distancia, final StringBuilder categorias){
        ServicesInterface servicesInterface = ServiceGenerator.createService();
        servicesInterface.getUserIntoPath(costo,distancia,categorias).enqueue(new Callback<Ejemplo>() {

            @Override
            public void onResponse(Call<Ejemplo> call, Response<Ejemplo> response) {
                String name = response.body().getName();
                String adress = response.body().getVenue();

                Log.e("MYLOGARREGLO",categorias+"");
                Log.e("COSTO",costo+"");
                Log.e("DISTANCIA",distancia+"");

                Log.e("Mylog",name+"");

                textview.setText(name);
                textview2.setText(adress);



            }

            @Override
            public void onFailure(Call<Ejemplo> call, Throwable t) {
                textview.setText("No Lucky, try again :(");

            }
        });
//        servicesInterface.loadData().enqueue(new Callback<Ejemplo>() { //loaddata esta en mi interfaz
//            @Override
//            public void onResponse(Call<Ejemplo> call, Response<Ejemplo> response) {
//                String name = response.body().getName();
//                Log.e("MyLOGubi",name);
//
//               /* for (int i = 0; i <response.body().size() ; i++) {
//                    //String title= response.body().get(i).getTitle();
//                    //Log.e("MyLOG",title+"");
//                }*/
//            }
//
//            @Override
//            public void onFailure(Call<Ejemplo> call, Throwable t) {
//
//            }
//        });
    }




}
