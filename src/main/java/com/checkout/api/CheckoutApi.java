package com.checkout.api;

import com.checkout.domain.Basket;
import com.checkout.service.CheckoutService;
import com.checkout.service.CheckoutServiceImpl;
import com.checkout.validation.ValidSequence;

import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/checkout")
public class CheckoutApi {
    private CheckoutService checkoutService = new CheckoutServiceImpl();

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Response checkout(@NotNull @ValidSequence List<String> skus) {
        Basket checkout = checkoutService.checkout(skus);
        return Response.ok().entity(checkout).build();
    }
}
