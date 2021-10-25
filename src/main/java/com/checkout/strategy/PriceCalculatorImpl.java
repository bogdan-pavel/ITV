package com.checkout.strategy;

import com.checkout.domain.Item;

public class PriceCalculatorImpl implements PriceCalculator {

    @Override
    public Long calculateTotal(Item item) {
        if (item.getOffer() == null || item.getOffer().getQuantity() == null) {
            return item.getPrice() * item.getQuantity();
        }
        return totalPriceForOffer(item);
    }

    private long totalPriceForOffer(Item item) {
        Integer offerQuantity = item.getOffer().getQuantity();
        Long underOfferTotal = item.getQuantity() / offerQuantity * item.getOffer().getOfferPrice();
        Long standardTotal = item.getQuantity() % offerQuantity * item.getPrice();
        return underOfferTotal + standardTotal;
    }
}
