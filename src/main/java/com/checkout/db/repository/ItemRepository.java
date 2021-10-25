package com.checkout.db.repository;

import com.checkout.db.ItemEntity;
import com.checkout.db.session.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class ItemRepository {
    static{
        ItemData.insertData();
    }
    public Optional<ItemEntity> getItem(String sku) {
        Session session = SessionUtil.getSession();
        Query query = session.createQuery("from ItemEntity where sku = :sku");
        query.setParameter("sku", sku);
        List<ItemEntity> results = (List<ItemEntity>) query.list();
        return results != null && !results.isEmpty() ? Optional.of(results.get(0)) : Optional.empty();
    }

    public List<ItemEntity> getItems(List<String> skus){
        List<String> distinctSkus = skus.stream().distinct().collect(Collectors.toList());
        Session session = SessionUtil.getSession();
        Query query = session.createQuery("from ItemEntity where sku in :skus");
        query.setParameter("skus", distinctSkus);
        List<ItemEntity> results = (List<ItemEntity>) query.list();
        return results != null && !results.isEmpty() ? results : Collections.emptyList();

    }
}