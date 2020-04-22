package com.example.coffeeapp;

public class Order {
    //attributes of every order
    private int id;
    private String custName;
    private  int saleAmount;

    //default Constructor
    public Order() {
        id = 0;
        custName = null;
        saleAmount = 0;
    }

    //2nd Constructor
    public Order(String custName, int saleAmount){
        custName = custName;
        saleAmount = saleAmount;
    }

    //get methods
    public int get_id(){return id;}
    public String get_custName(){return custName;}
    public double get_saleAmount(){return saleAmount;}

    //set methods
    public void set_id(int id){id=id;}
    public void set_custName(String custName){custName = custName;}
    public void set_saleAmount(int saleAmount){saleAmount = saleAmount;}
}
