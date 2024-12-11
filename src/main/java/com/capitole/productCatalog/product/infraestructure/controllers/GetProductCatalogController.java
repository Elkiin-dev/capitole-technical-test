package com.capitole.productCatalog.product.infraestructure.controllers;

import com.capitole.productCatalog.product.application.models.GetProductCatalogCommand;
import com.capitole.productCatalog.product.application.services.GetProductCatalogUseCase;
import com.capitole.productCatalog.product.domain.models.Category;
import com.capitole.productCatalog.product.domain.models.Product;
import com.capitole.productCatalog.product.domain.models.ProductSorted;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetProductCatalogController {

    private final GetProductCatalogUseCase useCase;

    @GetMapping(value = "/products")
    public List<Product> handle(
            @RequestParam(name = "sorted", required = false, defaultValue = "Category") final String sorted,
            @RequestParam(name = "category", required = false, defaultValue = "None") final String category,
            @RequestParam(name = "page", required = false, defaultValue = "0") final int page,
            @RequestParam(name = "size", required = false, defaultValue = "15") final int size
    ) {
        GetProductCatalogCommand command = new GetProductCatalogCommand(
                Category.fromString(category),
                ProductSorted.fromString(sorted),
                page,
                size
        );
        return this.useCase.execute(command);
    }
}
