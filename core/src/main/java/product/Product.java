package product;

import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

@Immutable
@ParametersAreNonnullByDefault
public final class Product {
  @Nonnull
  private final String name;
  @Nonnull
  private final double unitPrice;

  public Product(String name, double unitPrice) {
    this.name = name;
    this.unitPrice = unitPrice;
  }

  @Nonnull
  public String name() {
    return name;
  }

  @Nonnull
  public double unitPrice() {
    return unitPrice;
  }
}
