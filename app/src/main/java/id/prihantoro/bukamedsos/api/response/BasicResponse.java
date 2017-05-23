package id.prihantoro.bukamedsos.api.response;

/**
 * Created by wahyu on 13 Mei 2017.
 */

public class BasicResponse {
    public String status;
    public String message;

    public boolean isOk() {
        return status != null && status.equalsIgnoreCase("ok");
    }
}
