package com.example.myapplication;

import java.util.Arrays;

public class Specifications {
    private String os;
    private String hdd;
    private RAM[] ram;

    public String getOS() { return os; }
    public void setOS(String value) { this.os = value; }

    public String getHDD() { return hdd; }
    public void setHDD(String value) { this.hdd = value; }

    public RAM[] getRAM() { return ram; }
    public void setRAM(RAM[] value) { this.ram = value; }

    @Override
    public String toString() {
        return "Specifications{" +
                "os='" + os + '\'' +
                ", hdd='" + hdd + '\'' +
                ", ram=" + Arrays.toString(ram) +
                '}';
    }
}