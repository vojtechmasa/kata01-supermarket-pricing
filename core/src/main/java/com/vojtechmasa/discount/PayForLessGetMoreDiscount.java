package com.vojtechmasa.discount;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class PayForLessGetMoreDiscount implements Discount {
  private final int getAmount;
  private final int payAmount;

  public PayForLessGetMoreDiscount(int getAmount, int payAmount) {
    this.getAmount = getAmount;
    this.payAmount = payAmount;
  }

  @Override
  public double price(double unitPrice, double quantity) {
    int eligibleForFree = ((int) quantity / getAmount) * (getAmount - payAmount);

    return unitPrice * (quantity - eligibleForFree);
  }
}
