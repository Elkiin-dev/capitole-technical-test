package com.capitole.productCatalog.product.domain.models.discounts;

import com.capitole.productCatalog.product.domain.models.Category;
import com.capitole.productCatalog.product.domain.models.Discount;
import com.capitole.productCatalog.product.domain.models.Product;


public class ElectronicsDiscount extends Discount {

    private static final String ID = "ElectronicsDiscount";
    private static final int PERCENTAGE = 15;

    public ElectronicsDiscount() {
        super(ID, PERCENTAGE);
    }

    @Override
    public boolean isValid(Product product) {
        return Category.ELECTRONICS.equals(product.getCategory());
    }

}
