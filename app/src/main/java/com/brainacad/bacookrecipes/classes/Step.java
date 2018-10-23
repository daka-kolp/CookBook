package com.brainacad.bacookrecipes.classes;

import java.util.UUID;

import io.realm.RealmObject;

public class Step extends RealmObject{

    private String idStep;
    private String descStep;

    public Step() {
        this.idStep = UUID.randomUUID().toString();
    }

    public Step(String descStep) {
        this();
        this.descStep = "\t" + descStep;
    }

    public String getDescStep() {
        return descStep;
    }

    public void setDescStep(String descStep) {
        this.descStep = descStep;
    }

    public String getIdStep() {
        return idStep;
    }
}
