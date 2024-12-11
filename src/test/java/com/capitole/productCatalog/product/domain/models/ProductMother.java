package com.capitole.productCatalog.product.domain.models;

import com.capitole.productCatalog.shared.domain.models.Sku;

import java.util.Optional;

public class ProductMother {
    public static Product electronicProduct() {
        return new Product(
                new Sku(),
                15,
                "Electric Guitar Starter Pack",
                Category.ELECTRONICS,
                Optional.empty());
    }

    public static Product homeAndKitchenProduct() {
        return new Product(
                new Sku(),
                50,
                "Stainless Steel Cutlery Set, 24 Pieces",
                Category.HOME_KITCHEN,
                Optional.empty());
    }

    public static Product skuEndingFive() {
        return new Product(
                new Sku("SKU0005"),
                50,
                "Stainless Steel Cutlery Set, 24 Pieces",
                Category.HOME_KITCHEN,
                Optional.empty());
    }
}
