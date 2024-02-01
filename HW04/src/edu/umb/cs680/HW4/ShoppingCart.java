package edu.umb.cs680.HW4;

import java.util.LinkedList;
import java.util.List;

public class ShoppingCart {

    private List<String> items;
    private ShoppingCartState currentState;


    public ShoppingCart() {
        items = new LinkedList<>();
        currentState = new EmptyCartState(this); // Initial state
    }

    public void setState(ShoppingCartState state) {
        this.currentState = state;
    }

    public ShoppingCartState getState() {
        return currentState;
    }

    public List<String> getItems() {
        return items;
    }

    public void addItem(String item) {
        currentState.addItem(item);
    }

    public void removeItem(String item) {
        currentState.removeItem(item);
    }

    public void proceedToCheckout() {
        currentState.proceedToCheckout();
    }

    public void confirmOrder() {
        currentState.confirmOrder();
    }

    public void removeAllItems() {
        items.clear();
        currentState = new EmptyCartState(this);
        System.out.println("Cart is now empty.");
    }
}
