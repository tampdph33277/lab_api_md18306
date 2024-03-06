package tampdph33277.fpoly.lab1_api_application;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
public class Home extends AppCompatActivity {

    private Button buttonLogout,buttonOPT;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mAuth = FirebaseAuth.getInstance();
        buttonOPT = findViewById(R.id.buttonOPT);
        buttonLogout = findViewById(R.id.buttonLogout);
        buttonOPT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,Phoneotp.class));
            }
        });

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,Phoneotp.class));

                startActivity(new Intent(Home.this,DangNhap.class));
            }
        });
    }


}

