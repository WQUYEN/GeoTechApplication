package quyenvvph20946.fpl.geoteachapplication.view.success_screen;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import quyenvvph20946.fpl.geoteachapplication.databinding.ActivityCreateStoreSuccessBinding;
import quyenvvph20946.fpl.geoteachapplication.view.home_screen.MainActivity;

public class CreateStoreSuccessActivity extends AppCompatActivity {
    ActivityCreateStoreSuccessBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateStoreSuccessBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
        initController();
    }

    private void initController() {
        binding.btnSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateStoreSuccessActivity.this, MainActivity.class);
                startActivity(intent);
                finishAffinity();
            }
        });
    }

    private void initView() {
    }
}