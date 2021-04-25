package com.rahul.ecommerce.service;

import com.rahul.ecommerce.dto.Purchase;
import com.rahul.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
