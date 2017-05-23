package id.prihantoro.bukamedsos.api.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import id.prihantoro.bukamedsos.model.Product;

/**
 * Created by wahyu on 23 Mei 2017.
 */

public class MyLapakResponse extends BasicResponse {

    @SerializedName("products")
    public List<Product> products = null;
    @SerializedName("can_push")
    public boolean canPush;
    @SerializedName("remaining_push")
    public int remainingPush;
    @SerializedName("labels")
    public List<Object> labels = null;
    @SerializedName("push_price")
    public int pushPrice;
    @SerializedName("deposit")
    public int deposit;
    @SerializedName("push_status")
    public String pushStatus;
    @SerializedName("active_until")
    public String activeUntil;
    @SerializedName("grace_period_until")
    public String gracePeriodUntil;
    @SerializedName("loan_info")
    public Product.LoanInfo loanInfo;
}
