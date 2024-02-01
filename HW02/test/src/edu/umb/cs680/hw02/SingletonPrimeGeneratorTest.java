package edu.umb.cs680.hw02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.LinkedList;

public class SingletonPrimeGeneratorTest {

    SingletonPrimeGenerator prime;
    @Test
    void verifyNotNull(){
        try {
            SingletonPrimeGenerator s1 = SingletonPrimeGenerator.getInstance();
            Assertions.assertNotNull(s1);
        }catch (RuntimeException e){
            System.out.println("Can not get instance");
        }
    }

    @Test
    void verifyNotSame(){
        try {
            SingletonPrimeGenerator s1 = SingletonPrimeGenerator.getInstance();
            SingletonPrimeGenerator s2 = SingletonPrimeGenerator.getInstance();
            Assertions.assertSame(s1,s2);
        }catch (RuntimeException e){
            System.out.println("Instance is not same");
        }
    }

    @Test
    void verifyExpectedOutput1(){
        try{
            SingletonPrimeGenerator prime = new SingletonPrimeGenerator();
            if (prime.verifyUserInput(1,100)){
                prime.generatePrimes();
            }
            Long[] expectedNum = { 2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L, 41L, 43L, 47L, 53L, 59L, 61L, 67L, 71L, 73L, 79L, 83L, 89L, 97L};
            LinkedList<Long> expected = new LinkedList<Long>();
            Collections.addAll(expected, expectedNum);
            Assertions.assertIterableEquals(prime.getPrimes(),expected);
        }catch (RuntimeException e){
            System.out.println("Output is not same");
        }
    }

    @Test
    void verifyExpectedOutput2(){
        try{
            SingletonPrimeGenerator prime = new SingletonPrimeGenerator();
            if (prime.verifyUserInput(15,80)){
                prime.generatePrimes();
            }
            Long[] expectedNum = { 17L, 19L, 23L, 29L, 31L, 37L, 41L, 43L, 47L, 53L, 59L, 61L, 67L, 71L, 73L, 79L};
            LinkedList<Long> expected = new LinkedList<Long>();
            Collections.addAll(expected, expectedNum);
            Assertions.assertIterableEquals(prime.getPrimes(),expected);
        }catch (RuntimeException e){
            System.out.println("Output is not same");
        }
    }
    @Test
    void verifyInput1(){
        try{
            prime = new SingletonPrimeGenerator();
            prime.verifyUserInput(-10,10);
        }catch (InputMismatchException e){
            System.out.println(e);
        }
    }

    @Test
    void verifyInput2(){
        try{
            prime = new SingletonPrimeGenerator();
            prime.verifyUserInput(1,10);
        }catch (InputMismatchException e){
            System.out.println(e);
        }
    }

    @Test
    void verifyInput3(){
        try{
            prime = new SingletonPrimeGenerator();
            prime.verifyUserInput(100,1);
        }catch (InputMismatchException e){
            System.out.println(e);
        }
    }
}
