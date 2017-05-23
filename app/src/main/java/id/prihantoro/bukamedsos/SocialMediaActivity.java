package id.prihantoro.bukamedsos;

import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.roughike.bottombar.BottomBar;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by wahyu on 23 Mei 2017.
 */

@EActivity(R.layout.activity_social_media)
public class SocialMediaActivity extends AppCompatActivity {
    @ViewById
    BottomBar bottomBar;
    @ViewById
    FrameLayout container;

    @AfterViews
    void init() {

    }
}
