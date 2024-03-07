package quyenvvph20946.fpl.geoteachapplication.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.adapters.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import quyenvvph20946.fpl.geoteachapplication.R;
import quyenvvph20946.fpl.geoteachapplication.databinding.FragmentHomeBinding;
import quyenvvph20946.fpl.geoteachapplication.view.adapter.ViewPagerHomeAdapter;
import quyenvvph20946.fpl.geoteachapplication.view.view.cart.CartActivity;

public class FragmentHome extends Fragment {

    private FragmentHomeBinding binding;
    private ViewPagerHomeAdapter viewPagerHomeAdapter;

    public FragmentHome() {

    }

    // TODO: Rename and change types and number of parameters
    public static FragmentHome newInstance() {
        FragmentHome fragment = new FragmentHome();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        setTab();
        initController();
    }

    private void setTab() {
        viewPagerHomeAdapter = new ViewPagerHomeAdapter(getActivity());
        binding.viewPagerHome.setAdapter(viewPagerHomeAdapter);

        TabLayoutMediator mediator = new TabLayoutMediator(binding.tabHome, binding.viewPagerHome, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("Sản phẩm");
                        break;
                    case 1:
                        tab.setText("Giảm giá");
                        break;
                    case 2:
                        tab.setText("Bán chạy");
                        break;
                    default:
                        tab.setText("Liên quan");
                }
            }
        });
        mediator.attach();
    }

    private void initController() {
        binding.imgCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CartActivity.class);
                
            }
        });
    }
}