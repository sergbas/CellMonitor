package serg.apps.cellmonitor.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.android.SupportAppNavigator;
import ru.terrakok.cicerone.commands.Command;
import serg.apps.cellmonitor.R;
import serg.apps.cellmonitor.presentation.presenter.LoginPresenter;
import serg.apps.cellmonitor.presentation.view.LoginView;
import serg.apps.cellmonitor.ui.Screens;
import serg.apps.cellmonitor.ui.activity.base.AppPrivateActivity;
import serg.apps.cellmonitor.ui.fragment.login.LoginScreenFragment;

public class LoginActivity extends AppPrivateActivity implements LoginView {

    private static final String TAG = LoginActivity.class.getSimpleName();

    public static final String KEY_REDIRECT_SCREEN = "redirect_screen";

    @InjectPresenter
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        /*if (fragment != null
                && fragment instanceof BackButtonListener
                && ((BackButtonListener) fragment).onBackPressed()) {
            return;
        }*/
        super.onBackPressed();
    }

    private Navigator navigator = new SupportAppNavigator(this, getSupportFragmentManager(), R.id.fragment_container) {
        @Override
        protected Intent createActivityIntent(String screenKey, Object data) {
            Log.d(TAG, String.format("createActivityIntent([%s])", screenKey));
            switch (screenKey) {
                case Screens.Groups.MAIN:
                    Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                    if (data != null) {
                        mainIntent.putExtras((Bundle) data);
                    }
                    return mainIntent;
                default:
                    return null;
            }
        }

        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            Log.d(TAG, String.format("createFragment([%s])", screenKey));
            switch (screenKey) {
                case Screens.LOGIN_FORM:
                    return new LoginScreenFragment();

                default:
                    return null;
            }
        }

        @Override
        protected void setupFragmentTransactionAnimation(Command command, Fragment currentFragment, Fragment nextFragment, FragmentTransaction fragmentTransaction) {
            if (nextFragment instanceof LoginScreenFragment ) {
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_out, android.R.anim.fade_in);
            } else {
                //fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
            }
        }

        @Override
        protected void showSystemMessage(String message) {
            //Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected Navigator getNavigator() {
        return navigator;
    }

    @Override
    protected String getScreenGroupKey() {
        return Screens.Groups.LOGIN;
    }
}

