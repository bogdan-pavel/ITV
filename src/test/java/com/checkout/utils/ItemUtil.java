package com.checkout.utils;

import com.checkout.db.ItemEntity;
import com.checkout.db.repository.ItemData;
import com.checkout.domain.Item;
import com.checkout.domain.Offer;

public class ItemUtil {

    public static Item getItem(String sku, Long price, Integer quantity, Offer offer) {
        Item item = getItemNoOffer(sku, price, quantity);
        item.setOfferPrice(offer);
        return item;
    }

    public static Item getItemNoOffer(String sku, Long price, Integer quantity) {
        Item item = new Item();
        item.setSku(sku);
        item.setPrice(price);
        item.setQuantity(quantity);
        return item;
    }

    public static ItemEntity buildItemEntity() {
        return ItemData.buildItemEntityWithOffer("A", 50L, 3, 130L);
    }
}
