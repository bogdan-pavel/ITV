package com.checkout.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class ItemEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    private String sku;

    @Column
    private Long price;

    @Column
    private Integer offerQuantity;

    @Column
    private Long offerPrice;

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setOfferQuantity(Integer offerQuantity) {
        this.offerQuantity = offerQuantity;
    }

    public void setOfferPrice(Long offerPrice) {
        this.offerPrice = offerPrice;
    }

    public String getSku() {
        return sku;
    }

    public Long getPrice() {
        return price;
    }

    public Integer getOfferQuantity() {
        return offerQuantity;
    }

    public Long getOfferPrice() {
        return offerPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemEntity that = (ItemEntity) o;
        return Objects.equals(sku, that.sku)
                && Objects.equals(price, that.price)
                && Objects.equals(offerQuantity, that.offerQuantity)
                && Objects.equals(offerPrice, that.offerPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, price, offerQuantity, offerPrice);
    }
}
