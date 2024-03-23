
package quyenvvph20946.fpl.geotech.view.fragment.fragment_home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import quyenvvph20946.fpl.geotech.R;
import quyenvvph20946.fpl.geotech.adapter.ProductBestSellerAdapter;
import quyenvvph20946.fpl.geotech.api.BaseApi;
import quyenvvph20946.fpl.geotech.databinding.FragmentPageOutstandingBinding;
import quyenvvph20946.fpl.geotech.model.OptionProductBestSeller;
import quyenvvph20946.fpl.geotech.model.response.ProductBestSellerResponse;
import quyenvvph20946.fpl.geotech.ultil.AccountUltil;
import quyenvvph20946.fpl.geotech.ultil.ObjectUtil;
import quyenvvph20946.fpl.geotech.ultil.TAG;
import quyenvvph20946.fpl.geotech.view.product_screen.DetailProduct;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentPageOutstanding extends Fragment implements ObjectUtil {
    private List<OptionProductBestSeller> list;
    private ProductBestSellerAdapter adapter;
    private FragmentPageOutstandingBinding binding;

    public FragmentPageOutstanding() {
    }

    public static FragmentPageOutstanding newInstance(String param1, String param2) {
        FragmentPageOutstanding fragment = new FragmentPageOutstanding();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPageOutstandingBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list = new ArrayList<>();
        adapter = new ProductBestSellerAdapter(getContext(), list, this);
        binding.recyProBestSeller.setAdapter(adapter);
        callApiShowListProductBestSeller();
    }

    private void callApiShowListProductBestSeller() {
        binding.progressBar.setVisibility(View.VISIBLE);
        Log.d("user_id", AccountUltil.USER.getId());
        BaseApi.API.getTopProductBestSeller(AccountUltil.USER.getId()).enqueue(new Callback<ProductBestSellerResponse>() {
            @Override
            public void onResponse(Call<ProductBestSellerResponse> call, Response<ProductBestSellerResponse> response) {
                Log.d("getTopProductBestSeller: ", response+"");
                if (response.isSuccessful()) { // chỉ nhận đầu status 200
                    ProductBestSellerResponse reponse = response.body();
                    Log.d(TAG.toString, "onResponse-ListProductByCategory: " + reponse.toString());
                    if (reponse.getCode() == 200) {
                        adapter.setListProductBestSeller(reponse.getResult());
                        binding.recyProBestSeller.setAdapter(adapter);
                    }
                } else { // nhận các đầu status #200
                    try {
                        String errorBody = response.errorBody().string();
                        JSONObject errorJson = new JSONObject(errorBody);
                        String errorMessage = errorJson.getString("message");
                        Log.d(TAG.toString, "onResponse-register: " + errorMessage);
                        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
                    }catch (IOException e){
                        e.printStackTrace();
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
                binding.progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<ProductBestSellerResponse> call, Throwable t) {
                binding.progressBar.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onclickObject(Object object) {
        OptionProductBestSeller product = (OptionProductBestSeller) object;
        String id = product.getProductId().getId();
        Intent intent = new Intent(getActivity(), DetailProduct.class);
        intent.putExtra("id_product", id);
        getActivity().startActivity(intent);
        getActivity().overridePendingTransition(R.anim.slidle_in_left, R.anim.slidle_out_left);

    }
}