package org.capitole.prices.api.unit.dto.exception;

import org.capitole.prices.api.dto.exception.ExceptionResponseDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExceptionResponseDTOUnitTest {

    private ExceptionResponseDTO target1, target2, target3;

    private final int STATUS = 500;
    private final String MESSAGE = "An error occurred when processing the request";
    private final String ERROR_CODE = "SERVER_ERROR";

    @Before
    public void setUp() {
        target1 = new ExceptionResponseDTO();
        target2 = new ExceptionResponseDTO(404, "not_found", "not_found");
    }

    @Test
    public void noArgs_and_allArgs_constructors_test() {
        Assert.assertNotNull(target1);
        Assert.assertNotNull(target2);
    }

    @Test
    public void getters_and_setters_test() {
        target1.setStatus(STATUS);
        target1.setMessage(MESSAGE);
        target1.setErrorCode(ERROR_CODE);

        Assert.assertEquals(target1.getStatus(), STATUS);
        Assert.assertEquals(target1.getMessage(), MESSAGE);
        Assert.assertEquals(target1.getErrorCode(), ERROR_CODE);
    }

    @Test
    public void builder_test() {
        target3 = ExceptionResponseDTO
            .builder()
            .status(STATUS)
            .message(MESSAGE)
            .errorCode(ERROR_CODE)
            .build();

        Assert.assertEquals(target3.getStatus(), STATUS);
        Assert.assertEquals(target3.getMessage(), MESSAGE);
        Assert.assertEquals(target3.getErrorCode(), ERROR_CODE);
    }
}
