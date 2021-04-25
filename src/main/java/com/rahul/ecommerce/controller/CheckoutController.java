package com.rahul.ecommerce.controller;

import com.rahul.ecommerce.dto.Purchase;
import com.rahul.ecommerce.dto.PurchaseResponse;
import com.rahul.ecommerce.service.CheckoutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/checkout")
@Slf4j
public class CheckoutController {

    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
        log.debug("Entering into CheckoutController.placeOrder method");
        PurchaseResponse response= checkoutService.placeOrder(purchase);
        log.debug("Entering into CheckoutController.placeOrder method");
        return response;
    }
}
