package com.checkout.service;

import com.checkout.db.repository.ItemRepository;
import com.checkout.domain.Item;
import com.checkout.domainMapper.ItemMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ItemServiceImpl implements ItemService {
    ItemRepository itemRepository = new ItemRepository();

    @Override
    public List<Item> getItems(List<String> itemsSku) {
        return itemRepository.getItems(itemsSku).stream().map(itemEntity -> ItemMapper.toModel(itemEntity,itemsSku)).collect(Collectors.toList());
    }
}
