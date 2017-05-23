package id.prihantoro.bukamedsos.api;

import id.prihantoro.bukamedsos.api.response.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by wahyu on 13 Mei 2017.
 */

public interface LoginService {
    @POST("authenticate.json")
    Call<LoginResponse> login();
}
