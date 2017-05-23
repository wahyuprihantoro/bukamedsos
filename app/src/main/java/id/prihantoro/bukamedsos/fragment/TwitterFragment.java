package id.prihantoro.bukamedsos.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import id.prihantoro.bukamedsos.R;

/**
 * Created by wahyu on 23 Mei 2017.
 */

@EFragment(R.layout.fragment_twitter)
public class TwitterFragment extends Fragment {
    @ViewById
    TwitterLoginButton login;

    @AfterViews
    void init() {
        setupTwitter();
    }

    public void setupTwitter() {
        login.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                TwitterSession session = result.data;
                String msg = "@" + session.getUserName() + " logged in! (#" + session.getUserId() + ")";
                Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
            }

            @Override
            public void failure(TwitterException exception) {
                Log.d("TwitterKit", "Login with Twitter failure", exception);
            }
        });

        if (Twitter.getInstance().getSessionManager().getActiveSession() != null) {
            login.setVisibility(View.GONE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        login.onActivityResult(requestCode, resultCode, data);
    }


}
