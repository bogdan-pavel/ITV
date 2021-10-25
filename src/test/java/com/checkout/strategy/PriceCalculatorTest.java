package com.checkout.strategy;

import com.checkout.domain.Item;
import com.checkout.domain.Offer;
import com.checkout.utils.ItemUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PriceCalculatorTest {
    PriceCalculator priceCalculator = new PriceCalculatorImpl();

    @Test
    public void shouldReturnNoOfferPrice() {
        Item itemNoOffer = ItemUtil.getItemNoOffer("C", 20L, 2);
        assertEquals(new Long(40), priceCalculator.calculateTotal(itemNoOffer));
    }

    @Test
    public void shouldReturnTotalPrice() {
        Item item = ItemUtil.getItem("A", 50L, 2, new Offer(3, 130L));
        assertEquals(new Long(100), priceCalculator.calculateTotal(item));
    }

    @Test
    public void shouldReturnTotalPriceWithEligibleOffer() {
        Item item = ItemUtil.getItem("A", 50L, 4, new Offer(3, 130L));
        assertEquals(new Long(180), priceCalculator.calculateTotal(item));
    }
}