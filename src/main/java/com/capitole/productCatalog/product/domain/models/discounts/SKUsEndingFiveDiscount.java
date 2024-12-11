package com.capitole.productCatalog.product.domain.models.discounts;

import com.capitole.productCatalog.product.domain.models.Discount;
import com.capitole.productCatalog.product.domain.models.Product;


public class SKUsEndingFiveDiscount extends Discount {

    private static final String ID = "SKUsEndingFiveDiscount";
    private static final int PERCENTAGE = 30;
    private static final char END_CHARACTER = '5';

    public SKUsEndingFiveDiscount() {
        super(ID, PERCENTAGE);
    }

    @Override
    public boolean isValid(Product product)  {
        return END_CHARACTER == product.getSku().lastChar();
    }
}
