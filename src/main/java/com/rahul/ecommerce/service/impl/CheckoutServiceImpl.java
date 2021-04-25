package com.rahul.ecommerce.service.impl;

import com.rahul.ecommerce.dao.CustomerRepository;
import com.rahul.ecommerce.dto.Purchase;
import com.rahul.ecommerce.dto.PurchaseResponse;
import com.rahul.ecommerce.entity.Customer;
import com.rahul.ecommerce.entity.Order;
import com.rahul.ecommerce.entity.OrderItem;
import com.rahul.ecommerce.service.CheckoutService;
import com.sun.org.apache.xml.internal.resolver.readers.OASISXMLCatalogReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Order order = purchase.getOrder();

        String trackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(trackingNumber);

        //populate order with order items
        Set<OrderItem> orderItems = purchase.getOrderItems();
        order.setOrderItems(orderItems);

        order.setShippingAddress(purchase.getShippingAddress());
        order.setBillingAddress(purchase.getBillingAddress());

        //populate customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);

        customerRepository.save(customer);

        return new PurchaseResponse(trackingNumber);
    }

    private String generateOrderTrackingNumber() {

        return UUID.randomUUID().toString() ;
    }
}
