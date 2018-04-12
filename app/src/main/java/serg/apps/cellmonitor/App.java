package serg.apps.cellmonitor;

import android.app.Application;
import android.content.Context;

import serg.apps.cellmonitor.di.AppDaggerComponent;
import serg.apps.cellmonitor.di.DaggerAppDaggerComponent;
import serg.apps.cellmonitor.di.DaggerNavigationDaggerComponent;
import serg.apps.cellmonitor.di.NavigationDaggerComponent;
import serg.apps.cellmonitor.di.module.ContextModule;
import serg.apps.cellmonitor.di.module.GooglePlayServicesModule;
import serg.apps.cellmonitor.di.module.LocationModule;
import serg.apps.cellmonitor.di.module.NavigationModule;
import serg.apps.cellmonitor.di.module.PreferencesModule;
import serg.apps.cellmonitor.utils.ApplicationLifecycleManager;

/**
 * Created by Xieergai on 11.04.2018.
 */

public class App extends Application {
    private static final String TAG = App.class.getSimpleName();

    private static AppDaggerComponent appDaggerComponent;
    private static NavigationDaggerComponent navigationDaggerComponent;

    public static AppDaggerComponent getAppDaggerComponent() {
        return appDaggerComponent;
    }
    public static NavigationDaggerComponent getNavigationDaggerComponent() {
        return navigationDaggerComponent;
    }

    private static App instance;

    public static Context getAppContext(){
        return instance.getApplicationContext();
    }

    @Override
    public void onCreate() {
        instance = this;

        super.onCreate();

        registerActivityLifecycleCallbacks(new ApplicationLifecycleManager());
        //dagger
        appDaggerComponent = buildAppComponent();
        navigationDaggerComponent = buildNavigationComponent();
    }

    protected AppDaggerComponent buildAppComponent() {
        return DaggerAppDaggerComponent.builder()
                .contextModule(new ContextModule(this))
//                .preferencesModule(new PreferencesModule())
//                .serverModule(new ServerModule())
//                .networkModule(new NetworkModule())
                .googlePlayServicesModule(new GooglePlayServicesModule())
                .locationModule(new LocationModule())
                .build();
    }

    protected NavigationDaggerComponent buildNavigationComponent() {
        return DaggerNavigationDaggerComponent.builder()
                .navigationModule(new NavigationModule())
                .build();
    }

    public static synchronized App getInstance(){
        return instance;
    }


}

