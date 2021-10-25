package com.checkout.service;

import com.checkout.domain.Basket;

import java.util.List;

public interface CheckoutService {

    Basket checkout(List<String> itemNames);
}
