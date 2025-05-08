package com.example.dubaothoitiet;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.widget.TextView;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvHour;
    private TextView tvTem;
    private TextView tvStatus;
    private TextView tvLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLocation = findViewById(R.id.tvLocation);
        tvTem = findViewById(R.id.tvTem);
        tvStatus = findViewById(R.id.tvStatus);

        // Set the location name
        tvLocation.setText("Đà Nẵng");

        // Step 1: Fetch hourly weather data
        getHours();

        // Step 2: Set up RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        // Step 4: Bind RecyclerView
        rvHour = findViewById(R.id.rvHour);
        rvHour.setLayoutManager(layoutManager);
    }

    private void getHours() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API service = retrofit.create(API.class);

        service.getHour().enqueue(new Callback<List<Wheather>>() {
            @Override
            public void onResponse(Call<List<Wheather>> call, Response<List<Wheather>> response) {
                if (response.body() == null) return;
                List<Wheather> listWheather = response.body();
                HourAdapter adapter = new HourAdapter(MainActivity.this, listWheather);
                rvHour.setAdapter(adapter);

                Wheather wheather = listWheather.get(0);
                tvTem.setText(String.format("%d°", wheather.getTemperature().getValue().intValue()));
                tvStatus.setText(wheather.getIconPhrase());
            }

            @Override
            public void onFailure(Call<List<Wheather>> call, Throwable t) {
                // Handle failure (e.g., show error message)
            }
        });
    }
}