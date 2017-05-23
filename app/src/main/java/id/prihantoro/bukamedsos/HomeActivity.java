package id.prihantoro.bukamedsos;

import android.util.Log;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.greenrobot.eventbus.Subscribe;

import id.prihantoro.bukamedsos.api.Retrofit;
import id.prihantoro.bukamedsos.api.eventbusresult.MyLapakResult;
import id.prihantoro.bukamedsos.api.service.ProductService;
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
        retrofit.getGeneralService(ProductService.class).getMyLapak().enqueue(retrofit.getCallback(new MyLapakResult()));
    }

    @Subscribe
    public void onMyLapakResult(MyLapakResult result) {
        Toast.makeText(this, "" + result.response.isOk(), Toast.LENGTH_SHORT).show();
        Log.d("wahyu produk", result.response.products.get(0).toString());
    }
}
