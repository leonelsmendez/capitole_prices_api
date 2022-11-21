package org.capitole.prices.api.unit.handler;

import org.capitole.prices.api.controller.PricesController;
import org.capitole.prices.api.handler.CustomExceptionHandler;
import org.capitole.prices.api.service.IPricesService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = { CustomExceptionHandler.class, PricesController.class })
public class CustomExceptionHandlerUnitTest {

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        IPricesService service = mock(IPricesService.class);
        when(service.getFinalPrice(any(), any(), any())).thenThrow(new RuntimeException("There was an error."));
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(new PricesController(service))
                .setControllerAdvice(CustomExceptionHandler.class).build();
    }

    @Test
    public void when_exceptionIsThrown_handler_managesIt() throws Exception {
        this.mockMvc.perform(get("/prices/final_price")
            .param("startDate", "2020-06-14T10:00:00Z")
            .param("productId", "1")
            .param("brandId", "1"))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("message").value("There was an error."))
                .andExpect(jsonPath("errorCode").value("SERVER_ERROR"));
    }
}
