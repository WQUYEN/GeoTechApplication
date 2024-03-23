package quyenvvph20946.fpl.geotech.view.login;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import quyenvvph20946.fpl.geotech.databinding.ResetPassSuccessBinding;


public class ResetPassWordSuccess extends AppCompatActivity {
    ImageView backResetsuccess;
    private ResetPassSuccessBinding binding;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ResetPassSuccessBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.backResetsuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
