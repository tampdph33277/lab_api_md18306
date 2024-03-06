package tampdph33277.fpoly.lab1_api_application;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
public class MH_Chao extends AppCompatActivity {
    private static final int SPLASH_DELAY = 300; // 3 seconds
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mh_chao);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Tạo Intent để chuyển đến màn hình tiếp theo
                Intent intent = new Intent(MH_Chao.this, DangNhap.class);
                startActivity(intent);
                finish(); // Kết thúc màn hình chào
            }
        }, SPLASH_DELAY);
    }
    }

