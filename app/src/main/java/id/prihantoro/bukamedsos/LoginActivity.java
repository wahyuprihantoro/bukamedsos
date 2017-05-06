package id.prihantoro.bukamedsos;

import android.content.res.ColorStateList;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.FocusChange;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.ColorRes;

/**
 * Created by wahyu on 06 Mei 2017.
 */

@EActivity(R.layout.activity_login)
public class LoginActivity extends AppCompatActivity {

    @ViewById(R.id.username_form)
    TextView usernameForm;
    @ViewById(R.id.password_form)
    TextView passwordForm;

    @ViewById
    EditText username;
    @ViewById
    EditText password;

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

}
