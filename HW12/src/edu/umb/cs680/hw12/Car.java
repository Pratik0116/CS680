package edu.umb.cs680.hw12;

import java.util.ArrayList;

public class Car {

    private String make, model;
    private int mileage, year, dominationCount;
    private float price;

    public Car(String make, String model, int mileage, int year, float price) {
        super();
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.year = year;
        this.price = price;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public int getMileage() {
        return this.mileage;
    }

    public int getYear() {
        return this.year;
    }

    public float getPrice() {
        return this.price;
    }

    public void setDominationCount(ArrayList<Car> cars) {
        for (Car otherCar : cars) {
            if ((otherCar.getYear() >= this.getYear() && otherCar.getMileage() >= this.getMileage() && otherCar.getPrice() <= this.getPrice())
                    && (otherCar.getYear() > this.getYear() || otherCar.getMileage() > this.getMileage() || otherCar.getPrice() < this.getPrice())) {
                dominationCount++;
            }
        }
    }

    public int getDominationCount() {
        return this.dominationCount;
    }

}