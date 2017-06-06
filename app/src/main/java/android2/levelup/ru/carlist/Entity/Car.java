package android2.levelup.ru.carlist.Entity;

//Класс описывает сущность: машину


public class Car {

    private String name;
    private String imageURL;
    private String vin;

    public Car(String name, String imageURL, String vin) {
        this.name = name;
        this.imageURL = imageURL;
        this.vin = vin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
