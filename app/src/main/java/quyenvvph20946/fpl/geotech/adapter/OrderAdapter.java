package quyenvvph20946.fpl.geotech.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.hn_2025_online_shop.databinding.LayoutItemOrderBinding;
//import com.example.hn_2025_online_shop.model.Order;
//import com.example.hn_2025_online_shop.ultil.ObjectUtil;

import java.text.DecimalFormat;
import java.util.List;

import quyenvvph20946.fpl.geotech.databinding.LayoutItemOrderBinding;
import quyenvvph20946.fpl.geotech.model.OptionAndQuantity;
import quyenvvph20946.fpl.geotech.model.Order;
import quyenvvph20946.fpl.geotech.ultil.ObjectUtil;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    private List<Order> orderList;
    private Context context;
    private ObjectUtil objectUtil;
    private int status = 0; // 1, 2, 3, 4, 5 ứng với thứ tự hiển thị trên tab
    private int maxVisibleItems = 2; // Số lượng sản phẩm hiển thị ban đầu

    private boolean isExpanded = false;//Lưu trữ trạng thái hiện tại của danh sách
    public OrderAdapter(Context context, List<Order> orderList, ObjectUtil objectUtil, int status) {
        this.context = context;
        this.orderList = orderList;
        this.objectUtil = objectUtil;
        this.status = status;
    }

    public void setListOrder(List<Order> orderList) {
        this.orderList = orderList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutItemOrderBinding binding = LayoutItemOrderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new OrderViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        Order order = orderList.get(position);
        holder.binding.tvOrderId.setText("Đơn hàng: " + order.getId());
        DecimalFormat df = new DecimalFormat("###,###,###");
        holder.binding.tvTotalPrice.setText(df.format(order.getTotalPrice()) + "");
        holder.binding.tvStatus.setText(order.getStatus());
        holder.binding.tvQuantityTypeProduct.setText(order.getProductsOrder().size() + " loại sản phẩm");
        if (status == 1) {
            holder.binding.btnItem.setText("Hủy hàng");
            int color = Color.parseColor("#FFCC00");
            holder.binding.tvStatus.setTextColor(color);
        } else if (status == 2) {
            holder.binding.btnItem.setVisibility(View.GONE);
        } else if (status == 3) {
            holder.binding.btnItem.setVisibility(View.GONE);
        } else if (status == 4) {
            holder.binding.btnItem.setText("Mua lại");
        } else if (status == 5) {
            holder.binding.btnItem.setText("Mua lại");
            holder.binding.tvStatus.setTextColor(Color.GRAY);
        }

        holder.binding.btnItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objectUtil.onclickObject(order);
            }
        });

        // Kiểm tra xem danh sách có nhiều hơn số lượng hiển thị ban đầu hay không

        if (order.getProductsOrder().size() > maxVisibleItems && !isExpanded) {
            // Hiển thị chỉ 2 mục đầu tiên
            setRcvProduct(holder.binding, order, maxVisibleItems);

            holder.binding.tvSeeMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Đảo ngược trạng thái isExpanded
                    isExpanded = !isExpanded;
                    Log.d("Expanded status", "onClick Seemore: " + isExpanded);
                    // Hiển thị toàn bộ danh sách sản phẩm nếu isExpanded là true, ngược lại hiển thị chỉ 2 mục đầu tiên
                    if (!isExpanded) {
                        setRcvProduct(holder.binding, order, order.getProductsOrder().size());
                        holder.binding.tvSeeMore.setText("Thu gọn");


                    } else {
//                        setRcvProduct(holder.binding, order, maxVisibleItems);
//                        holder.binding.tvSeeMore.setText("Xem thêm");
                        setRcvProduct(holder.binding, order, maxVisibleItems);
                        holder.binding.tvSeeMore.setText("Xem thêm");

                    }
                    // Cập nhật giao diện
                    // notifyItemChanged(holder.getAdapterPosition());
                }
            });
        } else {
            //Ds sản phẩm <2 hiển thị toàn bộ sản phẩm và ẩn nút xem thêm
            holder.binding.tvSeeMore.setVisibility(View.GONE);
            setRcvProduct(holder.binding, order, order.getProductsOrder().size());
        }
    }

    private void setRcvProduct(LayoutItemOrderBinding binding, Order order, int maxVisibleItems) {
        List<OptionAndQuantity> productList = order.getProductsOrder();
        List<OptionAndQuantity> visibleProducts = productList.subList(0, Math.min(productList.size(), maxVisibleItems));

        OrderProductAdapter orderProductAdapter = new OrderProductAdapter(context, visibleProducts);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        binding.rcvOrderDetail.setLayoutManager(layoutManager);
        binding.rcvOrderDetail.setAdapter(orderProductAdapter);
    }

    @Override
    public int getItemCount() {
        if (orderList != null) {
            return orderList.size();
        }
        return 0;
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder {
        LayoutItemOrderBinding binding;

        public OrderViewHolder(LayoutItemOrderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
