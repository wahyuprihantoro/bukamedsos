package id.prihantoro.bukamedsos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.EActivity;

/**
 * Created by wahyu on 06 Mei 2017.
 */

@EActivity
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity_.intent(this).start();
    }
}
