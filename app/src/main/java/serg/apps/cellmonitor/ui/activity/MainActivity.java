package serg.apps.cellmonitor.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.FrameLayout;

import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.android.SupportAppNavigator;
import ru.terrakok.cicerone.commands.Command;
import serg.apps.cellmonitor.R;
import serg.apps.cellmonitor.presentation.presenter.MainPresenter;
import serg.apps.cellmonitor.presentation.view.MainView;
import serg.apps.cellmonitor.ui.Screens;
import serg.apps.cellmonitor.ui.activity.base.AppPrivateActivity;
import serg.apps.cellmonitor.ui.fragment.MainScreenFragment;

public class MainActivity extends AppPrivateActivity implements MainView {

    private static final String TAG = MainActivity.class.getSimpleName();

    @InjectPresenter
    MainPresenter mainPresenter;

    @BindView(R.id.activity_parent)
    FrameLayout activityParent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart(): begin");
        super.onStart();

        mainPresenter.init();
        //setSettingsForBottomMenu();

        Log.d(TAG, "onStart(): end");
    }

    private Navigator navigator = new SupportAppNavigator(this, getSupportFragmentManager(), R.id.fragment_container) {
        @Override
        protected Intent createActivityIntent(String screenKey, Object data) {
            Log.d(TAG, String.format("createActivityIntent([%s])", screenKey));
            switch (screenKey) {
//                case Screens.Groups.CONTACTS:
//                    return new Intent(MainActivity.this, ContactsActivity.class);
                default:
                    return null;
            }
        }

        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            Log.d(TAG, String.format("createFragment([%s])", screenKey));
            switch (screenKey) {
                case Screens.MAIN_FORM:
                    return new MainScreenFragment();
//                case Screens.PRESCRIPTIONS:
//                    return new PrescriptionsFragment();

                default:
                    return null;
            }
        }

        @Override
        protected void setupFragmentTransactionAnimation(Command command, Fragment currentFragment, Fragment nextFragment, FragmentTransaction fragmentTransaction) {
            fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_out, android.R.anim.fade_in);
        }
    };

    @Override
    protected Navigator getNavigator() {
        return navigator;
    }

    @Override
    protected String getScreenGroupKey() {
        return null;
    }

    @Override
    public void setSelectedBottomMenuItem(int menuId) {

    }
}
