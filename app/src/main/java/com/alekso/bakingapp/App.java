package com.alekso.bakingapp;

import android.app.Application;
import android.support.annotation.NonNull;

import com.alekso.bakingapp.data.DataRepository;
import com.alekso.bakingapp.data.local.AbsDatabase;

public class App extends Application {
    @NonNull
    private AppExecutors executors;

    @Override
    public void onCreate() {
        super.onCreate();
        executors = new AppExecutors();
    }

    @NonNull
    public AbsDatabase getDatabase() {
        return AbsDatabase.getInstance(this, executors);
    }

    @NonNull
    public DataRepository getRepository() {
        return DataRepository.getInstance(getDatabase());
    }
}
