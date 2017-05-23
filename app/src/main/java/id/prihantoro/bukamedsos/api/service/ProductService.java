package id.prihantoro.bukamedsos.api.service;

import id.prihantoro.bukamedsos.api.response.MyLapakResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by wahyu on 23 Mei 2017.
 */

public interface ProductService {

    @GET("products/mylapak.json")
    Call<MyLapakResponse> getMyLapak();
}
