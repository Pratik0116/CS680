package edu.umb.cs680.hw12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {

    private String[] carToStringArray(Car car1) {
        String[] carDetail = {car1.getMake(),car1.getModel(),Integer.toString(car1.getYear())};
        return carDetail;
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear1() throws Exception{
        Car actual = new Car("Ford", "Mustang",20, 2023, 41000);
        String[] expected = {"Ford", "Mustang","2023"};
        assertArrayEquals(expected,carToStringArray(actual));
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear2() throws Exception{
        Car actual = new Car("Toyota", "Supra",18, 2023, 39000);
        String[] expected = {"Toyota", "Supra","2023"};
        assertArrayEquals(expected,carToStringArray(actual));
    }
}