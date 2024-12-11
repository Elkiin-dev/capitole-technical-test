package com.capitole.productCatalog.product.infraestructure.repositories;

import com.capitole.productCatalog.product.domain.models.Discount;
import com.capitole.productCatalog.product.domain.models.Product;
import com.capitole.productCatalog.product.domain.models.discounts.ElectronicsDiscount;
import com.capitole.productCatalog.product.domain.models.discounts.HomeAndKitchenDiscount;
import com.capitole.productCatalog.product.domain.models.discounts.SKUsEndingFiveDiscount;
import com.capitole.productCatalog.product.domain.repositories.DiscountRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class MemoryDiscountRepository implements DiscountRepository {

    private static final List<Discount> list =List.of(
            new ElectronicsDiscount(),
            new HomeAndKitchenDiscount(),
            new SKUsEndingFiveDiscount()
    );

    @Override
    public List<Discount> search() {
        return new ArrayList<>(list).stream()
                .sorted(Comparator.comparingInt(Discount::getPercentage).reversed())
                .toList();
    }
}
