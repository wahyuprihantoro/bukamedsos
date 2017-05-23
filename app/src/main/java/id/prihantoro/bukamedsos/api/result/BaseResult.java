package id.prihantoro.bukamedsos.api.result;

/**
 * Created by wahyu on 14 Maret 2017.
 */

public class BaseResult<T> {
    public T response;
    public int resultCode;
    public String message;
    public boolean status;
}
