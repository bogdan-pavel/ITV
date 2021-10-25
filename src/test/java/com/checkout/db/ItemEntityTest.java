package com.checkout.db;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ItemEntityTest {
    @Test
    public void testEqualsSymmetric() {
        ItemEntity itemEntity = buildItem();
        ItemEntity itemEntity2 = buildItem();
        assertTrue(itemEntity.equals(itemEntity2) && itemEntity2.equals(itemEntity));
        assertTrue(itemEntity.hashCode() == itemEntity2.hashCode());

    }

    private ItemEntity buildItem() {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setSku("A");
        itemEntity.setPrice(50L);
        itemEntity.setOfferQuantity(3);
        itemEntity.setOfferPrice(130L);
        return itemEntity;
    }
}