package com.capitole.productCatalog.product.infraestructure.mappers;

import com.capitole.productCatalog.product.domain.models.Category;
import com.capitole.productCatalog.product.domain.models.Product;
import com.capitole.productCatalog.shared.domain.models.Sku;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Service
public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Product(
                new Sku(rs.getString("SKU")),
                rs.getFloat("Price"),
                rs.getString("Description"),
                Category.fromStringLazy(rs.getString("Category")),
                Optional.empty()
        );
    }
}
