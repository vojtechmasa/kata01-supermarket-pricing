package product.counting;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public interface CountingStrategy {
  double price(double unitPrice, double quantity);
}
