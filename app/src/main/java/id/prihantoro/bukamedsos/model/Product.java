package id.prihantoro.bukamedsos.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by wahyu on 23 Mei 2017.
 */

public class Product {
    @SerializedName("deal_info")
    public DealInfo dealInfo;
    @SerializedName("deal_request_state")
    public String dealRequestState;
    @SerializedName("price")
    public int price;
    @SerializedName("category_id")
    public int categoryId;
    @SerializedName("category")
    public String category;
    @SerializedName("category_structure")
    public List<String> categoryStructure = null;
    @SerializedName("courier")
    public List<String> courier = null;
    @SerializedName("seller_username")
    public String sellerUsername;
    @SerializedName("seller_name")
    public String sellerName;
    @SerializedName("seller_id")
    public int sellerId;
    @SerializedName("seller_avatar")
    public String sellerAvatar;
    @SerializedName("seller_level")
    public String sellerLevel;
    @SerializedName("seller_level_badge_url")
    public String sellerLevelBadgeUrl;
    @SerializedName("seller_delivery_time")
    public Object sellerDeliveryTime;
    @SerializedName("seller_positive_feedback")
    public int sellerPositiveFeedback;
    @SerializedName("seller_negative_feedback")
    public int sellerNegativeFeedback;
    @SerializedName("seller_term_condition")
    public String sellerTermCondition;
    @SerializedName("seller_alert")
    public Object sellerAlert;
    @SerializedName("for_sale")
    public boolean forSale;
    @SerializedName("state_description")
    public List<Object> stateDescription = null;
    @SerializedName("premium_account")
    public boolean premiumAccount;
    @SerializedName("top_merchant")
    public boolean topMerchant;
    @SerializedName("last_order_schedule")
    public Object lastOrderSchedule;
    @SerializedName("seller_voucher")
    public SellerVoucher sellerVoucher;
    @SerializedName("waiting_payment")
    public int waitingPayment;
    @SerializedName("sold_count")
    public int soldCount;
    @SerializedName("specs")
    public Specs specs;
    @SerializedName("force_insurance")
    public boolean forceInsurance;
    @SerializedName("free_shipping_coverage")
    public List<Object> freeShippingCoverage = null;
    @SerializedName("id")
    public String id;
    @SerializedName("url")
    public String url;
    @SerializedName("name")
    public String name;
    @SerializedName("active")
    public boolean active;
    @SerializedName("city")
    public String city;
    @SerializedName("province")
    public String province;
    @SerializedName("weight")
    public int weight;
    @SerializedName("image_ids")
    public List<Integer> imageIds = null;
    @SerializedName("images")
    public List<String> images = null;
    @SerializedName("small_images")
    public List<String> smallImages = null;
    @SerializedName("desc")
    public String desc;
    @SerializedName("condition")
    public String condition;
    @SerializedName("stock")
    public int stock;
    @SerializedName("favorited")
    public boolean favorited;
    @SerializedName("created_at")
    public String createdAt;
    @SerializedName("updated_at")
    public String updatedAt;
    @SerializedName("product_sin")
    public List<Object> productSin = null;
    @SerializedName("rating")
    public Rating rating;
    @SerializedName("current_variant_name")
    public String currentVariantName;
    @SerializedName("current_product_sku_id")
    public int currentProductSkuId;
    @SerializedName("product_sku")
    public List<Object> productSku = null;
    @SerializedName("options")
    public List<Object> options = null;
    @SerializedName("interest_count")
    public int interestCount;
    @SerializedName("last_relist_at")
    public String lastRelistAt;
    @SerializedName("view_count")
    public int viewCount;
    @SerializedName("installment")
    public List<Installment> installment = null;
    @SerializedName("min_installment_price")
    public String minInstallmentPrice;

    public int likes;
    public int comments;
    public boolean postedToInstagram;
    public boolean postedToPinterest;
    public boolean postedToFacebook;
    public boolean postedToTwitter;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public class Rating {

        @SerializedName("average_rate")
        public int averageRate;
        @SerializedName("user_count")
        public int userCount;

    }

    public class SellerVoucher {

    }

    public class Specs {
        @SerializedName("type")
        public String type;
        @SerializedName("brand")
        public String brand;

    }


    public class LoanInfo {
        @SerializedName("eligible")
        public boolean eligible;
        @SerializedName("limit")
        public int limit;
        @SerializedName("remaining")
        public int remaining;

    }

    public class Installment {
        @SerializedName("bank_issuer")
        public String bankIssuer;
        @SerializedName("terms")
        public List<Integer> terms = null;
        @SerializedName("bank_issuer_name")
        public String bankIssuerName;
        @SerializedName("bank_acquirer")
        public String bankAcquirer;
        @SerializedName("url_logo")
        public String urlLogo;

    }

    public class DealInfo {

    }
}
