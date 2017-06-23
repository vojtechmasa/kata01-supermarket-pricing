package com.vojtechmasa.supermarketpricing.product;

import com.vojtechmasa.supermarketpricing.discount.Discount;
import com.vojtechmasa.supermarketpricing.discount.NoDiscount;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof QuantifiedProduct)) return false;
    QuantifiedProduct that = (QuantifiedProduct) o;
    return Double.compare(that.quantity, quantity) == 0 &&
        Objects.equals(product, that.product) &&
        Objects.equals(discount, that.discount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(product, quantity, discount);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("QuantifiedProduct{");
    sb.append("product=").append(product);
    sb.append(", quantity=").append(quantity);
    sb.append(", discount=").append(discount);
    sb.append(", price=").append(price());
    sb.append(", discountedPrice=").append(discountedPrice());
    sb.append(", discounted=").append(discounted());
    sb.append(", discrete=").append(discrete());
    sb.append('}');
    return sb.toString();
  }
}
