package com.alekso.bakingapp.data.local;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.alekso.bakingapp.AppExecutors;
import com.alekso.bakingapp.data.local.dao.RecipesDao;
import com.alekso.bakingapp.data.local.entity.RecipeEntity;

import java.util.ArrayList;
import java.util.List;

@Database(entities = {RecipeEntity.class}, version = 1)
public abstract class AbsDatabase extends RoomDatabase {
    private static final String DB_NAME = "bakingapp.db";
    private static AbsDatabase instance;

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
                                    executors.diskIO().execute(() -> {
                                        AbsDatabase database = AbsDatabase.getInstance(context, executors);
                                        database.runInTransaction(() -> {
                                            List<RecipeEntity> recipes = Mock.generate(20);
                                            database.recipesDao().insertAll(recipes);
                                        });
                                    });
                                }
                            }).build();
                    //instance.updateDatabaseCreated(context.getApplicationContext());
                }
            }
        }
        return instance;
    }

    public abstract RecipesDao recipesDao();
}
