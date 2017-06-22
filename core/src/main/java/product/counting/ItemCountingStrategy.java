package product.counting;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class ItemCountingStrategy implements CountingStrategy {
  @Override
  public double price(double unitPrice, double quantity) {
    return quantity * unitPrice;
  }
}
