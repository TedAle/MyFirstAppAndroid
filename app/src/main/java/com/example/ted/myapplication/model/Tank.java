package com.example.ted.myapplication.model;

/**
 * Created by Ted on 07/03/2016.
 */
public class Tank {

    private String id;
    private String name;
    private String nation;
    private String classe;
    private String tier;
    private String shield;
    private String firePower;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getNation() {
        return nation;
    }

    public String getClasse() {
        return classe;
    }

    public String getTier() {
        return tier;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getShield() {
        return shield;
    }

    public void setShield(String shield) {
        this.shield = shield;
    }

    public String getFirePower() {
        return firePower;
    }

    public void setFirePower(String firePower) {
        this.firePower = firePower;
    }

    @Override
    public String toString() {
        return "Tank{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nation='" + nation + '\'' +
                ", classe='" + classe + '\'' +
                ", tier='" + tier + '\'' +
                ", shield='" + shield + '\'' +
                ", firePower='" + firePower + '\'' +
                '}';
    }
}
