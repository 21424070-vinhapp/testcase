package com.example.myapplication;

public class RAM {
    private String branch;
    private String speed;

    public String getBranch() { return branch; }
    public void setBranch(String value) { this.branch = value; }

    public String getSpeed() { return speed; }
    public void setSpeed(String value) { this.speed = value; }

    @Override
    public String toString() {
        return "RAM{" +
                "branch='" + branch + '\'' +
                ", speed='" + speed + '\'' +
                '}';
    }
}