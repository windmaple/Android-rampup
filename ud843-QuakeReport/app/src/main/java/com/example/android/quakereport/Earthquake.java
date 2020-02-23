package com.example.android.quakereport;

public class Earthquake {
    private double mMagnitude;
    private String mCity;
    private Long mTime;
    private String mUrl;

    public String getUrl() {
        return mUrl;
    }

    public Earthquake(double magnitude, String city, Long time, String url) {
        mMagnitude = magnitude;
        mCity = city;
        mTime = time;
        mUrl = url;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getCity() {
        return mCity;
    }

    public Long getTime() {
        return mTime;
    }
}
