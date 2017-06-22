package discount;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public interface Discount {
  double price(double unitPrice, double quantity);
}
