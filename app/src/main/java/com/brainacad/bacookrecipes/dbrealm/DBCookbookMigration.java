package com.brainacad.bacookrecipes.dbrealm;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

public class DBCookbookMigration implements RealmMigration {
    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema schema = realm.getSchema();
        if(oldVersion == 1){
            schema.get("Recipe")
                    .addField("timeAddingToFavourite", long.class);
        }
    }
}
