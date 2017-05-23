package id.prihantoro.bukamedsos;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.Subscribe;

import id.prihantoro.bukamedsos.adapter.ProductAdapter;
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
    @ViewById
    RecyclerView rv;

    ProductAdapter adapter;

    @AfterViews
    void init() {
        retrofit.getGeneralService(ProductService.class).getMyLapak().enqueue(retrofit.getCallback(new MyLapakResult()));
    }

    @Subscribe
    public void onMyLapakResult(MyLapakResult result) {
        if (result.status) {
            if (result.response.isOk()) {
                adapter = new ProductAdapter(this, result.response.products);
                rv.setLayoutManager(new LinearLayoutManager(this));
                rv.setAdapter(adapter);
            }
        }
    }
}
