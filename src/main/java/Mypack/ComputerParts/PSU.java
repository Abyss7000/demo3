package Mypack.ComputerParts;

import Mypack.Database;

public class PSU extends Database {
    private int id;
    private String BrandName;
    private String Model;
    private double Price;
    private int Quantity;

    private static String part = "PSU";

    public static String getPart() {
        return part;
    }

    public int getId() {
        return id;
    }

    public String getBrandName() {
        return BrandName;
    }

    public String getModel() {
        return Model;
    }

    public double getPrice() {
        return Price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public PSU(int id, String brandName, String model, double price, int quantity) {
        this.id = id;
        BrandName = brandName;
        Model = model;
        Price = price;
        Quantity = quantity;
    }
}
