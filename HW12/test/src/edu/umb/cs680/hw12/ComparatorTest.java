package edu.umb.cs680.hw12;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparatorTest {
    static List<Car> CarList = new ArrayList<Car>();

    @BeforeAll
    static void setUp() throws Exception {
        CarList.add(new Car("Honda", "City", 26, 2019, 21000));
        CarList.add(new Car("Honda", "Accord", 24, 2018, 21000));
        CarList.add(new Car("Ford", "Mustang", 18, 2020, 41000));
        CarList.add(new Car("Toyota", "Supra", 17, 2017, 42000));
        CarList.add(new Car("Toyota", "Highlander", 29, 2022, 66000));

        for (Car car : CarList) {
            car.setDominationCount((ArrayList<Car>) CarList);
        }
    }

    @Test
    public void MileageComparatorTest() {
        Collections.sort(CarList,new MileageComparator());

        assertEquals(17, CarList.get(0).getMileage());
        assertEquals(18, CarList.get(1).getMileage());
        assertEquals(24, CarList.get(2).getMileage());
        assertEquals(26, CarList.get(3).getMileage());
        assertEquals(29, CarList.get(4).getMileage());

    }

    @Test
    public void ParetoComparatorTest() {
        Collections.sort(CarList, new ParetoComparator());

        assertEquals(42000, CarList.get(0).getPrice());
        assertEquals(21000, CarList.get(1).getPrice());
    }


    @Test
    public void PriceComparatorTest() {

        Collections.sort(CarList,new PriceComparator());

        assertEquals(21000, CarList.get(0).getPrice());
        assertEquals(21000, CarList.get(1).getPrice());
        assertEquals(41000,CarList.get(2).getPrice());
        assertEquals(42000, CarList.get(3).getPrice());
        assertEquals(66000, CarList.get(4).getPrice());
    }

    @Test
    public void YearComparatorTest() {

        Collections.sort(CarList,new YearComparator());

        assertEquals(2017, CarList.get(0).getYear());
        assertEquals(2018, CarList.get(1).getYear());
        assertEquals(2019,CarList.get(2).getYear());
        assertEquals(2020, CarList.get(3).getYear());
        assertEquals(2022, CarList.get(4).getYear());
    }

}
