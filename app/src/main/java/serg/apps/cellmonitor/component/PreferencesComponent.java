package serg.apps.cellmonitor.component;

import android.content.Context;
import android.content.SharedPreferences;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Xieergai on 11.04.2018.
 */

public class PreferencesComponent {

    private static final String TAG = PreferencesComponent.class.getSimpleName();

    public static final String PREFS_NAME = "app";
    private static final String KEY_APP_KEY = "app_key";
    private static final String KEY_INSTALLATION_ID = "installation_id";

    private static final String DEFAULT_APP_KEY = "AIzaSyC4wayGQ_8JLj5CuA0wTSroWjKeZj5Nbso";

    private SharedPreferences preferences;

    public PreferencesComponent(Context context) {
        preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public String getAppKey() {
        return preferences.getString(KEY_APP_KEY, DEFAULT_APP_KEY);
    }

    public String getInstallationId() {
        String installationId = preferences.getString(KEY_INSTALLATION_ID, null);
        if (installationId == null) {
            String newInstallationId = UUID.randomUUID().toString();
            preferences.edit().putString(KEY_INSTALLATION_ID, newInstallationId).apply();
            return newInstallationId;
        }
        return installationId;
    }


}
