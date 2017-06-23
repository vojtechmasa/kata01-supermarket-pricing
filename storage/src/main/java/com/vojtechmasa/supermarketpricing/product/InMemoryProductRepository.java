package com.vojtechmasa.supermarketpricing.product;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@ParametersAreNonnullByDefault
public class InMemoryProductRepository implements ProductRepository {
  private final Map<String, Product> products = new HashMap<>();

  @Nonnull
  @Override
  public Optional<Product> getByName(String name) {
    return Optional.ofNullable(products.get(name));
  }

  @Nonnull
  @Override
  public Collection<Product> getAll() {
    return products.values();
  }

  @Override
  public void save(Product product) {
    if (isPresent(product)) {
      throw new IllegalArgumentException("The product " + product + " has been already stored.");
    }

    products.put(product.name(), product);
  }

  private boolean isPresent(Product product) {
    return getByName(product.name()).isPresent();
  }
}
