package com.example.demomvvm.viewmodel;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.example.demomvvm.remote.database.WeatherModel;
import com.example.demomvvm.utility.WeatherRepository;
import com.example.demomvvm.view.WeatherActivity;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class WeatherViewModel extends AndroidViewModel {
    public MutableLiveData<String> nameThudo = new MutableLiveData<>();
    public MutableLiveData<Double> nhietDo = new MutableLiveData<>();
    public MutableLiveData<Double> tocDogio = new MutableLiveData<>();
    public MutableLiveData<Double> doAm = new MutableLiveData<>();
    WeatherRepository weatherRepository;
    LiveData<WeatherModel> weatherModelLiveData;
    public WeatherViewModel(@NonNull Application application) {
        super(application);
        nameThudo.setValue("Home");
        weatherRepository = new WeatherRepository(application);
        weatherModelLiveData = weatherRepository.getnamedata();
        nhietDo.setValue(0.00);
        tocDogio.setValue(0.00);
        doAm.setValue(0.00);
    }
    public LiveData<WeatherModel> getWeatherdata()
    {
        return weatherModelLiveData;
    }
    public void insertdata (WeatherModel weatherModel)
    {
        weatherRepository.insert(weatherModel);
        Log.d("insert","ok");

    }
    public MutableLiveData<String> getNameThudo() {
        return nameThudo;
    }

    public void setNameThudo(MutableLiveData<String> nameThudo) {
        this.nameThudo = nameThudo;
    }

    public MutableLiveData<Double> getNhietDo() {
        return nhietDo;
    }

    public void setNhietDo(MutableLiveData<Double> nhietDo) {
        this.nhietDo = nhietDo;
    }

    public MutableLiveData<Double> getTocDogio() {
        return tocDogio;
    }

    public void setTocDogio(MutableLiveData<Double> tocDogio) {
        this.tocDogio = tocDogio;
    }

    public MutableLiveData<Double> getMay() {
        return doAm;
    }

    public void setMay(MutableLiveData<Double> doAm) {
        this.doAm = doAm;
    }
}
