package com.checkout.domainMapper;

import com.checkout.db.ItemEntity;
import com.checkout.domain.Item;
import com.checkout.domain.Offer;

import java.util.List;

public final class ItemMapper {

    public static Item toModel(ItemEntity itemEntity, List<String> itemssku) {
        Item item = new Item();
        item.setSku(itemEntity.getSku());
        item.setPrice(itemEntity.getPrice());
        item.setQuantity(countSimilarItemsInRequest(itemEntity, itemssku));
        item.setOfferPrice(prepareOfferPrice(itemEntity));
        return item;
    }

    private static Offer prepareOfferPrice(ItemEntity itemEntity) {
        if (itemEntity.getOfferQuantity() != null) {
            return new Offer(itemEntity.getOfferQuantity(), itemEntity.getOfferPrice());
        }
        return null;
    }

    private static Integer countSimilarItemsInRequest(ItemEntity itemEntity, List<String> itemssku) {
        return ((Long) itemssku.stream().filter(sku -> sku.equals(itemEntity.getSku())).count()).intValue();
    }


}
