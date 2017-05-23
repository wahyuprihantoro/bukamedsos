package id.prihantoro.bukamedsos.api.response;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * Created by wahyu on 13 Mei 2017.
 */

public class LoginResponse extends BasicResponse {
    @SerializedName("user_id")
    public int userId;
    @SerializedName("user_name")
    public String userName;
    @SerializedName("confirmed")
    public boolean confirmed;
    @SerializedName("token")
    public String token;
    @SerializedName("email")
    public String email;
    @SerializedName("confirmed_phone")
    public String confirmedPhone;
    @SerializedName("omnikey")
    public String omnikey;
    @SerializedName("data")
    public Data data;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public class Data {
        @SerializedName("tfa_status")
        public boolean tfaStatus;
    }
}
