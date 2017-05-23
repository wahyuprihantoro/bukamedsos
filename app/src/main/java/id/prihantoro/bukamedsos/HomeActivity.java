package id.prihantoro.bukamedsos;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;

import id.prihantoro.bukamedsos.api.Retrofit;
import id.prihantoro.bukamedsos.storage.Prefs;

/**
 * Created by wahyu on 13 Mei 2017.
 */

@EActivity(R.layout.activity_home)
public class HomeActivity extends BaseActivity {
    @Bean
    Prefs prefs;
    @Bean
    Retrofit retrofit;

    @AfterViews
    void init() {

    }
}
