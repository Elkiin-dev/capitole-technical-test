package com.capitole.productCatalog.product.domain.models;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Category {
    ELECTRONICS("Electronics"),
    HOME_KITCHEN("Home & Kitchen"),
    CLOTHING("Clothing"),
    ACCESSORIES("Accessories"),
    SPORTS("Sports"),
    MUSICAL_INSTRUMENTS("Musical Instr."),
    FOOTWEAR("Footwear"),
    HOME_APPLIANCES("Home Appliances"),
    STATIONERY("Stationery"),
    TOYS_GAMES("Toys & Games"),
    INVALID("Invalid"),
    NONE("None");


    private final String value;

    public static Category fromString(String value){
        for (Category category : Category.values()){
            if(category.value.equalsIgnoreCase(value)){
                return category;
            }
        }
        throw new RuntimeException();
    }

    public static Category fromStringLazy(String value){
        for (Category category : Category.values()){
            if(category.value.equalsIgnoreCase(value)){
                return category;
            }
        }
        return Category.INVALID;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
