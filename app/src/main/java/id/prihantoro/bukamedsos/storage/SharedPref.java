package id.prihantoro.bukamedsos.storage;

import org.androidannotations.annotations.sharedpreferences.DefaultBoolean;
import org.androidannotations.annotations.sharedpreferences.DefaultInt;
import org.androidannotations.annotations.sharedpreferences.DefaultString;

/**
 * Created by wahyu on 13 Maret 2017.
 */

@org.androidannotations.annotations.sharedpreferences.SharedPref
public interface SharedPref {

    @DefaultBoolean(false)
    boolean isLogin();

    @DefaultString("")
    String token();

    @DefaultInt(-1)
    int userId();

    @DefaultString("")
    String username();

    @DefaultString("")
    String email();

}
