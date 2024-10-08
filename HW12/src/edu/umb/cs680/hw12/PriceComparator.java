package edu.umb.cs680.hw12;

import java.util.Comparator;

public class PriceComparator implements Comparator<Car> {

    @Override
    public int compare(Car c1, Car c2) {
        return (int) (c1.getPrice() - c2.getPrice());
    }
}
