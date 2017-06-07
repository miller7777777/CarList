package android2.levelup.ru.carlist.Entity;

//Класс описывает сущность: машину


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Car {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("vin")
    @Expose
    private String vin;

    public Car(String name, String image, String vin) {
        this.name = name;
        this.image = image;
        this.vin = vin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
