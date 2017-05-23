package id.prihantoro.bukamedsos;

import android.content.res.ColorStateList;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.FocusChange;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.ColorRes;
import org.greenrobot.eventbus.Subscribe;

import id.prihantoro.bukamedsos.api.LoginService;
import id.prihantoro.bukamedsos.api.Retrofit;
import id.prihantoro.bukamedsos.api.response.LoginResponse;
import id.prihantoro.bukamedsos.api.result.LoginResult;
import id.prihantoro.bukamedsos.storage.Prefs;

/**
 * Created by wahyu on 06 Mei 2017.
 */

@EActivity(R.layout.activity_login)
public class LoginActivity extends BaseActivity {

    @ViewById(R.id.username_form)
    TextView usernameForm;
    @ViewById(R.id.password_form)
    TextView passwordForm;

    @ViewById
    EditText username;
    @ViewById
    EditText password;

    @Bean
    Retrofit retrofit;
    @Bean
    Prefs prefs;

    @ColorRes
    int black;
    ColorStateList oldColorTextView;

    @AfterViews
    void init() {
        oldColorTextView = usernameForm.getTextColors();
    }

    @FocusChange(R.id.username)
    public void usernameFocusChange(View ignored, boolean hasFocus) {
        if (hasFocus) {
            usernameForm.setTextColor(black);
        } else {
            usernameForm.setTextColor(oldColorTextView);
        }
    }

    @FocusChange(R.id.password)
    public void passwordFocusChange(View ignored, boolean hasFocus) {
        if (hasFocus) {
            passwordForm.setTextColor(black);
        } else {
            passwordForm.setTextColor(oldColorTextView);
        }
    }

    @Click
    public void login() {
        String username = this.username.getText().toString();
        String password = this.password.getText().toString();
        retrofit.getServiceBasicAuth(LoginService.class, username, password).login().enqueue(retrofit.getCallback(new LoginResult()));
    }

    @Subscribe
    public void onLoginResult(LoginResult result) {
        if (result.status) {
            if (result.response != null && result.response.isOk()) {
                LoginResponse response = result.response;
                prefs.setToken(response.token);
                prefs.setLogin(true);
                prefs.setEmail(response.email);
                prefs.setUsername(response.userName);
                prefs.setUserId(response.userId);

                HomeActivity_.intent(this).start();

                Log.d("wahyu", result.response.toString());
            } else if (result.response != null && !result.response.isOk()) {
                Log.d("wahyu", result.response.message);
            } else {
                Log.d("wahyu", "terjadi kesalahan");
            }
        } else {
            Log.d("wahyu", result.message);
        }
    }
}
