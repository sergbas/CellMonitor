package serg.apps.cellmonitor.di;

import javax.inject.Singleton;

import dagger.Component;
import serg.apps.cellmonitor.di.module.ContextModule;
import serg.apps.cellmonitor.di.module.GooglePlayServicesModule;
import serg.apps.cellmonitor.di.module.PreferencesModule;
import serg.apps.cellmonitor.presentation.presenter.MainScreenPresenter;
import serg.apps.cellmonitor.presentation.presenter.base.BasePresenterWrapper;

/**
 * Created by Xieergai on 11.04.2018.
 */
@Component(modules = {
        ContextModule.class,
        PreferencesModule.class,
//        ServerModule.class,
//        NetworkModule.class,
        GooglePlayServicesModule.class,
         })
@Singleton
public interface AppDaggerComponent {

    //base presenters
    void inject(BasePresenterWrapper basePresenterWrapper);
//    void inject(BaseApiWrapper baseApiWrapper);

    //presenters for activity
//    void inject(LoginPresenter loginPresenter);

    //presenters for fragments
    void inject(MainScreenPresenter mainScreenPresenter);


    //other
//    void inject(SignInPresenter signInPresenter);


    //adapters
//    void inject(DiaryNoteAdapter diaryNoteAdapter);



}