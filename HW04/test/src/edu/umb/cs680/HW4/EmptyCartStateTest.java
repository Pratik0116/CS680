package edu.umb.cs680.HW4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class EmptyCartStateTest{

    ShoppingCart cart1 = new ShoppingCart();

    @Test
    void testInitialState(){
        assertEquals(true,cart1.getState() instanceof EmptyCartState);
        System.out.println(cart1.getState());
    }

    @Test
    void testEmptyStateAfterAddingItem(){
        cart1.addItem("Watch");
        assertNotEquals(true,cart1.getState() instanceof EmptyCartState);
    }

    @Test
    void testStateAfterRemovingOneItem(){
        cart1.addItem("Watch");
        cart1.addItem("Shoes");
        cart1.removeItem("Shoes");
        assertNotEquals(true, cart1.getState() instanceof EmptyCartState);
    }

    @Test
    void testStateAfterRemovingAllItems(){
        cart1.addItem("Watch");
        cart1.addItem("Shoes");
        cart1.removeItem("Shoes");
        cart1.removeItem("Watch");
        assertEquals(true, cart1.getState() instanceof EmptyCartState);
    }
}
