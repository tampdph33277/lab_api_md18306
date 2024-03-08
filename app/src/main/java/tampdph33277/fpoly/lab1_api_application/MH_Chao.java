package tampdph33277.fpoly.lab1_api_application;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class MH_Chao extends AppCompatActivity {
    private Button btnemail,btnOtp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mh_chao);
        btnemail = findViewById(R.id.btnemail);
        btnOtp = findViewById(R.id.btnOtp);
        btnemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MH_Chao.this, DangNhap.class);
                startActivity(in);
            }
        });
        btnOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MH_Chao.this, Phoneotp.class);
                startActivity(in);
            }
        });
    }}

