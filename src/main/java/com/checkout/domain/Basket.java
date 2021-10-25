package com.checkout.domain;

import java.util.List;
import java.util.Objects;

public class Basket {

    private List<Item> itemList;
    private Long total;

    public Basket(List<Item> itemList, Long total) {
        this.itemList = itemList;
        this.total = total;
    }
    //used by testing assert
    public Basket(){}

    public List<Item> getItemList() {
        return itemList;
    }

    public Long getTotal() {
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Objects.equals(itemList, basket.itemList) && Objects.equals(total, basket.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemList, total);
    }
}
