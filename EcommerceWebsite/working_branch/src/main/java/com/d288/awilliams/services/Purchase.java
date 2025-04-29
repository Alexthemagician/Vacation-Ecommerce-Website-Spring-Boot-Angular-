package com.d288.awilliams.services;

import com.d288.awilliams.entities.Cart;
import com.d288.awilliams.entities.CartItem;
import com.d288.awilliams.entities.Customer;


import java.util.Set;


public class Purchase {

    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
