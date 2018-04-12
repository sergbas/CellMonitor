package serg.apps.cellmonitor.di.module;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import serg.apps.cellmonitor.component.GooglePlayServicesComponent;
import serg.apps.cellmonitor.component.LocationComponent;

/**
 * Created by Xieergai on 11.04.2018.
 */

@Module
public class LocationModule {
    @Provides
    @NonNull
    @Singleton
    LocationComponent provideLocationComponent(@NonNull Context context, @NonNull GooglePlayServicesComponent googlePlayServicesComponent) {
        return new LocationComponent(context, googlePlayServicesComponent);
    }
}
