package quyenvvph20946.fpl.geotech.view.my_store;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.hn_2025_online_shop.databinding.FragmentWarehouseBinding;


public class FragmentWarehouse extends Fragment {

    private FragmentWarehouseBinding binding;


    public FragmentWarehouse() {
        // Required empty public constructor
    }


    public static FragmentWarehouse newInstance() {
        FragmentWarehouse fragment = new FragmentWarehouse();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWarehouseBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }
}