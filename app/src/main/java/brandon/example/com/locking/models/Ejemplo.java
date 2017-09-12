package brandon.example.com.locking.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by brandon on 03/08/17.
 */

public class Ejemplo {


    @SerializedName("name")
    private String name;

    @SerializedName("venue")
    private String venue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }
}
