package com.brainacad.bacookrecipes;

import android.app.Application;

import com.brainacad.bacookrecipes.dbrealm.DBCookbookMigration;
import com.brainacad.bacookrecipes.dbrealm.TransactionCookBook;


import io.realm.Realm;
import io.realm.RealmConfiguration;

public class BACookRecipesApp extends Application {

    public static final String NAME_DB = "DBCookbook.realm";
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name(NAME_DB)
                .schemaVersion(1)
                .migration(new DBCookbookMigration())
                .initialData(new TransactionCookBook())
                .build();
        Realm.setDefaultConfiguration(configuration);
    }
}
