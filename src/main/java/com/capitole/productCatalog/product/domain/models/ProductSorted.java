package com.capitole.productCatalog.product.domain.models;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ProductSorted {

    SKU("SKU"),
    PRICE("Price"),
    DESCRIPTION("Description"),
    CATEGORY("Category");

    private final String value;

    public static ProductSorted fromString(String value){
        for (ProductSorted category : ProductSorted.values()){
            if(category.value.equalsIgnoreCase(value)){
                return category;
            }
        }
        return ProductSorted.CATEGORY;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
