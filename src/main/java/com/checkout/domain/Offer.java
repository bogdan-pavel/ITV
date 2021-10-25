package com.checkout.domain;

import java.util.Objects;

public class Offer {
    Integer quantity;
    Long offerPrice;

    public Offer(Integer quantity, Long offerPrice) {
        this.quantity = quantity;
        this.offerPrice = offerPrice;
    }
    //used for testing assert
    public Offer() {
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Long getOfferPrice() {
        return offerPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer that = (Offer) o;
        return Objects.equals(quantity, that.quantity) && Objects.equals(offerPrice, that.offerPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, offerPrice);
    }
}
