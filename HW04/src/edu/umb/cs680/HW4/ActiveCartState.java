package edu.umb.cs680.HW4;

import java.util.ArrayList;
import java.util.List;

class ActiveCartState implements ShoppingCartState {

    private ShoppingCart context;

    public ActiveCartState(ShoppingCart context) {
        this.context = context;
    }

    @Override
    public void addItem(String item) {
        if(context.getItems().contains(item)){
            System.out.println("Item is already in the cart");
        }else {
            context.getItems().add(item);
            System.out.println("Added " + item + " to the cart.");
        }
    }

    @Override
    public void removeItem(String item) {
        context.getItems().remove(item);
        if (context.getItems().isEmpty()) {
            context.setState(new EmptyCartState(context));
            System.out.println("Cart is now empty.");
        } else {
            System.out.println("Removed " + item + " from the cart.");
        }
    }

    @Override
    public void proceedToCheckout() {
        context.setState(new InCheckoutState(context));
        System.out.println("Proceeding to checkout...");
    }

    @Override
    public void confirmOrder() {
        System.out.println("Cannot confirm order. Checkout first.");
    }

}
