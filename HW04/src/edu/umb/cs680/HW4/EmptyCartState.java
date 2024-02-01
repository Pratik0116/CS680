package edu.umb.cs680.HW4;

public class EmptyCartState implements ShoppingCartState {
    private ShoppingCart context;

    public EmptyCartState(ShoppingCart context) {
        this.context = context;
    }

    @Override
    public void addItem(String item) {
        context.getItems().add(item);
        System.out.println("Added " + item + " to the cart.");
        context.setState(new ActiveCartState(context));
    }

    @Override
    public void removeItem(String item) {
        System.out.println("Cart is already empty.");
    }

    @Override
    public void proceedToCheckout() {
        System.out.println("Cannot proceed to checkout. Cart is empty.");
    }

    @Override
    public void confirmOrder() {
        System.out.println("Cannot confirm order. Cart is empty.");
    }
}
