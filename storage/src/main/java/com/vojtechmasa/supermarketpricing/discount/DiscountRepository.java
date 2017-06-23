package com.vojtechmasa.supermarketpricing.discount;

import com.vojtechmasa.supermarketpricing.product.Product;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Optional;

//TODO implement delete operation
@ParametersAreNonnullByDefault
public interface DiscountRepository {
  @Nonnull
  Optional<Discount> get(Product product);
  void save(Product product, Discount discount);

}
