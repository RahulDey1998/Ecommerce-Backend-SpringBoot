package com.rahul.ecommerce.dto;

import com.rahul.ecommerce.entity.Address;
import com.rahul.ecommerce.entity.Customer;
import com.rahul.ecommerce.entity.Order;
import com.rahul.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
