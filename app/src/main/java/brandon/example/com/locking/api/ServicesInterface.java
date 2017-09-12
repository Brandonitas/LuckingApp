package brandon.example.com.locking.api;

import java.util.ArrayList;
import java.util.List;

import brandon.example.com.locking.models.Ejemplo;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by brandon on 03/08/17.
 */

public interface ServicesInterface {


    @GET("/places?") //URI
    Call<Ejemplo> getUserIntoPath(@Query("cost") String cost, @Query("distance") String distance, @Query("categories") StringBuilder categories);//guardo el valor en userName

//    @GET("/news")
//    Call<Ejemplo> getNews(
//            @Query("page") int page,
//            @Query("order") String order,
//            @Query("author") String author,
//
//    );

    //Call<Ejemplo> loadData();//Ya no llama al ResponseBody porque traee tooooodo, por eso llama al modelo Ejemplo y está en una LISTA List<>
    //LO QUE DEVUELVE






    //QUERY PETICION DE GOOGLE
    //PATH GITHUB PASO USERNAME
    //ESPOSED

}
