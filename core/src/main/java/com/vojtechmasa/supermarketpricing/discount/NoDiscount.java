package com.vojtechmasa.supermarketpricing.discount;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;

@Immutable
@ParametersAreNonnullByDefault
public class NoDiscount implements Discount {
  @Override
  public double price(double unitPrice, double quantity) {
    return unitPrice * quantity;
  }
}
