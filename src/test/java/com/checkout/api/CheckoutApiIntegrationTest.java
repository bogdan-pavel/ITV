package com.checkout.api;

import com.checkout.domain.Basket;
import com.checkout.domain.Item;
import com.checkout.domain.Offer;
import com.checkout.exception.mapper.ValidationExceptionMapper;
import com.checkout.utils.ItemUtil;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CheckoutApiIntegrationTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(CheckoutApi.class, ValidationExceptionMapper.class);
    }


    @Test
    public void acceptEmptyListSkus() {
        List<String> emptyList = Collections.emptyList();
        Response response = target("checkout").request().post(Entity.entity(emptyList, MediaType.APPLICATION_JSON));
        Assert.assertEquals(200, response.getStatus());
        Assert.assertEquals(emptyBasket(), response.readEntity(Basket.class));
    }

    @Test
    public void canComputeTotalPrice() {
        List<String> skus = Arrays.asList("A");
        Response response = target("checkout").request().post(Entity.entity(skus, MediaType.APPLICATION_JSON));
        Assert.assertEquals(200, response.getStatus());
        Assert.assertEquals(createBasket(), response.readEntity(Basket.class));
    }

    private Basket emptyBasket() {
        return new Basket(Collections.emptyList(), 0L);
    }

    private Basket createBasket(){
        Item itemA = ItemUtil.getItem("A", 50L, 1, new Offer(3, 130L));
        return new Basket(Arrays.asList(itemA),50L);
    }
}
