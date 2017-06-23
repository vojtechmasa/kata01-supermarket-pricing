package com.vojtechmasa.supermarektpricing.product;

import com.vojtechmasa.supermarketpricing.product.Product;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Collection;
import java.util.Optional;

@ParametersAreNonnullByDefault
public interface ProductRepository {
  @Nonnull
  Optional<Product> getByName(String name);

  @Nonnull
  Collection<Product> getAll();

  void save(Product product);

}
