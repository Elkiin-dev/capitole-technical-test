package com.capitole.productCatalog.product.domain.models;

import com.capitole.productCatalog.shared.domain.models.Sku;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Getter
@RequiredArgsConstructor
public class Product {
    private final Sku sku;
    private final float price;
    private final String description;
    private final Category category;
    private final Optional<Discount>  discountApplied;

    private float discountPrice(float percentage) {
        return price - (price * (percentage / 100));
    }

    public Product appliedDiscount(List<Discount> discounts) {
        for (Discount discount : discounts) {
            if (discount.isValid(this)) {
                return new Product(this.sku, discountPrice(discount.getPercentage()), this.description, this.category, Optional.of(discount));
            }
        }
        return this;
    }
}
