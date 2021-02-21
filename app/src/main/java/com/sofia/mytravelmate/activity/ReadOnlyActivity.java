package com.sofia.mytravelmate.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.sofia.mytravelmate.R;
import com.sofia.mytravelmate.Vacation;
import com.sofia.mytravelmate.retrofit.GetWeatherService;
import com.sofia.mytravelmate.retrofit.RetrofitClient;
import com.sofia.mytravelmate.retrofit.datamodel.OpenWeatherDto;

import org.w3c.dom.Text;

import java.util.Optional;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReadOnlyActivity extends AppCompatActivity {

    private Vacation vacation;
    private static String apiKey = "dcefc7378210c484f8dac4d6a6e87b2d";

    private TextView readOnly1;
    private TextView readOnly2;
    private TextView readOnly3;
    private TextView readOnly4;
    private TextView readOnly5;
    private TextView readOnly6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_only);

        readOnly1 = findViewById(R.id.readOnly1);
        readOnly2 = findViewById(R.id.readOnly2);
        readOnly3 = findViewById(R.id.readOnly3);
        readOnly4 = findViewById(R.id.readOnly4);
        readOnly5 = findViewById(R.id.readOnly5);
        readOnly6 = findViewById(R.id.readOnly6);


        Optional.ofNullable(getIntent().getSerializableExtra("vacation")).ifPresent((vac) -> vacation = (Vacation) vac);

        if (vacation != null) {

            readOnly1.setText(vacation.getVacationName());
            readOnly2.setText(vacation.getLocation());
            readOnly3.setText(String.valueOf(vacation.getPrice())+" EURO");

            GetWeatherService service = RetrofitClient.getRetrofitInstance().create(GetWeatherService.class);

            Call<OpenWeatherDto> call = service.getWeather(vacation.getLocation(), apiKey);
            call.enqueue(new Callback<OpenWeatherDto>() {

                @Override
                public void onResponse(Call<OpenWeatherDto> call, Response<OpenWeatherDto> response) {

                    readOnly4.setText(String.valueOf(response.body().getMain().getTemp()));
                    readOnly5.setText(String.valueOf(response.body().getMain().getPressure()));
                    readOnly6.setText(response.body().getWeather().get(0).getDescription());

                }

                @Override
                public void onFailure(Call<OpenWeatherDto> call, Throwable t) {

                    Toast.makeText(getApplicationContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                }
            });
        }


    }
}