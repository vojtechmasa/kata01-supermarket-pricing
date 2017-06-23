package vojtechmasa.com.product;

import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

@Immutable
@ParametersAreNonnullByDefault
public final class Product {
  @Nonnull
  private final String name;
  private final double unitPrice;
  @Nonnull
  private final ProductUnit productUnit;

  public Product(String name, double unitPrice, ProductUnit productUnit) {
    this.name = name;
    this.unitPrice = unitPrice;
    this.productUnit = productUnit;
  }

  @Nonnull
  public String name() {
    return name;
  }

  public double unitPrice() {
    return unitPrice;
  }

  @Nonnull
  public ProductUnit productUnit() {
    return productUnit;
  }

  public boolean discrete() {
    return productUnit().countingType() == CountingType.DISCRETE;
  }
}
