package serg.apps.cellmonitor.component;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

/**
 * Created by Xieergai on 11.04.2018.
 */

final public class GooglePlayServicesComponent {

    //intent request code to handle updating play services if needed
    private final static int RC_HANDLE_GMS = 9001;

    private Context context;
    private FusedLocationProviderClient fusedLocationProviderClient;

    public GooglePlayServicesComponent(@NonNull Context context) {
        this.context = context;
        this.fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
    }

    FusedLocationProviderClient getFusedLocationProviderClient() {
        return fusedLocationProviderClient;
    }

    void checkGooglePlayServicesAvailability() throws GooglePlayServicesNotAvailableException {
        //Check Google Play Services availability
        int resultCode = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
        if (resultCode != ConnectionResult.SUCCESS) {
            throw new GooglePlayServicesNotAvailableException(resultCode);
        }
    }

    public Dialog getAvailabilityErrorDialog(Activity activity, int resultCode) {
        Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(activity, resultCode, RC_HANDLE_GMS);
        dialog.setCancelable(false);
        return dialog;
    }
}
