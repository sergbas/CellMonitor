package serg.apps.cellmonitor.presentation.presenter.base;

import serg.apps.cellmonitor.App;

/**
 * Created by Xieergai on 11.04.2018.
 */

public class BasePresenterWrapper {

//    @Inject
//    RealmComponent realmComponent;

    public BasePresenterWrapper() {
        App.getAppDaggerComponent().inject(this);
    }
}