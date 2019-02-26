package com.example.demomvvm.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demomvvm.R;
import com.example.demomvvm.model.WeatherModel.WeatherDigital;
import com.example.demomvvm.remote.database.WeatherModel;
import com.example.demomvvm.remote.retrofit.ApiUtils;
import com.example.demomvvm.remote.retrofit.SOService;
import com.example.demomvvm.viewmodel.WeatherViewModel;

import java.util.List;

public class WeatherActivity extends AppCompatActivity {
    LiveData<WeatherModel> weatherModelLiveData ;
    private SOService mService;
    private WeatherViewModel weatherViewModel;
    TextView tvthudo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        mService = ApiUtils.getSOService();
        weatherViewModel = ViewModelProviders.of(this).get(WeatherViewModel.class);
        tvthudo = findViewById(R.id.tvthudo);

        loadData();



    }

    private void loadData() {
        mService.EXAMPLE_CALL().enqueue(new Callback<WeatherDigital>() {
            @Override
            public void onResponse(Call<WeatherDigital> call, Response<WeatherDigital> response) {

                if (response.isSuccessful()) {
                    WeatherDigital resultApi = new WeatherDigital();
                    resultApi = response.body();
                    WeatherModel weatherModel = new WeatherModel(resultApi.getName());
//                                                                 resultApi.getMain().getTemp(),
//                                                                 resultApi.getMain().getHumidity(),
//                                                                 resultApi.getCod(),
//                                                                 resultApi.getWind().getSpeed());

                   weatherViewModel.insertdata(weatherModel);
                    Toast.makeText(WeatherActivity.this," ok",Toast.LENGTH_LONG).show();
                    tvthudo.setText(""+response.body().getName());

                    weatherViewModel.nhietDo.setValue(response.body().getMain().getTemp());
                    Log.d("Log", "posts loaded from API");
                } else {
                    int statusCode = response.code();
                    // handle request errors depending on status code
                    Toast.makeText(WeatherActivity.this," "+statusCode,Toast.LENGTH_LONG).show();

                    Log.d("Log", "posts loaded from API error"+ statusCode);
                }
            }

            @Override
            public void onFailure(Call<WeatherDigital> call, Throwable t) {
                Toast.makeText(WeatherActivity.this," error"  +weatherModelLiveData,Toast.LENGTH_LONG).show();
                 weatherModelLiveData = weatherViewModel.getWeatherdata();

            }
        });
    }
}
