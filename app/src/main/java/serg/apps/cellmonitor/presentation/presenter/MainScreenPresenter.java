package serg.apps.cellmonitor.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import serg.apps.cellmonitor.App;
import serg.apps.cellmonitor.R;
import serg.apps.cellmonitor.presentation.presenter.base.BaseNavigationPresenter;
import serg.apps.cellmonitor.presentation.view.MainScreenView;

/**
 * Created by Xieergai on 11.04.2018.
 */

@InjectViewState
public class MainScreenPresenter extends BaseNavigationPresenter<MainScreenView> {

    public MainScreenPresenter() {
        App.getAppDaggerComponent().inject(this);
    }

    public void loadScreenData(boolean checkConnection) {
        getViewState().loadScreenData();
    }

}