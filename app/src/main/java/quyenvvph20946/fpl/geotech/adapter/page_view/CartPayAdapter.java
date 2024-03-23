package quyenvvph20946.fpl.geotech.adapter.page_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


import java.text.DecimalFormat;
import java.util.List;

import quyenvvph20946.fpl.geotech.databinding.LayoutItemCartPayBinding;
import quyenvvph20946.fpl.geotech.model.OptionAndQuantity;

public class CartPayAdapter extends RecyclerView.Adapter<CartPayAdapter.CartPayViewHolder> {
    private Context context;
    private List<OptionAndQuantity> cartList;

    public CartPayAdapter(Context context, List<OptionAndQuantity> cartList) {
        this.cartList = cartList;
        this.context = context;
    }


    public void setCartList(List<OptionAndQuantity> cartList) {
        this.cartList = cartList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CartPayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutItemCartPayBinding binding = LayoutItemCartPayBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CartPayViewHolder(binding);
    }
    @Override
    public int getItemCount() {
        if(cartList != null){
            return  cartList.size();
        }
        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull CartPayViewHolder holder, int position) {
        OptionAndQuantity cart = cartList.get(position);
        holder.binding.tvProductName.setText(cart.getOptionProduct().getProduct().getName() + "");
        holder.binding.tvNameColor.setText("Phân loại: " + cart.getOptionProduct().getNameColor());
        holder.binding.tvQuantity.setText("Số lương: x" + cart.getQuantity());
        DecimalFormat df = new DecimalFormat("###,###,###");
        holder.binding.tvPrice.setText(df.format(cart.getOptionProduct().getPrice()) + " đ");
        Glide.with(context).load(cart.getOptionProduct().getImage()).into(holder.binding.imgProduct);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public class CartPayViewHolder extends RecyclerView.ViewHolder {
        private LayoutItemCartPayBinding binding;
        public CartPayViewHolder(LayoutItemCartPayBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
