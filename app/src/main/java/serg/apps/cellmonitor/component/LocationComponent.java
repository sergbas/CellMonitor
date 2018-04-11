package serg.apps.cellmonitor.component;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.util.Log;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import serg.apps.cellmonitor.R;

/**
 * Created by Xieergai on 11.04.2018.
 */

final public class LocationComponent {

    private final static String TAG = LocationComponent.class.getSimpleName();

    private Context context;
    private GooglePlayServicesComponent googlePlayServicesComponent;
    private Geocoder geocoder;

    private LocationCallback locationCallback;

    public LocationComponent(Context context, GooglePlayServicesComponent googlePlayServicesComponent) {
        this.context = context;
        this.googlePlayServicesComponent = googlePlayServicesComponent;
        this.geocoder = new Geocoder(context, Locale.getDefault());
    }

    @SuppressLint("MissingPermission")
    public void getLastLocation(OnSuccessListener<Location> onSuccessListener, OnFailureListener onFailureListener) throws GooglePlayServicesNotAvailableException {

        googlePlayServicesComponent.checkGooglePlayServicesAvailability();

        String title = context.getString(R.string.unable_locate);
        getLocationAvailability(locationAvailability -> {
            if (!locationAvailability.isLocationAvailable()) {
                onFailureListener.onFailure(new Exception(context.getString(R.string.enable_location)));
                return;
            }

            OnSuccessListener<Location> innerOnSuccessListener = location -> {
                if (location == null) {
                    updateCurrentLocation(onSuccessListener, onFailureListener);
                    return;
                }
                onSuccessListener.onSuccess(location);
            };

            googlePlayServicesComponent.getFusedLocationProviderClient().getLastLocation()
                    .addOnSuccessListener(innerOnSuccessListener)
                    .addOnFailureListener(onFailureListener);
        }, e -> onFailureListener.onFailure(new Exception(context.getString(R.string.unknown_error))));
    }

    @SuppressLint("MissingPermission")
    private void updateCurrentLocation(OnSuccessListener<Location> onSuccessListener, OnFailureListener onFailureListener) {
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                Log.d(TAG, "onLocationResult()");
                //stop location updates
                googlePlayServicesComponent.getFusedLocationProviderClient().removeLocationUpdates(locationCallback);

                List<Location> locations = locationResult.getLocations();
                if (locations.size() > 0) {
                    onSuccessListener.onSuccess(locations.get(0));
                    return;
                }

                onFailureListener.onFailure(new Exception("location list is empty"));
            }

            @Override
            public void onLocationAvailability(LocationAvailability locationAvailability) {
                if (!locationAvailability.isLocationAvailable()) {
                    Log.d(TAG, "stop location updates");
                    googlePlayServicesComponent.getFusedLocationProviderClient().removeLocationUpdates(locationCallback);
                    onFailureListener.onFailure(new Exception("location is not available"));
                }
            }
        };

        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(10000);
        locationRequest.setFastestInterval(10000);

        Log.d(TAG, "start location updates...");
        googlePlayServicesComponent.getFusedLocationProviderClient().requestLocationUpdates(locationRequest, locationCallback, null);
    }

    public Address getAddressFromLocation(Location location) throws IOException {
        List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
        if (addresses.size() > 0) {
            return addresses.get(0);
        }
        return null;
    }

    @SuppressLint("MissingPermission")
    private void getLocationAvailability(OnSuccessListener<LocationAvailability> onSuccessListener, OnFailureListener onFailureListener) {
        googlePlayServicesComponent.getFusedLocationProviderClient().getLocationAvailability()
                .addOnSuccessListener(onSuccessListener)
                .addOnFailureListener(onFailureListener);
    }

}
