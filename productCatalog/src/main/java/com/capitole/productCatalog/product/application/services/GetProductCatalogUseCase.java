package com.capitole.productCatalog.product.application.services;

import com.capitole.productCatalog.product.application.models.GetProductCatalogCommand;
import com.capitole.productCatalog.product.domain.models.Discount;
import com.capitole.productCatalog.product.domain.models.Product;
import com.capitole.productCatalog.product.domain.repositories.DiscountRepository;
import com.capitole.productCatalog.product.domain.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetProductCatalogUseCase {

    private final ProductRepository repository;
    private final DiscountRepository discountRepository;

    public List<Product> execute(final GetProductCatalogCommand command) {
        List<Discount> discounts = discountRepository.search();
        List<Product> products = repository.findBy(
                command.getCategory(),
                command.getSorted(),
                command.getPage(),
                command.getSize()
        );
        return products.stream().map(product -> product.appliedDiscount(discounts)).toList();
    }
}
