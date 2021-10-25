package com.checkout.db.repository;

import com.checkout.db.ItemEntity;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class ItemRepositoryTest {
    private final ItemEntity IT1 = ItemData.buildItemEntityWithOffer("A",50L,3,130L);
    private final ItemEntity IT2 = ItemData.buildItemEntityWithOffer("B",30L,2,45L);

    @Test
    public void itemNotFound(){
        ItemRepository itemRepository = new ItemRepository();
        assertEquals(Optional.empty(),itemRepository.getItem("X"));
    }

    @Test
    public void canRetrieveItem(){
        ItemRepository itemRepository = new ItemRepository();
        assertEquals(Optional.of(IT1),itemRepository.getItem("A"));
    }

    @Test
    public void shouldReturnOneItemSameSku(){
        ItemRepository itemRepository = new ItemRepository();
        assertEquals(Collections.singletonList(IT1),itemRepository.getItems(Arrays.asList("A","A")));
    }

    @Test
    public void canRetrieveMultipleItems(){
        ItemRepository itemRepository = new ItemRepository();
        assertEquals(Arrays.asList(IT1,IT2),itemRepository.getItems(Arrays.asList("A","B")));
    }
}