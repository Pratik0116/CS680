package edu.umb.cs680.hw01;

import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

public class PrimeGeneratorTest {
    PrimeGenerator prime;

    @Test
    public void verifyExpectedPrimes() throws Exception {
        prime = new PrimeGenerator(1, 100);
        prime.generatePrimes();
        Long[] expectedNum = { 2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L, 41L, 43L, 47L, 53L, 59L, 61L, 67L, 71L, 73L, 79L, 83L, 89L, 97L};
        assertArrayEquals(expectedNum, prime.getPrimes().toArray());
    }

    @Test
    public void verifyExpectedPrimes2() throws Exception {
        prime = new PrimeGenerator(15, 80);
        prime.generatePrimes();
        Long[] expectedNum = { 17L, 19L, 23L, 29L, 31L, 37L, 41L, 43L, 47L, 53L, 59L, 61L, 67L, 71L, 73L, 79L};
        assertArrayEquals(expectedNum, prime.getPrimes().toArray());
    }

    @Test
    public void verifyUserInputs() throws Exception {
        try {
            prime = new PrimeGenerator(-10, 5);
        } catch (InputMismatchException ex) {
            assertEquals("Wrong input values: -10 to 5", ex.getMessage());
        }
    }
}