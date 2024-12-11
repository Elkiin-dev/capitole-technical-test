package com.capitole.productCatalog.product.domain.repositories;

import com.capitole.productCatalog.product.domain.models.Discount;

import java.util.List;

public interface DiscountRepository {
    List<Discount> search();
}
