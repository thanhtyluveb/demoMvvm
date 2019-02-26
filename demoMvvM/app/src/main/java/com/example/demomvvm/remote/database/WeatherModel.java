package com.example.demomvvm.remote.database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "weather_table")
public class WeatherModel {
    @PrimaryKey
    @NonNull
    public String nameThudo;

    public WeatherModel(@NonNull String nameThudo) {
        this.nameThudo = nameThudo;
    }
    public WeatherModel()
    {

    }

    //    @NonNull
//    private Double nhietDo;
//
//    @NonNull
//    private Integer doAm;
//
//    @NonNull
//    private Integer huongGio;
//
//    @NonNull
//    private Double tocdoGio;
//
//    public WeatherModel(@NonNull String nameThudo, @NonNull Double nhietDo, @NonNull Integer doAm, @NonNull Integer huongGio, @NonNull Double tocdoGio) {
//        this.nameThudo = nameThudo;
//        this.nhietDo = nhietDo;
//        this.doAm = doAm;
//        this.huongGio = huongGio;
//        this.tocdoGio = tocdoGio;
//    }

    @NonNull
    public String getNameThudo() {
        return nameThudo;
    }

    public void setNameThudo(@NonNull String nameThudo) {
        this.nameThudo = nameThudo;
    }

//    @NonNull
//    public Double getNhietDo() {
//        return nhietDo;
//    }
//
//    public void setNhietDo(@NonNull Double nhietDo) {
//        this.nhietDo = nhietDo;
//    }
//
//    @NonNull
//    public Integer getDoAm() {
//        return doAm;
//    }
//
//    public void setDoAm(@NonNull Integer doAm) {
//        this.doAm = doAm;
//    }
//
//    @NonNull
//    public Integer getHuongGio() {
//        return huongGio;
//    }
//
//    public void setHuongGio(@NonNull Integer huongGio) {
//        this.huongGio = huongGio;
//    }
//
//    @NonNull
//    public Double getTocdoGio() {
//        return tocdoGio;
//    }
//
//    public void setTocdoGio(@NonNull Double tocdoGio) {
//        this.tocdoGio = tocdoGio;
//    }
}
