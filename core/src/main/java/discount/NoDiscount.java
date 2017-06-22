package discount;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class NoDiscount implements Discount {
  @Override
  public double price(double unitPrice, double quantity) {
    return unitPrice * quantity;
  }
}
