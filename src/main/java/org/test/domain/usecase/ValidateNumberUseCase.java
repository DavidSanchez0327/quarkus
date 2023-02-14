package org.test.domain.usecase;


import io.smallrye.mutiny.Multi;
import org.test.domain.model.Numbers;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;


@ApplicationScoped
public class ValidateNumberUseCase {

    public Multi<List<Integer>> processValidatorNumber(Numbers numbers) {
        return Multi.createFrom().iterable(numbers.getListNumbers())
                .map(number -> (number % 2 == 0) ? number * 2 : number * 3)
                .collect().asList().toMulti();
    }
}
