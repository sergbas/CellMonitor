package serg.apps.cellmonitor.di.module;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Xieergai on 11.04.2018.
 */

@Module
public class ContextModule {

    private Context context;

    public ContextModule(@NonNull Context context) {
        this.context = context;
    }

    @Provides
    @NonNull
    @Singleton
    Context provideContext() {
        return context;
    }

}
