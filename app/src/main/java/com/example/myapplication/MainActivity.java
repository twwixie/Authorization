package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    final static String USRN = "abc",
            PSW = "abc";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usn = binding.username.getText().toString();
                String pas = binding.password.getText().toString();

                if (usn.equals(USRN) && pas.equals(PSW)) {
                    Toast.makeText(MainActivity.this, "Вы вошли в систему", Toast.LENGTH_SHORT).show();
                } if (!usn.equals(USRN) || !pas.equals(PSW)) {
                    Toast.makeText(MainActivity.this, "К сожалению войти не удалось", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
