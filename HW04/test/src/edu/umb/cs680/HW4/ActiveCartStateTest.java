package edu.umb.cs680.HW4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ActiveCartStateTest {

    @Test
    void testActiveStateAfterAddingItem(){
        ShoppingCart cart1 = new ShoppingCart();
        cart1.addItem("Watch");
        boolean expected = true;
        assertEquals(expected,cart1.getState() instanceof ActiveCartState);
    }
}
