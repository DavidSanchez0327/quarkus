package org.test.application.entrypoint;

import io.smallrye.mutiny.Multi;
import org.test.application.dto.NumbersDTO;
import org.test.domain.model.Numbers;
import org.test.domain.usecase.ValidateNumberUseCase;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/v1")
@Produces(MediaType.APPLICATION_JSON)
public class ValidateNumberResources {


    @Inject
    ValidateNumberUseCase validateNumberUseCase;

    @POST
    @Path("/validateNumber")
    public Multi<List<Integer>> validateNumbers(NumbersDTO numbersDTO) {
        return validateNumberUseCase.processValidatorNumber(Numbers.builder().listNumbers(numbersDTO.getListNumbers()).build());
    }
}