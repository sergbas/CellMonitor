package serg.apps.cellmonitor.presentation.presenter.base;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;
import serg.apps.cellmonitor.App;
import serg.apps.cellmonitor.navigation.LocalCiceroneHolder;

/**
 * Created by Xieergai on 11.04.2018.
 */

public class BaseNavigationPresenterWrapper {

    @Inject
    Router router;

    @Inject
    LocalCiceroneHolder localCiceroneHolder;

    public BaseNavigationPresenterWrapper() {
        App.getNavigationDaggerComponent().inject(this);
    }
}
