package com.webmingo.serviingovendors.model;

public class StateModel {
    String id;
    String name;
    String country_id;

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public StateModel() {
    }

       public StateModel(String id, String name) {
            this.id = id;
            this.name = name;
        }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
