package com.capitole.productCatalog.shared.domain.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Random;

@Getter
@RequiredArgsConstructor
public class Sku {
    private static final Random random = new Random();
    private final String value;

    public Sku (){
        this.value = "SKU00" + (random.nextInt(89)+10);
    }

    public char lastChar(){
        return value.charAt(value.length()-1);
    }


}
