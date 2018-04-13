package serg.apps.cellmonitor.presentation.presenter.base;

import serg.apps.cellmonitor.App;

/**
 * Created by Xieergai on 11.04.2018.
 */

public class BasePresenterWrapper {
    public BasePresenterWrapper() {
        App.getAppDaggerComponent().inject(this);
    }
}