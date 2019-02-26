package com.example.demomvvm.utility;

import android.app.Application;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.demomvvm.remote.database.WeatherDao;
import com.example.demomvvm.remote.database.WeatherDatabase;
import com.example.demomvvm.remote.database.WeatherModel;
import com.example.demomvvm.view.WeatherActivity;

import androidx.lifecycle.LiveData;

public class WeatherRepository {
    private WeatherDao weatherDao;
    LiveData<WeatherModel> weatherModel;

    public WeatherRepository(Application application) {
        WeatherDatabase db = WeatherDatabase.getDatabase(application);
        weatherDao = db.weatherDao();
        weatherModel = weatherDao.getnamedata();
    }
    public LiveData<WeatherModel> getnamedata()
    {
        return  weatherModel;
    }
    public void insert(WeatherModel weatherModel)
    {
        new insertAsyncTask(weatherDao).execute(weatherModel);
    }

    private static class insertAsyncTask extends AsyncTask<WeatherModel ,Void, Void>
    {
        WeatherDao aSyncweatherDao;

        public insertAsyncTask(WeatherDao aSyncweatherDao) {
            this.aSyncweatherDao = aSyncweatherDao;
        }

        @Override
        protected Void doInBackground(WeatherModel... weatherModels) {
            aSyncweatherDao.insert(weatherModels[0]);
            return null;

        }
    }
}
