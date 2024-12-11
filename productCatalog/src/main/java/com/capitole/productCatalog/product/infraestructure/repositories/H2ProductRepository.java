package com.capitole.productCatalog.product.infraestructure.repositories;

import com.capitole.productCatalog.product.domain.models.Category;
import com.capitole.productCatalog.product.domain.models.Product;
import com.capitole.productCatalog.product.domain.repositories.ProductRepository;
import com.capitole.productCatalog.product.infraestructure.mappers.ProductRowMapper;
import com.capitole.productCatalog.product.domain.models.ProductSorted;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class H2ProductRepository implements ProductRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final ProductRowMapper mapper;

    @Override
    public List<Product> findBy(Category category, ProductSorted sorted, int page, int size) {
        String sql = "SELECT * FROM Products WHERE Category = :category OR :category = 'None' " +
                "ORDER BY %s " +
                "LIMIT :size OFFSET :offset";

        return jdbcTemplate.query(
                String.format(sql, sorted.toString()),
                new MapSqlParameterSource()
                        .addValue("category", category.toString())
                        .addValue("offset", page * size)
                        .addValue("size", size),
                mapper
        );
    }

}
