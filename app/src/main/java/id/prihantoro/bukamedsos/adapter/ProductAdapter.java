package id.prihantoro.bukamedsos.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import id.prihantoro.bukamedsos.R;
import id.prihantoro.bukamedsos.model.Product;
import id.prihantoro.bukamedsos.util.Utils;

/**
 * Created by wahyu on 23 Mei 2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    Context context;
    List<Product> products;

    public ProductAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_product_item, parent, false);
        return new ProductViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Product p = products.get(position);
        holder.name.setText(p.name.length() > 50 ? p.name.substring(0, 47) + "..." : p.name);
        holder.price.setText(Utils.toRupiahFormat(p.price + ""));
        holder.likes.setText(p.likes + " like" + (p.likes > 0 ? "s" : ""));
        holder.comments.setText(p.comments + " comment" + (p.comments > 0 ? "s" : ""));
        Glide.with(context).load(p.images.get(0)).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        public ImageView image, instagram, facebook, pinterest, twitter;
        public TextView name, price, likes, comments;

        public ProductViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            instagram = (ImageView) itemView.findViewById(R.id.instagram);
            facebook = (ImageView) itemView.findViewById(R.id.facebook);
            pinterest = (ImageView) itemView.findViewById(R.id.pinterest);
            twitter = (ImageView) itemView.findViewById(R.id.twitter);
            name = (TextView) itemView.findViewById(R.id.name);
            price = (TextView) itemView.findViewById(R.id.price);
            likes = (TextView) itemView.findViewById(R.id.likes);
            comments = (TextView) itemView.findViewById(R.id.comments);
        }
    }
}
