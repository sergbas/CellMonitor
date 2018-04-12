package serg.apps.cellmonitor.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;

import serg.apps.cellmonitor.presentation.presenter.base.BaseNavigationPresenter;
import serg.apps.cellmonitor.presentation.view.MainView;
import serg.apps.cellmonitor.ui.Screens;

/**
 * Created by Xieergai on 12.04.2018.
 */

@InjectViewState
public class MainPresenter extends BaseNavigationPresenter<MainView> {

    private boolean initialized = false;

    public void init() {
        if (!initialized) {
            getRouter().newRootScreen(Screens.MAIN_FORM);
            //getViewState().setSelectedBottomMenuItem(R.id.main);
            initialized = true;
        }
    }

    public void onBottomMenuClickItem_Main() {
        getRouter().navigateTo(Screens.MAIN_FORM);
    }

    public void onBottomMenuClickItem_Prescriptions() {
        getRouter().navigateTo(Screens.PRESCRIPTIONS);
    }

    public void onBottomMenuClickItem_Measurements() {
        getRouter().navigateTo(Screens.MEASUREMENTS);
    }

    public void onBottomMenuClickItem_Complaints() {
        getRouter().navigateTo(Screens.COMPLAINTS);
    }

    public void onBottomMenuClickItem_Questionnaire() {
        getRouter().navigateTo(Screens.INQUIRER);
    }

    public void onProfileImageClick_Profile(){
        getRouter().navigateTo(Screens.PROFILE_FORM);
    }

    public void onBottomMenuClickItem_Diary() {
        getRouter().navigateTo(Screens.DIARY_FORM);
    }


}
