package quyenvvph20946.fpl.geotech.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import quyenvvph20946.fpl.geotech.R;
import quyenvvph20946.fpl.geotech.databinding.LayoutItemProductSaleBinding;
import quyenvvph20946.fpl.geotech.model.Product;
import quyenvvph20946.fpl.geotech.ultil.ObjectUtil;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ProductSaleAdapter extends RecyclerView.Adapter<ProductSaleAdapter.ProductViewHolder> {
    private Context context;
    private List<Product> productList;
    private List<Product> filteredItems;
    private ObjectUtil objectUtil;

    public ProductSaleAdapter(Context context, List<Product> productList, ObjectUtil objectUtil) {
        this.productList = productList;
        this.context = context;
        this.objectUtil = objectUtil;
    }

    public void setListProductSale(List<Product> productList) {
        this.productList = productList;
        this.filteredItems = new ArrayList<>(productList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutItemProductSaleBinding binding = LayoutItemProductSaleBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ProductViewHolder(binding);
    }
    @Override
    public int getItemCount() {
        if(productList != null){
            return  productList.size();
        }
        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.binding.tvName.setText(product.getName());
        DecimalFormat df = new DecimalFormat("###,###,###");
        holder.binding.tvPrice.setText(df.format(product.getMinPrice()) + " đ");
        Glide.with(context)
                .load(product.getImage())
                .placeholder(R.drawable.loading)
                .error(R.drawable.error)
                .into(holder.binding.imgProduct);
        holder.binding.ratingBar.setRating((float) product.getAverageRate());
        try {
            holder.binding.tvReview.setText("Đã bán " + product.getSoldQuantity());
        } catch (Exception exception) {
            holder.binding.tvReview.setText("Đã bán " + 0);
        }
        holder.binding.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objectUtil.onclickObject(product);
            }
        });
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        private LayoutItemProductSaleBinding binding;
        public ProductViewHolder(LayoutItemProductSaleBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


    @SuppressLint("NotifyDataSetChanged")
    public void filterItem(String query) {
        productList.clear();
        if (query.isEmpty()) {
            productList.addAll(filteredItems);

        } else {
            for (Product item : filteredItems) {
                if (item.getName().toLowerCase().contains(query.toLowerCase())) {
                    productList.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }
}

