package edu.umb.cs680.HW4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderedStateTest {

    private ShoppingCart cart;

    @BeforeEach
    void setUp(){
        cart = new ShoppingCart();
        cart.addItem("Shoes");
        cart.proceedToCheckout();
        cart.confirmOrder();
    }

    @Test
    void testAddingItems(){
        boolean expected = false;
        assertEquals(expected,cart.getState() instanceof ActiveCartState);
    }

    @Test
    void testProceedToCheckOutState(){
        boolean expected = false;
        assertEquals(expected,cart.getState() instanceof InCheckoutState);
    }

    @Test
    void verifyOrderedState(){
        boolean expected = true;
        assertEquals(expected,cart.getState() instanceof OrderedState);
    }
}

