package android2.levelup.ru.carlist.RetrofitUtils;


import android2.levelup.ru.carlist.Entity.CarList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("1tW53X")
    public Call<CarList> getCars();
}
