package tampdph33277.fpoly.lab1_api_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MH_city extends AppCompatActivity {
    RecyclerView recyclerViewCities;
    ArrayList<City> list = new ArrayList<>();
    Adapter adapter;
    FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mh_city);

        adapter = new Adapter(list, MH_city.this);
        firebaseFirestore = FirebaseFirestore.getInstance();
        recyclerViewCities = findViewById(R.id.recyclerViewCities);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerViewCities.setLayoutManager(linearLayoutManager);
        recyclerViewCities.setAdapter(adapter);
        getDataFromFirestore();
    }

    private void getDataFromFirestore() {
        firebaseFirestore.collection("cities")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                City city = new City();
                                city.setTextViewCityName(document.getString("name"));
                                city.setTextViewStateCity(document.getString("state"));
                                city.setTextViewCountryCity(document.getString("country"));
                                city.setTextViewPopulation(String.valueOf(document.getLong("population")));
                                list.add(city);
                            }
                            adapter.notifyDataSetChanged();
                        } else {
                            Toast.makeText(MH_city.this, "Failed to fetch data from Firestore", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}