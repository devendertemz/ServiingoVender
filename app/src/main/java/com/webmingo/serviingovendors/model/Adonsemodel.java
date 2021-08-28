package com.webmingo.serviingovendors.model;

public class Adonsemodel {

   public String id, name, amount, discount, after_discount;

    public Adonsemodel(String id, String name, String amount, String discount, String after_discount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.discount = discount;
        this.after_discount = after_discount;
    }
}
