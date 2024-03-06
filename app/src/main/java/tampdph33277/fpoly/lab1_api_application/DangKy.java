package tampdph33277.fpoly.lab1_api_application;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DangKy extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonRegister;
    private FirebaseAuth mAuth;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        editTextUsername = findViewById(R.id.editTextUsername1);
        editTextPassword = findViewById(R.id.editTextPassword1);
        buttonRegister = findViewById(R.id.buttonRegister1);
        mAuth = FirebaseAuth.getInstance();
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy giá trị email và password tại thời điểm người dùng nhấn nút đăng ký
                String email = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                // Hàm đăng ký tài khoản
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener((Activity) context, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(getApplicationContext(), "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(DangKy.this, DangNhap.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "Đăng ký thất bại" + task.getException().toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
//public void dangKy(){
//    String username = editTextUsername.getText().toString();
//  String password = editTextPassword.getText().toString();
//  mAuth.createUserWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//      @Override
//      public void onComplete(@NonNull Task<AuthResult> task) {
//          if (task.isSuccessful()) {
//                        // Đăng ký thành công
//                        FirebaseUser user = mAuth.getCurrentUser();
//                        // Tiếp tục xử lý sau khi đăng ký thành công, ví dụ: chuyển đến màn hình đăng nhập
//                        Toast.makeText(DangKy.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
//                    } else {
//                        // Đăng ký thất bại
//                        Toast.makeText(DangKy.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
//                    }
//      }
//  });
//    }
//}
//    private void dangKy() {
//        String username = editTextUsername.getText().toString();
//        String password = editTextPassword.getText().toString();
//        mAuth.createUserWithEmailAndPassword(username, password)
//                .addOnCompleteListener(this, task -> {
//
//                    if (task.isSuccessful()) {
//                        // Đăng ký thành công
//                        FirebaseUser user = mAuth.getCurrentUser();
//                        // Tiếp tục xử lý sau khi đăng ký thành công, ví dụ: chuyển đến màn hình đăng nhập
//                        Toast.makeText(DangKy.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
//                    } else {
//                        // Đăng ký thất bại
//                        Toast.makeText(DangKy.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }
//}