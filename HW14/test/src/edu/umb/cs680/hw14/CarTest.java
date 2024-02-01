package edu.umb.cs680.hw14;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    static List<Car> carList = new ArrayList<Car>();

    @BeforeAll
    static void setUp() throws Exception {
        carList.add(new Car("Honda", "Civic", 30, 2020, 21000));
        carList.add(new Car("Honda", "Accord", 28, 2019, 19000));
        carList.add(new Car("Ford", "Mustang", 23, 2017, 41000));
        carList.add(new Car("Toyota", "Camry", 28, 2015, 22000));
        carList.add(new Car("Toyota", "Highlander", 19, 2021, 75000));
    }

    @Test
    public void ParetoComparatorTest() {
        for (Car car : carList) {
            car.setDominationCount((ArrayList<Car>) carList);
        }
        Collections.sort(carList, (Car c1, Car c2) -> c1.getDominationCount() - c2.getDominationCount());
        assertEquals(19000, carList.get(0).getPrice());
        assertEquals(21000, carList.get(1).getPrice());
    }

    @Test
    public void MileageComparatorTest() {
        Collections.sort(carList,(Car c1, Car c2) -> c1.getMileage()-c2.getMileage());
        assertEquals(19,carList.get(0).getMileage());
        assertEquals(23, carList.get(1).getMileage());
    }

    @Test
    public void PriceComparatorTest() {
        Collections.sort(carList,(Car c1, Car c2) -> (int) (c1.getPrice() - c2.getPrice()));
        assertEquals(19000,carList.get(0).getPrice());
        assertEquals(21000, carList.get(1).getPrice());
    }


    @Test
    public void yearComparatorTest() {
        Collections.sort(carList,(Car c1, Car c2) -> c1.getYear() - c2.getYear());
        assertEquals(2015, carList.get(0).getYear());
        assertEquals(2017, carList.get(1).getYear());
    }
}
