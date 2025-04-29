package com.d288.awilliams.services;

import com.d288.awilliams.dao.CartRepository;
import com.d288.awilliams.dao.CustomerRepository;
import com.d288.awilliams.entities.Cart;
import com.d288.awilliams.entities.CartItem;
import com.d288.awilliams.entities.Customer;
import com.d288.awilliams.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

import static com.d288.awilliams.entities.StatusType.ordered;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CartRepository cartRepository;

    @Autowired
    public CheckoutServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }
    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Cart cart = purchase.getCart();



        String orderTrackingNumber = generateOrderTrackingNumber();

        cart.setOrderTrackingNumber(orderTrackingNumber);

        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> cart.add(item));

        cart.setStatus(ordered);

        cartRepository.save(cart);

        Customer customer = purchase.getCustomer();
        customer.add(cart);

        if(cart.getCartItems() != null) {
            return new PurchaseResponse(orderTrackingNumber);
        }

        return new PurchaseResponse("Cart is Empty!");

    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
