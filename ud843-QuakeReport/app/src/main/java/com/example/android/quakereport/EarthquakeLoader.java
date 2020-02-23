package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<ArrayList<Earthquake>> {

    private String mUrlString;

    class Result {
        public ArrayList<Earthquake> mResultValue;
        public Exception mException;
        public Result(ArrayList<Earthquake> resultValue) {
            mResultValue = resultValue;
        }
        public Result(Exception exception) {
            mException = exception;
        }
    }

    public EarthquakeLoader(Context context, String urlString) {
        super(context);
        mUrlString = urlString;

    }

    @Override
    public ArrayList<Earthquake> loadInBackground() {
        Result result = null;

        //if (urls == null || urls[0] == null) return null;
        try {
            ArrayList<Earthquake> resultValue = QueryUtils.fetchEarthquakeData(mUrlString);
            if (resultValue != null) {
                result = new Result(resultValue);
            }
            else {
                throw new IOException("No response received");
            }
        } catch (Exception e) {
            result = new Result(e);
        }

        return result.mResultValue;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
