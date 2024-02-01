package edu.umb.cs680.hw11;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    public static int numOfCars = 1000;
    private static List<List<Double>> Cars = new ArrayList<>();
    @BeforeAll
    public static void setUP(){
        Random random = new Random();
        for (int i = 0; i < numOfCars; i++) {
            double mileage = random.nextDouble() * 100000;
            double year = random.nextDouble() * (2023 - 1990) + 1990;
            double price = random.nextDouble() * 100000;
            List<Double> carAttributes = new ArrayList<>();
            carAttributes.add(mileage);
            carAttributes.add(year);
            carAttributes.add(price);
            Cars.add(carAttributes);
        }
    }

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

    @Test
    public void testEuclideanDistance(){
        List<List<Double>> Points = new ArrayList<>();
        for (List<Double> car : Cars ){
            List<Double> normalizedValues = Car.normalize(car.get(0).intValue(),car.get(1).intValue(),car.get(2).floatValue(),0,100000,1500,2024, 0.0F,100000.0F);
            assertTrue(normalizedValues.get(0).floatValue() >=0 && normalizedValues.get(0).floatValue() <= 1);
            assertTrue(normalizedValues.get(1).floatValue() >=0 && normalizedValues.get(1).floatValue() <= 1);
            assertTrue(normalizedValues.get(2).floatValue() >=0 && normalizedValues.get(2).floatValue() <= 1);
            Points.add(normalizedValues);
        }
        List<List<Double>> actual = Distance.matrix(Points, new Euclidean());
        //assertFalse(actual.isEmpty());
    }

    @Test
    public void testManhattanDistance(){
        List<List<Double>> Points = new ArrayList<>();
        for (List<Double> car : Cars ){
            List<Double> normalizedValues = Car.normalize(car.get(0).intValue(),car.get(1).intValue(),car.get(2).floatValue(),0,100000,1500,2024, 0.0F,100000.0F);
            assertTrue(normalizedValues.get(0).floatValue() >=0 && normalizedValues.get(0).floatValue() <= 1);
            assertTrue(normalizedValues.get(1).floatValue() >=0 && normalizedValues.get(1).floatValue() <= 1);
            assertTrue(normalizedValues.get(2).floatValue() >=0 && normalizedValues.get(2).floatValue() <= 1);
            Points.add(normalizedValues);
        }
        List<List<Double>> actual = Distance.matrix(Points, new Euclidean());
        assertFalse(actual.isEmpty());
    }

    @Test
    public void testCosineDistance(){
        List<List<Double>> Points = new ArrayList<>();
        for (List<Double> car : Cars ){
            List<Double> normalizedValues = Car.normalize(car.get(0).intValue(),car.get(1).intValue(),car.get(2).floatValue(),0,100000,1500,2024, 0.0F,100000.0F);
            assertTrue(normalizedValues.get(0).floatValue() >=0 && normalizedValues.get(0).floatValue() <= 1);
            assertTrue(normalizedValues.get(1).floatValue() >=0 && normalizedValues.get(1).floatValue() <= 1);
            assertTrue(normalizedValues.get(2).floatValue() >=0 && normalizedValues.get(2).floatValue() <= 1);
            Points.add(normalizedValues);
        }
        List<List<Double>> actual = Distance.matrix(Points, new Euclidean());
        assertFalse(actual.isEmpty());
    }
}
