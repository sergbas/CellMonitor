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

//    @Inject
//    NetworkComponent networkComponent;

    public MainScreenPresenter() {
        App.getAppDaggerComponent().inject(this);
    }

    public void loadScreenData(boolean checkConnection) {
  /*      if (checkConnection && !networkComponent.isConnected()) {
            getViewState().showErrorToast(R.string.SYS_NOTE_NO_INTERNET, null);
        }
*/        getViewState().loadScreenData();
    }

    public void onClick_Avatar() {
        getViewState().showProfileScreen();
    }

    public void onClick_Index(boolean showDetails) {
        getViewState().toggleIndexDetails(showDetails);
    }

    public void onClick_Tasks(boolean showDetails) {
        getViewState().toggleTasksDetails(showDetails);
    }
}