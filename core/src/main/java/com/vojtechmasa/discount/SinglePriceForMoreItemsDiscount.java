package com.vojtechmasa.discount;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class SinglePriceForMoreItemsDiscount implements Discount {
  private final int bunchQuantity;
  private final double bunchPrice;

  public SinglePriceForMoreItemsDiscount(int bunchQuantity, double bunchPrice) {
    this.bunchQuantity = bunchQuantity;
    this.bunchPrice = bunchPrice;
  }

  @Override
  public double price(double unitPrice, double quantity) {
    int itemsForNormalPrice = (int) quantity % bunchQuantity;
    int numberOfBunches = (int) quantity / bunchQuantity;

    return unitPrice * itemsForNormalPrice + numberOfBunches * bunchPrice;
  }
}
