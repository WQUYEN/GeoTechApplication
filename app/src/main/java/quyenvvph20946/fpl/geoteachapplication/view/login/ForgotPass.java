package quyenvvph20946.fpl.geoteachapplication.view.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import quyenvvph20946.fpl.geoteachapplication.R;
import quyenvvph20946.fpl.geoteachapplication.api.BaseApi;
import quyenvvph20946.fpl.geoteachapplication.databinding.ActivityForgotPassBinding;
import quyenvvph20946.fpl.geoteachapplication.model.response.ServerResponse;
import quyenvvph20946.fpl.geoteachapplication.ultil.ProgressLoadingDialog;
import quyenvvph20946.fpl.geoteachapplication.ultil.TAG;
import quyenvvph20946.fpl.geoteachapplication.ultil.Validator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPass extends AppCompatActivity {
    private ActivityForgotPassBinding binding;
    private ProgressLoadingDialog loadingDialog;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForgotPassBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initController();
        initView();
    }

    private void initController() {
        binding.btnVerifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email  =binding.edtEmail.getText().toString().trim();
                registerAccount(email);
            }
        });
        binding.backfogot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
            }
        });
    }
    private void registerAccount(String email) {
        if(checkEmail(email)) {
            loadingDialog.show();
            BaseApi.API.forgotPassword(email).enqueue(new Callback<ServerResponse>() {
                @Override
                public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                    if(response.isSuccessful()){ // chỉ nhận đầu status 200
                        ServerResponse serverResponse = response.body();
                        Log.d(TAG.toString, "onResponse-forgotPassword: " + serverResponse.toString());
                        serverResponse.getCode();
                        if(serverResponse.getCode() == 200) {
                            Toast.makeText(getApplicationContext(), serverResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    } else { // nhận các đầu status #200
                        try {
                            String errorBody = response.errorBody().string();
                            JSONObject errorJson = new JSONObject(errorBody);
                            String errorMessage = errorJson.getString("message");
                            Log.d(TAG.toString, "onResponse-forgotPassword: " + errorMessage);
                            Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_SHORT).show();
                        }catch (IOException e){
                            e.printStackTrace();
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    loadingDialog.dismiss();
                }

                @Override
                public void onFailure(Call<ServerResponse> call, Throwable t) {
                    Toast.makeText(ForgotPass.this, t.toString(), Toast.LENGTH_SHORT).show();
                    Log.d(TAG.toString, "onFailure-forgotPassword: " + t.toString());
                    loadingDialog.dismiss();
                }
            });
        }
    }
    private boolean checkEmail(String email) {
        setTextUI();
        if(!Validator.isValidEmail(email)) {
            binding.tvErrorEmail.setText("Không đúng định dạng email!");
            binding.lineEmail.setVisibility(View.GONE);
            binding.tvErrorEmail.setVisibility(View.VISIBLE);
            return false;
        }
        return true;
    }
    private void setTextUI() {
        binding.tvErrorEmail.setText("");
        binding.lineEmail.setVisibility(View.VISIBLE);
        binding.tvErrorEmail.setVisibility(View.GONE);
    }

    private void initView() {
        loadingDialog = new ProgressLoadingDialog(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }
}