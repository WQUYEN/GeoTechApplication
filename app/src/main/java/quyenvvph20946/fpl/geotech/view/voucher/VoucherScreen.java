package quyenvvph20946.fpl.geotech.view.voucher;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;
import java.util.List;

import quyenvvph20946.fpl.geotech.adapter.VoucherSCAdapter;
import quyenvvph20946.fpl.geotech.databinding.LayoutVoucherBinding;
import quyenvvph20946.fpl.geotech.model.Voucher;

public class VoucherScreen extends AppCompatActivity {
    LayoutVoucherBinding binding;
    List<Voucher> list;
    VoucherSCAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = LayoutVoucherBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        list = new ArrayList<>();
        list.add(new Voucher("Miễn phí vận chuyển", "11" , "11", "12%"));
        list.add(new Voucher("Giảm 5% với đơn hàng trên 200k", "11" , "11", "5%"));
        list.add(new Voucher("Miễn phí vận chuyển", "11" , "11", "12%"));
        list.add(new Voucher("Giảm 5% với đơn hàng trên 100k", "11" , "11", "12%"));
        list.add(new Voucher("Giảm 5% với đơn hàng trên 100k", "11" , "11", "12%"));
        list.add(new Voucher("Miễn phí vận chuyển", "11" , "11", "12%"));
        list.add(new Voucher("Giảm 5% với đơn hàng trên 100k", "11" , "11", "12%"));
        adapter = new VoucherSCAdapter(this, list);
        binding.rcvVoucherStore.setAdapter(adapter);
    }
}