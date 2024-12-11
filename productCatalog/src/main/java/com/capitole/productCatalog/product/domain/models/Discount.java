package com.capitole.productCatalog.product.domain.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public abstract class Discount {

    private final String id;
    private final int percentage;

    public abstract boolean isValid(Product product);

}
