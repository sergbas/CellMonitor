package serg.apps.cellmonitor.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import serg.apps.cellmonitor.App;
import serg.apps.cellmonitor.BuildConfig;
import serg.apps.cellmonitor.component.PreferencesComponent;
import serg.apps.cellmonitor.presentation.presenter.base.BaseNavigationPresenter;
import serg.apps.cellmonitor.presentation.view.LoginView;
import serg.apps.cellmonitor.ui.Screens;

/**
 * Created by Xieergai on 12.04.2018.
 */

@InjectViewState
public class LoginPresenter extends BaseNavigationPresenter<LoginView> {

    @Inject
    PreferencesComponent preferencesComponent;

    public LoginPresenter() {
        App.getAppDaggerComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        {

            //TODO позже надо сделать нормально, сейчас пока так
            if (BuildConfig.DEBUG) {
                getRouter().newRootScreen(Screens.LOGIN_FORM);
                return;
            }

            getRouter().newRootScreen(Screens.FIRST_ENTER);
            return;
        }

        //getRouter().newRootScreen(Screens.LOGIN_FORM);
    }



}
