package Mypack.Controllers;


import javafx.fxml.FXML;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    // Define the static array field
    private static List<PartData> dataArray = new ArrayList<>();
    private static List<PartData.UserData> dataArray2 = new ArrayList<>();

    public static void addToArray(int id, String part, String model, double price) {
        // Create a new PartData object and add it to the array
        PartData data = new PartData(id, part, model, price);
        dataArray.add(data);
        // Iterate through the dataArray list and print each element

    }
    public static void printArray() {
        for (PartData data : dataArray) {
            System.out.println("id: " + data.getId() + ", part: " + data.getPartType() + ", model: " + data.getModel() + ", price: " + data.getPrice());
        }
    }

    public static void addToArray2(String Name, String Email){
        PartData.UserData user = new PartData.UserData(Name, Email);
        dataArray2.add(user);

    }
    public static List<PartData> getDataArray() {
        return dataArray;
    }
    // ...
}

// Custom object class to hold the id, model, and price data
class PartData {

    private int id;

    private String model;

    private String partType;

    private double price;

    public String getPartType() {
        return partType;
    }

    public PartData(int id, String part, String model, double price) {
        this.id = id;
        this.partType = part;
        this.model = model;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {

        return price;
    }



    static class UserData{
        private String Name;
        private String Email;

        public UserData(String name, String email) {
            Name = name;
            Email = email;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String email) {
            Email = email;
        }
    }
}