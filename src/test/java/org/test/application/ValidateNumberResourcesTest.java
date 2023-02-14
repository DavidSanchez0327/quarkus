package org.test.application;

import io.smallrye.mutiny.Multi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.test.application.dto.NumbersDTO;
import org.test.application.entrypoint.ValidateNumberResources;
import org.test.domain.model.Numbers;
import org.test.domain.usecase.ValidateNumberUseCase;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


public class ValidateNumberResourcesTest {
    @Mock
    ValidateNumberUseCase validateNumberUseCase;

    @InjectMocks
    ValidateNumberResources validateNumberResources;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testValidateNumberEndpoint() {

        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(4);
        numberList.add(5);
        numberList.add(6);
        List<Integer> numberListResponse = new ArrayList<>();
        numberListResponse.add(3);
        numberListResponse.add(4);
        numberListResponse.add(9);
        numberListResponse.add(8);
        numberListResponse.add(15);
        numberListResponse.add(12);

        Multi<List<Integer>> out = Multi.createFrom().item(numberListResponse);

        when(validateNumberUseCase.processValidatorNumber(Numbers.builder().listNumbers(numberList).build())).thenReturn(out);

        validateNumberResources.validateNumbers(NumbersDTO.builder().listNumbers(numberList).build())
                .subscribe()
                .with(integerList -> Assertions.assertEquals(integerList, numberListResponse));

    }

}