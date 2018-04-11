package serg.apps.cellmonitor.navigation;

import javax.inject.Inject;

import ru.terrakok.cicerone.NavigatorHolder;
import serg.apps.cellmonitor.App;

/**
 * Created by Xieergai on 11.04.2018.
 */

public class LocalNavigationWrapper {

    @Inject
    LocalCiceroneHolder localCiceroneHolder;

    public LocalNavigationWrapper() {
        App.getNavigationDaggerComponent().inject(this);
    }

    public NavigatorHolder getHolder(String groupName) {
        return localCiceroneHolder.getCicerone(groupName).getNavigatorHolder();
    }
}