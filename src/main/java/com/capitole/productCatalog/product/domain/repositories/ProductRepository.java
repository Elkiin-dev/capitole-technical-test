package com.capitole.productCatalog.product.domain.repositories;

import com.capitole.productCatalog.product.domain.models.Category;
import com.capitole.productCatalog.product.domain.models.Product;
import com.capitole.productCatalog.product.domain.models.ProductSorted;

import java.util.List;

public interface ProductRepository {

    List<Product> findBy(
            final Category category,
            final ProductSorted sorted,
            final int page,
            final int size
    );

}
