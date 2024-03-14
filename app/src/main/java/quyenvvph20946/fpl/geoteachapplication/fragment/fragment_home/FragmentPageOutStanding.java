package quyenvvph20946.fpl.geoteachapplication.fragment.fragment_home;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import quyenvvph20946.fpl.geoteachapplication.R;
import quyenvvph20946.fpl.geoteachapplication.adapter.ProductBestSellerAdapter;
import quyenvvph20946.fpl.geoteachapplication.api.BaseApi;
import quyenvvph20946.fpl.geoteachapplication.databinding.FragmentPageOutStandingBinding;
import quyenvvph20946.fpl.geoteachapplication.model.OptionProductBestSeller;
import quyenvvph20946.fpl.geoteachapplication.model.response.ProductBestSellerResponse;
import quyenvvph20946.fpl.geoteachapplication.ultil.AccountUltil;
import quyenvvph20946.fpl.geoteachapplication.ultil.ObjectUtil;
import quyenvvph20946.fpl.geoteachapplication.ultil.TAG;
import quyenvvph20946.fpl.geoteachapplication.view.product_screen.DetailProduct;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentPageOutStanding extends Fragment implements ObjectUtil {
    private List<OptionProductBestSeller> list;
    private ProductBestSellerAdapter adapter;
    private FragmentPageOutStandingBinding binding;


    public FragmentPageOutStanding() {

    }

    public static FragmentPageOutStanding newInstance() {
        FragmentPageOutStanding fragment = new FragmentPageOutStanding();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPageOutStandingBinding.inflate(getLayoutInflater());
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
        getActivity().overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
}