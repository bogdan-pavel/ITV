package com.checkout.db.repository;

import com.checkout.db.ItemEntity;
import com.checkout.db.session.SessionUtil;
import org.hibernate.Session;

public class ItemData {
    public static void insertData() {
        Session session = SessionUtil.getSession();
        session.beginTransaction();

        session.save(buildItemEntityWithOffer("A", 50L, 3, 130L));
        session.save(buildItemEntityWithOffer("B", 30L, 2, 45L));
        session.save(buildItemEntityNoOffer("C", 20L));
        session.save(buildItemEntityNoOffer("D", 15L));

        session.getTransaction().commit();
        session.close();
    }

    public static ItemEntity buildItemEntityWithOffer(String sku, Long price, Integer offerQuantity, Long offerPrice) {
        ItemEntity itemEntity = buildItemEntityNoOffer(sku,price);
        itemEntity.setOfferQuantity(offerQuantity);
        itemEntity.setOfferPrice(offerPrice);
        return itemEntity;
    }

    public static ItemEntity buildItemEntityNoOffer(String sku, Long price) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setSku(sku);
        itemEntity.setPrice(price);
        return itemEntity;
    }

}
