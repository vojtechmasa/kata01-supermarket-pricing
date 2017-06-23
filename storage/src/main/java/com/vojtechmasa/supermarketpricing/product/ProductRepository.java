package com.vojtechmasa.supermarketpricing.product;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Collection;
import java.util.Optional;

//TODO implement delete operation
@ParametersAreNonnullByDefault
public interface ProductRepository {
  @Nonnull
  Optional<Product> getByName(String name);

  @Nonnull
  Collection<Product> getAll();

  void save(Product product);

}
