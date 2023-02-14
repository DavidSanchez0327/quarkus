package org.test.domain.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class Numbers {

    private List<Integer> listNumbers;
}
