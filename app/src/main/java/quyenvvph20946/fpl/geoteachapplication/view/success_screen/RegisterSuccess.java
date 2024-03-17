package quyenvvph20946.fpl.geoteachapplication.view.success_screen;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import quyenvvph20946.fpl.geoteachapplication.databinding.ActivityRegisterSuccessBinding;
import quyenvvph20946.fpl.geoteachapplication.view.login.Login;


public class RegisterSuccess extends AppCompatActivity {
    ActivityRegisterSuccessBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterSuccessBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSuccess.setOnClickListener(view -> {
            Intent intent = new Intent(RegisterSuccess.this, Login.class);
            startActivity(intent);
            finish();
        });
    }
}