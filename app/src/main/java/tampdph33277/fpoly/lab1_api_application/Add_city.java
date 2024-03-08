package tampdph33277.fpoly.lab1_api_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Add_city extends AppCompatActivity {

    EditText editTextCityName, editTextState, editTextCountry, editTextPopulation;
    Button buttonAddCity;
    FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_city);

        editTextCityName = findViewById(R.id.editTextCityName);
        editTextState = findViewById(R.id.editTextStateCity);
        editTextCountry = findViewById(R.id.editTextCountryCity);
        editTextPopulation = findViewById(R.id.editTextPopulation);
        buttonAddCity = findViewById(R.id.buttonAddCity);

        firebaseFirestore = FirebaseFirestore.getInstance();

        buttonAddCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCity();
            }
        });
    }

    private void addCity() {
        String cityName = editTextCityName.getText().toString().trim();
        String state = editTextState.getText().toString().trim();
        String country = editTextCountry.getText().toString().trim();
        int population = Integer.parseInt(editTextPopulation.getText().toString().trim());

        // Tạo map dữ liệu
        Map<String, Object> cityData = new HashMap<>();
        cityData.put("name", cityName);
        cityData.put("state", state);
        cityData.put("country", country);
        cityData.put("population", population);

        // Thêm dữ liệu vào Firestore
        CollectionReference citiesRef = firebaseFirestore.collection("cities");
        citiesRef.add(cityData)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                         // Xóa các trường nhập liệu
                        editTextCityName.setText("");
                        editTextState.setText("");
                        editTextCountry.setText("");
                        editTextPopulation.setText("");      startActivity(new Intent(Add_city.this,MH_city.class));
                        Toast.makeText(Add_city.this, "Thêm thành phố thành công!", Toast.LENGTH_SHORT).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Add_city.this, "Thêm thành phố thất bại!", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(Add_city.this,Add_city.class));     }
                });
}}