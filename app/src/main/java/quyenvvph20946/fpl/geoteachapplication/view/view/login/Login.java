package quyenvvph20946.fpl.geoteachapplication.view.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import quyenvvph20946.fpl.geoteachapplication.view.homescreen.MainActivity;
import quyenvvph20946.fpl.geoteachapplication.R;
import quyenvvph20946.fpl.geoteachapplication.databinding.ActivityLoginBinding;

public class Login extends AppCompatActivity {

    private ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initController();
    }

    private void initController() {
        binding.txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_left);
            }
        });

        binding.txtfogotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Login.this, ForgotPass.class);
                startActivity(intent1);
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_left);
            }
        });

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.edtEmail.getText().toString().trim();
                String pass = binding.edtPass.getText().toString().trim();
                loginAccount(email,pass);
            }
        });

        binding.btnLoginGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void loginAccount(String email,String pass) {
        Toast.makeText(Login.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
        screenSwitch(Login.this, MainActivity.class);
        finishAffinity();
    }
    private void screenSwitch(Context context,Class<?> cls) {
        Intent intent = new Intent(context,cls);
        startActivity(intent);
    }
}