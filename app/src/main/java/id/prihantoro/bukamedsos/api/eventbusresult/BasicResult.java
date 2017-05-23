package id.prihantoro.bukamedsos.api.eventbusresult;

/**
 * Created by wahyu on 14 Maret 2017.
 */

public class BasicResult<T> {
    public T response;
    public int resultCode;
    public String message;
    public boolean status;
}
