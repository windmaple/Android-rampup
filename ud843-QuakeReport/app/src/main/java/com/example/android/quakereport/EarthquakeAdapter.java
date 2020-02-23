package com.example.android.quakereport;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Loader;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake>  {

    private static final String LOCATION_SEPARATOR = " of ";

//    @Override
//    public Loader onCreateLoader(int i, Bundle bundle) {
//        return null;
//    }
//
//    @Override
//    public void onLoadFinished(Loader loader, Object o) {
//
//    }
//
//    @Override
//    public void onLoaderReset(Loader loader) {
//
//    }

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    private int getMagnitudeColor(double mag) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(mag);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Earthquake earthquake = getItem(position);

        TextView magnitudeTextview = (TextView) listItemView.findViewById(R.id.magnitude);
        double mag = earthquake.getMagnitude();
        DecimalFormat formatter = new DecimalFormat("0.0");
        magnitudeTextview.setText(formatter.format(mag));

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextview.getBackground();
        int magnitudeColor = getMagnitudeColor(mag);
        magnitudeCircle.setColor(magnitudeColor);

        String primaryLocation;
        String locationOffset;
        String originalLocation = earthquake.getCity();

        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        TextView locationOffsetTextview = (TextView) listItemView.findViewById(R.id.location_offset);
        locationOffsetTextview.setText(locationOffset);

        TextView primaryLocationTextview = (TextView) listItemView.findViewById(R.id.primary_location);
        primaryLocationTextview.setText(primaryLocation);

        Long timeInMilliseconds = earthquake.getTime();
        Date dateObject = new Date(timeInMilliseconds);
        TextView dateTextview = (TextView) listItemView.findViewById(R.id.date);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        dateTextview.setText(dateFormatter.format(timeInMilliseconds));

        TextView timeTextview = (TextView) listItemView.findViewById(R.id.time);
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        timeTextview.setText(timeFormatter.format(timeInMilliseconds));

        return listItemView;
    }
}
