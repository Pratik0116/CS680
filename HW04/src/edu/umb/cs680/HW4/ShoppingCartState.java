package edu.umb.cs680.HW4;

public interface ShoppingCartState{
    void addItem(String item);
    void removeItem(String item);
    void proceedToCheckout();
    void confirmOrder();
}
