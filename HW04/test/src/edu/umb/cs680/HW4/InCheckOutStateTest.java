package edu.umb.cs680.HW4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InCheckOutStateTest {

    private ShoppingCart cart;

    @Test
    void testProceedToCheckOutBeforeAddingItem(){
        cart = new ShoppingCart();
        cart.proceedToCheckout();
        boolean expected = false;
        assertEquals(expected, cart.getState() instanceof InCheckoutState);
    }
    @Test
    void testProceedToCheckOutAfterAddingItem(){
        cart = new ShoppingCart();
        cart.addItem("Watch");
        cart.proceedToCheckout();
        boolean expected = true;
        assertEquals(expected, cart.getState() instanceof InCheckoutState);
    }
}
