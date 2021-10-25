package com.checkout.domain;

import java.util.Objects;

public class Item {

    private String sku;
    private Long price;
    private Integer quantity;
    private Offer offer;

    public String getSku() {
        return sku;
    }

    public Long getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setOfferPrice(Offer offer) {
        this.offer = offer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(sku, item.sku) && Objects.equals(price, item.price) && Objects.equals(quantity, item.quantity) && Objects.equals(offer, item.offer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, price, quantity, offer);
    }
}
