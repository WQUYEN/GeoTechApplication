package quyenvvph20946.fpl.geoteachapplication.view.fragment.fragment_home;



import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import quyenvvph20946.fpl.geoteachapplication.R;
import quyenvvph20946.fpl.geoteachapplication.adapter.CityAdapter;
import quyenvvph20946.fpl.geoteachapplication.adapter.DistrictAdapter;
import quyenvvph20946.fpl.geoteachapplication.adapter.WardAdapter;
import quyenvvph20946.fpl.geoteachapplication.api.BaseApi;
import quyenvvph20946.fpl.geoteachapplication.api.PositionApi;
import quyenvvph20946.fpl.geoteachapplication.databinding.ActivityPayBinding;
import quyenvvph20946.fpl.geoteachapplication.databinding.DialogDeleteAddressBinding;
import quyenvvph20946.fpl.geoteachapplication.databinding.FragmentFragementPageSellingBinding;
import quyenvvph20946.fpl.geoteachapplication.databinding.LayoutEditAddressBinding;
import quyenvvph20946.fpl.geoteachapplication.model.City;
import quyenvvph20946.fpl.geoteachapplication.model.District;
import quyenvvph20946.fpl.geoteachapplication.model.Info;
import quyenvvph20946.fpl.geoteachapplication.model.OptionAndQuantity;
import quyenvvph20946.fpl.geoteachapplication.model.Product;
import quyenvvph20946.fpl.geoteachapplication.model.ProductByCategory;
import quyenvvph20946.fpl.geoteachapplication.model.Ward;
import quyenvvph20946.fpl.geoteachapplication.model.body.PurchaseBody;
import quyenvvph20946.fpl.geoteachapplication.model.response.CityResponse;
import quyenvvph20946.fpl.geoteachapplication.model.response.DistrictResponse;
import quyenvvph20946.fpl.geoteachapplication.model.response.InfoResponse;
import quyenvvph20946.fpl.geoteachapplication.model.response.ProductByCategoryReponse;
import quyenvvph20946.fpl.geoteachapplication.model.response.ServerResponse;
import quyenvvph20946.fpl.geoteachapplication.model.response.WardResponse;
import quyenvvph20946.fpl.geoteachapplication.ultil.AccountUltil;
import quyenvvph20946.fpl.geoteachapplication.ultil.CartUtil;
import quyenvvph20946.fpl.geoteachapplication.ultil.ObjectUtil;
import quyenvvph20946.fpl.geoteachapplication.ultil.ProgressLoadingDialog;
import quyenvvph20946.fpl.geoteachapplication.ultil.TAG;
import quyenvvph20946.fpl.geoteachapplication.view.success_screen.OrderSuccessActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FragementPageSelling extends Fragment implements ObjectUtil {

    private ProductByCategoryAdapter productAdapter;
    private List<ProductByCategory> productList;
    private FragmentFragementPageSellingBinding binding;

    public FragementPageSelling() {
        // Required empty public constructor
    }

    public static FragementPageSelling newInstance(String param1, String param2) {
        FragementPageSelling fragment = new FragementPageSelling();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFragementPageSellingBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initController();
        callApiProductByCategory();

    }

    private void initController() {
    }

    private void initView() {
        productList = new ArrayList<>();
        productAdapter = new ProductByCategoryAdapter(getActivity(), productList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        binding.recycleProductMain.setLayoutManager(linearLayoutManager);
        binding.recycleProductMain.setAdapter(productAdapter);
    }

    private void callApiProductByCategory(){
        binding.progressBar.setVisibility(View.VISIBLE);
        BaseApi.API.getListProductByCategory(AccountUltil.TOKEN).enqueue(new Callback<ProductByCategoryReponse>() {
            @Override
            public void onResponse(Call<ProductByCategoryReponse> call, Response<ProductByCategoryReponse> response) {
                if (response.isSuccessful()) { // chỉ nhận đầu status 200
                    ProductByCategoryReponse reponse = response.body();
                    Log.d(TAG.toString, "onResponse-ListProductByCategory: " + reponse.toString());
                    if (reponse.getCode() == 200) {
                        for (ProductByCategory productByCategory : reponse.getResult()) {
                            if (productByCategory.getProduct().size() > 0) {
                                productList.add(productByCategory);
                            }
                        }
                        productAdapter.setListProductType(productList);
                    }
                } else { // nhận các đầu status #200
                    try {
                        String errorBody = response.errorBody().string();
                        JSONObject errorJson = new JSONObject(errorBody);
                        String errorMessage = errorJson.getString("message");
                        Log.d(TAG.toString, "onResponse-register: " + errorMessage);
                        Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_SHORT).show();
                    }catch (IOException e){
                        e.printStackTrace();
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
                binding.progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<ProductByCategoryReponse> call, Throwable t) {
                binding.progressBar.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG.toString, "onResume: ");
    }

    @Override
    public void onclickObject(Object object) {
        Product product = (Product) object;
        String id = product.getId();
        Intent intent = new Intent(getActivity(), DetailProduct.class);
        intent.putExtra("id_product", id);
        getActivity().startActivity(intent);
        getActivity().overridePendingTransition(R.anim.slidle_in_left, R.anim.slidle_out_left);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG.toString, "onStart: ");
    }
}