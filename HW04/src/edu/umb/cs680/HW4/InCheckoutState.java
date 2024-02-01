package edu.umb.cs680.HW4;

class InCheckoutState implements ShoppingCartState {

    private ShoppingCart context;

    public InCheckoutState(ShoppingCart context) {
        this.context = context;
    }

    @Override
    public void addItem(String item) {
        System.out.println("Cannot add items during checkout.");
    }

    @Override
    public void removeItem(String item) {
        System.out.println("Cannot remove items during checkout.");
    }

    @Override
    public void proceedToCheckout() {
        System.out.println("Already in checkout.");
    }

    @Override
    public void confirmOrder() {
        context.setState(new OrderedState(context));
        System.out.println("Order confirmed. Thank you!");
    }

}

