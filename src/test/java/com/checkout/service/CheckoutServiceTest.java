package com.checkout.service;

import com.checkout.domain.Basket;
import com.checkout.domain.Item;
import com.checkout.domain.Offer;
import com.checkout.strategy.PriceCalculator;
import com.checkout.utils.ItemUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.FieldSetter;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;

import static java.util.Collections.emptyList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutServiceTest {
    @Mock
    ItemService itemServiceMock;
    @Mock
    PriceCalculator priceCalculatorMock;
    CheckoutService  checkoutService = new CheckoutServiceImpl();

    @Test
    public void shouldAcceptEmptyList() {
        Basket basket = checkoutService.checkout(emptyList());
        assertThat(basket.getTotal(), equalTo(0L));
        assertEquals(basket.getItemList(), emptyList());
    }

    @Test
    public void shouldCheckoutForOneItem() throws NoSuchFieldException {
        FieldSetter.setField(checkoutService, checkoutService.getClass().getDeclaredField("itemService"), itemServiceMock);
        FieldSetter.setField(checkoutService, checkoutService.getClass().getDeclaredField("priceCalculator"), priceCalculatorMock);
        Item itemA = ItemUtil.getItem("A", 50L, 4, new Offer(3, 130L));
        when(itemServiceMock.getItems(Collections.singletonList("A"))).thenReturn(Collections.singletonList(itemA));
        when(priceCalculatorMock.calculateTotal(itemA)).thenReturn(180L);
        Basket basket = checkoutService.checkout(Collections.singletonList("A"));
        assertEquals(basket.getTotal(),new Long(180L));
        assertEquals(basket.getItemList().size(), 1);
        assertEquals(basket.getItemList().get(0),itemA);
    }

    @Test
    public void shouldCheckoutForMultipleItems() throws NoSuchFieldException {
        FieldSetter.setField(checkoutService, checkoutService.getClass().getDeclaredField("itemService"), itemServiceMock);
        FieldSetter.setField(checkoutService, checkoutService.getClass().getDeclaredField("priceCalculator"), priceCalculatorMock);
        Item itemA = ItemUtil.getItem("A", 50L, 4, new Offer(3, 130L));
        Item itemC = ItemUtil.getItemNoOffer("C", 20L, 2);
        when(itemServiceMock.getItems(Arrays.asList("A","C"))).thenReturn(Arrays.asList(itemA,itemC));
        when(priceCalculatorMock.calculateTotal(itemA)).thenReturn(180L);
        when(priceCalculatorMock.calculateTotal(itemC)).thenReturn(40L);
        Basket basket = checkoutService.checkout(Arrays.asList("A","C"));
        assertEquals(basket.getTotal(), new Long(220L));
        assertEquals(basket.getItemList().size(), 2);
        assertEquals(basket.getItemList().get(0),itemA);
        assertEquals(basket.getItemList().get(1),itemC);
    }

}