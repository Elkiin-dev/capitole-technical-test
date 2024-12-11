package com.capitole.productCatalog.product.application.services;

import com.capitole.productCatalog.product.application.models.GetProductCatalogCommand;
import com.capitole.productCatalog.product.application.models.GetProductCatalogCommandMother;
import com.capitole.productCatalog.product.domain.models.Product;
import com.capitole.productCatalog.product.domain.models.ProductMother;
import com.capitole.productCatalog.product.domain.models.discounts.ElectronicsDiscount;
import com.capitole.productCatalog.product.domain.models.discounts.HomeAndKitchenDiscount;
import com.capitole.productCatalog.product.domain.models.discounts.SKUsEndingFiveDiscount;
import com.capitole.productCatalog.product.domain.repositories.DiscountRepository;
import com.capitole.productCatalog.product.domain.repositories.ProductRepository;
import com.capitole.productCatalog.product.infraestructure.repositories.MemoryDiscountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class GetProductCatalogUseCaseTest {

    private final DiscountRepository discountRepository = new MemoryDiscountRepository();
    private final ProductRepository productRepository = Mockito.mock(ProductRepository.class);
    private final GetProductCatalogUseCase useCase = new GetProductCatalogUseCase(productRepository, discountRepository);

    @Test
    public void whenProductRepositoryReturnEmptyListReturnsEmptyList(){
        GetProductCatalogCommand command = GetProductCatalogCommandMother.basic();
        Mockito.when(productRepository.findBy(command.getCategory(),command.getSorted(),command.getPage(),command.getSize()))
                .thenReturn(Collections.emptyList());

        List<Product> products = useCase.execute(command);

        Assertions.assertEquals(Collections.emptyList(), products);
    }

    @Test
    public void whenProductRepositoryReturnElectronicProductThenReturnWithDiscountApplied(){
        GetProductCatalogCommand command = GetProductCatalogCommandMother.basic();
        Mockito.when(productRepository.findBy(command.getCategory(),command.getSorted(),command.getPage(),command.getSize()))
                .thenReturn(List.of(ProductMother.electronicProduct()));

        List<Product> products = useCase.execute(command);

        Assertions.assertEquals(1, products.size());
        Assertions.assertEquals(ProductMother.electronicProduct().getDescription(), products.get(0).getDescription());
        Assertions.assertEquals(ProductMother.electronicProduct().getCategory(), products.get(0).getCategory());
        Assertions.assertEquals(Optional.of(new ElectronicsDiscount()), products.get(0).getDiscountApplied());
    }

    @Test
    public void whenProductRepositoryReturnHomeAndKitchenProductThenReturnWithDiscountApplied(){
        GetProductCatalogCommand command = GetProductCatalogCommandMother.basic();
        Mockito.when(productRepository.findBy(command.getCategory(),command.getSorted(),command.getPage(),command.getSize()))
                .thenReturn(List.of(ProductMother.homeAndKitchenProduct()));

        List<Product> products = useCase.execute(command);

        Assertions.assertEquals(1, products.size());
        Assertions.assertEquals(ProductMother.homeAndKitchenProduct().getDescription(), products.get(0).getDescription());
        Assertions.assertEquals(ProductMother.homeAndKitchenProduct().getCategory(), products.get(0).getCategory());
        Assertions.assertEquals(Optional.of(new HomeAndKitchenDiscount()), products.get(0).getDiscountApplied());
    }

    @Test
    public void whenProductRepositoryReturnSkusEndingFiveThenReturnWithDiscountApplied(){
        GetProductCatalogCommand command = GetProductCatalogCommandMother.basic();
        Mockito.when(productRepository.findBy(command.getCategory(),command.getSorted(),command.getPage(),command.getSize()))
                .thenReturn(List.of(ProductMother.skuEndingFive()));

        List<Product> products = useCase.execute(command);

        Assertions.assertEquals(1, products.size());
        Assertions.assertEquals(ProductMother.skuEndingFive().getDescription(), products.get(0).getDescription());
        Assertions.assertEquals(ProductMother.skuEndingFive().getCategory(), products.get(0).getCategory());
        Assertions.assertEquals(Optional.of(new SKUsEndingFiveDiscount()), products.get(0).getDiscountApplied());
    }

}
