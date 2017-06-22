package product;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;

@Immutable
@ParametersAreNonnullByDefault
public class QuantifiedProduct {
  @Nonnull
  private final Product product;
  private final double quantity;

  public QuantifiedProduct(Product product, double quantity) {
    checkQuantity(product.discrete(), quantity);

    this.product = product;
    this.quantity = quantity;
  }

  private static void checkQuantity(boolean discrete, double quantity) {
    boolean hasDecimalPart = quantity % 1 != 0;

    if (discrete && hasDecimalPart) {
      throw new IllegalArgumentException("For this product you need integer quantity. Passed: " + quantity);
    }
  }

  @Nonnull
  public Product product() {
    return product;
  }

  public double quantity() {
    return quantity;
  }

  public double price() {
    return product().unitPrice() * quantity;
  }
}
