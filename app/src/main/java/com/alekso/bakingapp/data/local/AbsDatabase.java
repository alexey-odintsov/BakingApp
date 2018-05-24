package com.alekso.bakingapp.data.local;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.alekso.bakingapp.AppExecutors;
import com.alekso.bakingapp.data.local.dao.RecipesDao;
import com.alekso.bakingapp.data.local.entity.RecipeEntity;

import java.util.List;

@Database(entities = {RecipeEntity.class}, version = 4)
public abstract class AbsDatabase extends RoomDatabase {
    private static final String DB_NAME = "bakingapp.db";
    @Nullable
    private static AbsDatabase instance;
    @NonNull
    private final MutableLiveData<Boolean> isCreated = new MutableLiveData<>();

    @NonNull
    public static AbsDatabase getInstance(@NonNull Context context, @NonNull AppExecutors executors) {
        if (instance == null) {
            synchronized (AbsDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context, AbsDatabase.class, DB_NAME)
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    Log.d("AbsDatabase", "onCreate");
                                    executors.diskIO().execute(() -> {
                                        AbsDatabase database = AbsDatabase.getInstance(context, executors);
                                        database.runInTransaction(() -> {
                                            List<RecipeEntity> recipes = Mock.generate(20);
                                            database.recipesDao().insertAll(recipes);
                                            database.setCreated();
                                        });
                                    });
                                }
                            }).build();
                    instance.updateDatabaseCreated(context.getApplicationContext());
                }
            }
        }
        return instance;
    }

    private void updateDatabaseCreated(@NonNull Context context) {
        if (context.getDatabasePath(DB_NAME).exists()) {
            setCreated();
        }
    }

    private void setCreated() {
        isCreated.postValue(true);
    }

    @NonNull
    public LiveData<Boolean> isCreated() {
        return isCreated;
    }

    public abstract RecipesDao recipesDao();
}
