package serg.apps.cellmonitor.di.module;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import serg.apps.cellmonitor.component.PreferencesComponent;

/**
 * Created by Xieergai on 11.04.2018.
 */

@Module
public class PreferencesModule {

    @Provides
    @NonNull
    @Singleton
    PreferencesComponent providePreferencesComponent(@NonNull Context context) {
        return new PreferencesComponent(context);
    }


}
