package edu.umb.cs680.HW4;

public class OrderedState implements ShoppingCartState{
    private ShoppingCart context;

    public OrderedState(ShoppingCart context) {
        this.context = context;
    }

    @Override
    public void addItem(String item) {
        System.out.println("Cannot add items after order is confirmed.");
    }

    @Override
    public void removeItem(String item) {
        System.out.println("Cannot remove items after order is confirmed.");
    }

    @Override
    public void proceedToCheckout() {
        System.out.println("Order already confirmed.");
    }

    @Override
    public void confirmOrder() {
        System.out.println("Order already confirmed.");
    }
}
