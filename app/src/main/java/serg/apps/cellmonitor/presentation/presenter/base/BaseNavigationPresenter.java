package serg.apps.cellmonitor.presentation.presenter.base;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

import ru.terrakok.cicerone.Router;
import serg.apps.cellmonitor.App;

/**
 * Created by Xieergai on 11.04.2018.
 */

public abstract class BaseNavigationPresenter<T extends MvpView> extends MvpPresenter<T> {

    private BaseNavigationPresenterWrapper baseNavigationPresenterWrapper;

    public BaseNavigationPresenter() {
        baseNavigationPresenterWrapper = new BaseNavigationPresenterWrapper();
        App.getNavigationDaggerComponent().inject(baseNavigationPresenterWrapper);
    }

    protected Router getRouter() {
        return baseNavigationPresenterWrapper.router;
    }

    protected Router getLocalRouter(String groupName) {
        return baseNavigationPresenterWrapper.localCiceroneHolder.getCicerone(groupName).getRouter();
    }

}