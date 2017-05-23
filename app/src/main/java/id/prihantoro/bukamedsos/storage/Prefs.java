package id.prihantoro.bukamedsos.storage;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.sharedpreferences.Pref;


/**
 * Created by wahyu on 13 Maret 2017.
 */

@EBean(scope = EBean.Scope.Singleton)
public class Prefs {
    @Pref
    SharedPref_ sharedPref;

    public String getToken() {
        return sharedPref.token().get();
    }

    public void setToken(String token) {
        sharedPref.edit().token().put(token).apply();
    }

    public boolean isLogin() {
        return sharedPref.isLogin().get();
    }

    public void setLogin(boolean isLogin) {
        sharedPref.edit().isLogin().put(isLogin).apply();
    }

    public String getUsername() {
        return sharedPref.username().get();
    }

    public void setUsername(String username) {
        sharedPref.edit().username().put(username).apply();
    }

    public int getUserId() {
        return sharedPref.userId().get();
    }

    public void setUserId(int userId) {
        sharedPref.edit().userId().put(userId).apply();
    }

    public String getEmail() {
        return sharedPref.email().get();
    }

    public void setEmail(String email) {
        sharedPref.edit().email().put(email).apply();
    }
}
