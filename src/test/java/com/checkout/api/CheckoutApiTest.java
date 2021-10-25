package com.checkout.api;

import com.checkout.exception.mapper.ValidationExceptionMapper;
import com.checkout.service.CheckoutService;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.FieldSetter;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

public class CheckoutApiTest extends JerseyTest {
    private static final CheckoutApi API = new CheckoutApi();
    @Mock
    public CheckoutService checkoutServiceMock = Mockito.mock(CheckoutService.class);

    @Override
    protected Application configure() {
        return new ResourceConfig(ValidationExceptionMapper.class).register(API);
    }

    @Before
    public void initMocks() throws NoSuchFieldException {
        FieldSetter.setField(API, API.getClass().getDeclaredField("checkoutService"), checkoutServiceMock);
    }

    @Test
    public void failsIfInvalidSku() {
        List<String> skuList = Arrays.asList("a");
        Response response = target("checkout").request().post(Entity.entity(skuList, MediaType.APPLICATION_JSON));
        Assert.assertEquals(400, response.getStatus());
        Assert.assertEquals("Only single uppercase alpha characters are accepted: [A-Z]", response.readEntity(String.class));
    }

    @Test
    public void failsIfInvalidNotSingleCharSku() {
        List<String> skuList = Arrays.asList("AA");
        Response response = target("checkout").request().post(Entity.entity(skuList, MediaType.APPLICATION_JSON));
        Assert.assertEquals(400, response.getStatus());
        Assert.assertEquals("Only single uppercase alpha characters are accepted: [A-Z]", response.readEntity(String.class));
    }

    @Test
    public void failsIfInvalidEmptyStringSku() {
        List<String> skuList = Arrays.asList("");
        Response response = target("checkout").request().post(Entity.entity(skuList, MediaType.APPLICATION_JSON));
        Assert.assertEquals(400, response.getStatus());
        Assert.assertEquals("Only single uppercase alpha characters are accepted: [A-Z]", response.readEntity(String.class));
    }
}