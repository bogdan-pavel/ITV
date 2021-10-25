package com.checkout.service;

import com.checkout.domain.Item;

import java.util.List;

public interface ItemService {
    List<Item> getItems(List<String> itemsName);
}
