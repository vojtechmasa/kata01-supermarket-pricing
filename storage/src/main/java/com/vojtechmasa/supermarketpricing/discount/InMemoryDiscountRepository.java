package com.vojtechmasa.supermarketpricing.discount;

import com.vojtechmasa.supermarketpricing.product.Product;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

//Currently supports only 1 discount per product.
@ParametersAreNonnullByDefault
public class InMemoryDiscountRepository implements DiscountRepository {
  @Nonnull
  private final Map<Product, Discount> discounts = new HashMap<>();

  @Nonnull
  @Override
  public Optional<Discount> get(Product product) {
    return Optional.ofNullable(discounts.get(product));
  }

  @Override
  public void save(Product product, Discount discount) {
    if (isPresent(product)) {
      throw new IllegalArgumentException("The product " + product + " has been already discounted.");
    }

    discounts.put(product, discount);
  }

  private boolean isPresent(Product product) {
    return get(product).isPresent();
  }
}
