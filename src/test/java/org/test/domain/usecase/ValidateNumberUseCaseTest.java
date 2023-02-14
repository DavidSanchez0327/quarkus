package org.test.domain.usecase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.test.domain.model.Numbers;

import java.util.ArrayList;
import java.util.List;

public class ValidateNumberUseCaseTest {

    @InjectMocks
    ValidateNumberUseCase validateNumberUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void validateNumberTest() {

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

        validateNumberUseCase.processValidatorNumber(Numbers.builder().listNumbers(numberList).build())
                .subscribe()
                .with(integerList -> Assertions.assertEquals(integerList, numberListResponse));
    }
}
