package com.checkout.strategy;

import com.checkout.domain.Item;

public interface PriceCalculator {
    Long calculateTotal(Item item);
}
