package com.capitole.productCatalog.product.domain.models.discounts;

import com.capitole.productCatalog.product.domain.models.Category;
import com.capitole.productCatalog.product.domain.models.Discount;
import com.capitole.productCatalog.product.domain.models.Product;


public class HomeAndKitchenDiscount extends Discount {

    private static final String ID = "HomeAndKitchenDiscount";
    private static final int PERCENTAGE = 25;

    public HomeAndKitchenDiscount() {
        super(ID, PERCENTAGE);
    }

    @Override
    public boolean isValid(Product product) {
        return Category.HOME_KITCHEN.equals(product.getCategory());
    }
}
