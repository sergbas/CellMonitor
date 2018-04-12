package serg.apps.cellmonitor.ui.activity.base;

import android.os.Bundle;

import ru.terrakok.cicerone.Navigator;

/**
 * Created by Xieergai on 12.04.2018.
 */

public abstract class AppPrivateActivity extends AppBaseActivity {

    private static final String TAG = AppPrivateActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected abstract Navigator getNavigator();

    protected abstract String getScreenGroupKey();
}
