package quyenvvph20946.fpl.geoteachapplication.view.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import quyenvvph20946.fpl.geoteachapplication.R;
import quyenvvph20946.fpl.geoteachapplication.databinding.ActivityResetPassSuccessBinding;

public class ResetPassSuccess extends AppCompatActivity {
    ImageView backResetSuccess;
    private ActivityResetPassSuccessBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResetPassSuccessBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backResetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}