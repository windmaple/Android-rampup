/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.didyoufeelit;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.IOException;

import static com.example.android.didyoufeelit.Utils.fetchEarthquakeData;

/**
 * Displays the perceived strength of a single earthquake event based on responses from people who
 * felt the earthquake.
 */
public class MainActivity extends AppCompatActivity {

    /** URL for earthquake data from the USGS dataset */
    private static final String USGS_REQUEST_URL =
            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2016-01-01&endtime=2016-05-02&minfelt=50&minmagnitude=5";

    private DownloadTask mDownloadTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        // Perform the HTTP request for earthquake data and process the response.
//        Event earthquake = fetchEarthquakeData(USGS_REQUEST_URL);
//
//        // Update the information displayed to the user.
//        updateUi(earthquake);
        mDownloadTask = new DownloadTask();
        mDownloadTask.execute(USGS_REQUEST_URL);
    }

    /**
     * Update the UI with the given earthquake information.
     */
    private void updateUi(Event earthquake) {
        TextView titleTextView = (TextView) findViewById(R.id.title);
        titleTextView.setText(earthquake.title);

        TextView tsunamiTextView = (TextView) findViewById(R.id.number_of_people);
        tsunamiTextView.setText(getString(R.string.num_people_felt_it, earthquake.numOfPeople));

        TextView magnitudeTextView = (TextView) findViewById(R.id.perceived_magnitude);
        magnitudeTextView.setText(earthquake.perceivedStrength);
    }

    private class DownloadTask extends AsyncTask<String, Void, DownloadTask.Result> {

        class Result {
            public Event mResultValue;
            public Exception mException;
            public Result(Event resultValue) {
                mResultValue = resultValue;
            }
            public Result(Exception exception) {
                mException = exception;
            }
        }

        @Override
        protected Result doInBackground(String... urls) {
            Result result = null;

            if (urls == null || urls[0] == null) return null;
            try {
                Event resultValue = fetchEarthquakeData(urls[0]);
                if (resultValue != null) {
                    result = new Result(resultValue);
                }
                else {
                    throw new IOException("No response received");
                }
            } catch (Exception e) {
                result = new Result(e);
            }

            return result;
        }

        @Override
        protected void onPostExecute(Result result) {
            if (result.mResultValue != null)
                updateUi(result.mResultValue);
        }
    }
}
