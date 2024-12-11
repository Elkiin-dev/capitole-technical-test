package com.capitole.productCatalog.product.application.models;

import com.capitole.productCatalog.product.domain.models.Category;
import com.capitole.productCatalog.product.domain.models.ProductSorted;

public class GetProductCatalogCommandMother {

    public static GetProductCatalogCommand basic (){
        return new GetProductCatalogCommand(Category.ACCESSORIES, ProductSorted.CATEGORY, 1, 1);
    }
}
