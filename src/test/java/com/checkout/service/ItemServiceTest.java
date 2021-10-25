package com.checkout.service;

import com.checkout.db.repository.ItemRepository;
import com.checkout.domain.Item;
import com.checkout.domain.Offer;
import com.checkout.utils.ItemUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.FieldSetter;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

    @Mock
    ItemRepository itemRepositoryMock;
    ItemService itemService = new ItemServiceImpl();

    @Test
    public void shouldReturnASingleItemModel() throws NoSuchFieldException {
        FieldSetter.setField(itemService, itemService.getClass().getDeclaredField("itemRepository"), itemRepositoryMock);
        when(itemRepositoryMock.getItems(Arrays.asList("A", "A"))).thenReturn(Collections.singletonList(ItemUtil.buildItemEntity()));
        List<Item> items = itemService.getItems(Arrays.asList("A", "A"));
        assertEquals(1,items.size());
        Item item = ItemUtil.getItem("A", 50L, 2, new Offer(3, 130L));
        assertEquals(item,items.get(0));
    }

}