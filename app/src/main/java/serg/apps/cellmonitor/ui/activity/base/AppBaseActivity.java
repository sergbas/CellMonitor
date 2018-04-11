package serg.apps.cellmonitor.ui.activity.base;

import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;

import com.arellomobile.mvp.MvpAppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import serg.apps.cellmonitor.App;
import serg.apps.cellmonitor.R;
import serg.apps.cellmonitor.permission.PermissionResult;
import serg.apps.cellmonitor.permission.PermissionsListener;

/**
 * Created by Xieergai on 11.04.2018.
 */

public abstract class AppBaseActivity extends MvpAppCompatActivity {

    private static final String TAG = AppBaseActivity.class.getSimpleName();

    private final static int REQUEST_PERMISSION_CODE = 1;

    @Inject
    NavigatorHolder navigatorHolder;

    private PermissionsListener permissionsListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getNavigationDaggerComponent().inject(this);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        Context resultContext = newBase;
        super.attachBaseContext(resultContext);
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(getNavigator());
    }

    @Override
    protected void onPause() {
        super.onPause();
        navigatorHolder.removeNavigator();
    }

    protected abstract Navigator getNavigator();

    protected abstract String getScreenGroupKey();

    public List<PermissionResult> checkPermissions(String ...permissions) {
        List<PermissionResult> permissionResults = new ArrayList<>();
        for (String permission : permissions) {
            permissionResults.add(checkPermission(permission));
        }
        return permissionResults;
    }

    public PermissionResult checkPermission(String permission) {
        return new PermissionResult(permission, ContextCompat.checkSelfPermission(this,
                permission) == PackageManager.PERMISSION_GRANTED);
    }

    public void requestPermissions(@NonNull PermissionsListener permissionsListener, String ...permissions) {
        this.permissionsListener = permissionsListener;
        ActivityCompat.requestPermissions(this,
                permissions, REQUEST_PERMISSION_CODE);
    }

    /*
    public boolean shouldShowPermissionRationale(String permission) {
        return ActivityCompat.shouldShowRequestPermissionRationale(this, permission);
    }
    */

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        List<PermissionResult> permissionResults = new ArrayList<>();
        for (int i = 0; i < permissions.length; i++) {
            permissionResults.add(new PermissionResult(permissions[i], grantResults[i] == PackageManager.PERMISSION_GRANTED));
        }
        permissionsListener.OnPermissionResult(permissionResults);
        permissionsListener = null;
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void showPermissionsRationaleDialog(String message, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AppTheme_AlertDialog);
        builder.setTitle(R.string.SYS_ATTENTION)
                .setMessage(message)
                .setPositiveButton(R.string.SYS_PROCEED, onClickListener)
                .setCancelable(false);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
