package com.checkout.service;

import com.checkout.domain.Basket;
import com.checkout.domain.Item;
import com.checkout.strategy.PriceCalculator;
import com.checkout.strategy.PriceCalculatorImpl;

import java.util.List;

public class CheckoutServiceImpl implements CheckoutService {

    ItemService itemService = new ItemServiceImpl();
    PriceCalculator priceCalculator = new PriceCalculatorImpl();

    @Override
    public Basket checkout(List<String> itemNames) {
        List<Item> itemList = itemService.getItems(itemNames);
        return  new Basket(itemList, getTotal(itemList));
    }

    private Long getTotal(List<Item> itemList) {
        return itemList.stream().mapToLong(item -> priceCalculator.calculateTotal(item)).sum();
    }
}
