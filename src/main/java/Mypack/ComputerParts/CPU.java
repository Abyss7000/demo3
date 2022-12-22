package Mypack.ComputerParts;

import Mypack.Database;

public class CPU extends Database {
    private int idCPU;
    private String CPU_Brand;
    private String CPU_Model;
    private double CPU_Price;
    private int CPU_Amount;

    private static String part = "CPU";

    public static String getPart() {
        return part;
    }

    public CPU(int idCPU, String CPU_Brand, String CPU_Model, double CPU_Price, int CPU_Amount) {
        this.idCPU = idCPU;
        this.CPU_Brand = CPU_Brand;
        this.CPU_Model = CPU_Model;
        this.CPU_Price = CPU_Price;
        this.CPU_Amount = CPU_Amount;
    }

    public CPU() {

    }

    public int getIdCPU() {
        return idCPU;
    }

    public String getCPU_Brand() {
        return CPU_Brand;
    }

    public String getCPU_Model() {
        return CPU_Model;
    }

    public double getCPU_Price() {
        return CPU_Price;
    }

    public int getCPU_Amount() {
        return CPU_Amount;
    }
}