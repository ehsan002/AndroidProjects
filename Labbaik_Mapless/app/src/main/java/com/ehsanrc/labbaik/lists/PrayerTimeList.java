package com.ehsanrc.labbaik.lists;

/**
 * Created by USER on 12/08/2016.
 */
public class PrayerTimeList {

    private int date;
    private String arabicDate;
    private String day;
    private String fajr;
    private String sunrise;
    private String duhr;
    private String asr;
    private String magribr;
    private String isha;

    public PrayerTimeList() {
    }

    public PrayerTimeList(int date, String arabicDate, String day, String fajr, String sunrise, String duhr, String asr, String magribr, String isha) {
        this.date = date;
        this.arabicDate = arabicDate;
        this.day = day;
        this.fajr = fajr;
        this.sunrise = sunrise;
        this.duhr = duhr;
        this.asr = asr;
        this.magribr = magribr;
        this.isha = isha;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getArabicDate() {
        return arabicDate;
    }

    public void setArabicDate(String arabicDate) {
        this.arabicDate = arabicDate;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getFajr() {
        return fajr;
    }

    public void setFajr(String fajr) {
        this.fajr = fajr;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getDuhr() {
        return duhr;
    }

    public void setDuhr(String duhr) {
        this.duhr = duhr;
    }

    public String getAsr() {
        return asr;
    }

    public void setAsr(String asr) {
        this.asr = asr;
    }

    public String getMagribr() {
        return magribr;
    }

    public void setMagribr(String magribr) {
        this.magribr = magribr;
    }

    public String getIsha() {
        return isha;
    }

    public void setIsha(String isha) {
        this.isha = isha;
    }
}
