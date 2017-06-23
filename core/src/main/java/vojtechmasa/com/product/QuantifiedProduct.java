package vojtechmasa.com.product;

import vojtechmasa.com.discount.Discount;
import vojtechmasa.com.discount.NoDiscount;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;

@Immutable
@ParametersAreNonnullByDefault
public class QuantifiedProduct {
  @Nonnull
  private static final Discount NO_DISCOUNT = new NoDiscount();

  @Nonnull
  private final Product product;
  private final double quantity;
  @Nonnull
  private final Discount discount;

  public QuantifiedProduct(Product product, double quantity, Discount discount) {
    checkQuantity(product.discrete(), quantity);

    this.product = product;
    this.quantity = quantity;
    this.discount = discount;
  }

  private static void checkQuantity(boolean discrete, double quantity) {
    boolean hasDecimalPart = quantity % 1 != 0;

    if (discrete && hasDecimalPart) {
      throw new IllegalArgumentException("For this vojtechmasa.com.product you need integer quantity. Passed: " + quantity);
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
    return NO_DISCOUNT.price(product().unitPrice(), quantity());
  }

  public double discountedPrice() {
    return discount.price(product().unitPrice(), quantity());
  }

  public boolean discounted() {
    return price() > discountedPrice();
  }

  public boolean discrete() {
    return product().discrete();
  }
}
