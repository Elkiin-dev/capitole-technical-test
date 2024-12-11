package com.capitole.productCatalog.product.application.models;

import com.capitole.productCatalog.product.domain.models.Category;
import com.capitole.productCatalog.product.domain.models.ProductSorted;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GetProductCatalogCommand {
    private final Category category;
    private final ProductSorted sorted;
    private final int page;
    private final int size;
}
