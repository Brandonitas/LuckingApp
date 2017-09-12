package brandon.example.com.locking.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by brandon on 03/08/17.
 */

public class ServiceGenerator {
    private static Retrofit retrofit;

    private static Retrofit.Builder builder=
            new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://www.lucking.mx");

    public static ServicesInterface createService(){
        if(retrofit==null){
            retrofit = builder.build();
        }
        return retrofit.create(ServicesInterface.class);
    }
}

