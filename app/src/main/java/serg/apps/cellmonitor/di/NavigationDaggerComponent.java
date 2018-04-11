package serg.apps.cellmonitor.di;

import javax.inject.Singleton;

import dagger.Component;
import serg.apps.cellmonitor.di.module.NavigationModule;
import serg.apps.cellmonitor.navigation.LocalNavigationWrapper;
import serg.apps.cellmonitor.presentation.presenter.base.BaseNavigationPresenterWrapper;
import serg.apps.cellmonitor.ui.activity.base.AppBaseActivity;

/**
 * Created by Xieergai on 11.04.2018.
 */

@Component(modules = NavigationModule.class)
@Singleton
public interface NavigationDaggerComponent {
    void inject(BaseNavigationPresenterWrapper baseNavigationPresenterWrapper);

    void inject(AppBaseActivity appBaseActivity);

    void inject(LocalNavigationWrapper localNavigationWrapper);
}
