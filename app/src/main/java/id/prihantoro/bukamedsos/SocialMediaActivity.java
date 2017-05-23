package id.prihantoro.bukamedsos;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import id.prihantoro.bukamedsos.fragment.TwitterFragment_;
import io.fabric.sdk.android.Fabric;

import static id.prihantoro.bukamedsos.util.Keys.TWITTER_KEY;
import static id.prihantoro.bukamedsos.util.Keys.TWITTER_SECRET;

/**
 * Created by wahyu on 23 Mei 2017.
 */

@EActivity(R.layout.activity_social_media)
public class SocialMediaActivity extends AppCompatActivity {
    @ViewById
    BottomBar bottomBar;
    @ViewById
    FrameLayout container;
    Fragment fragment;

    @AfterViews
    void init() {
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_twitter) {
                    fragment = TwitterFragment_.builder().build();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.add(R.id.container, fragment);
                    transaction.commit();
                }
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        fragment.onActivityResult(requestCode, resultCode, data);
    }
}
