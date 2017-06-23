package com.vojtechmasa.supermarketpricing.product;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Product)) return false;
    Product product = (Product) o;
    return Double.compare(product.unitPrice, unitPrice) == 0 &&
        Objects.equals(name, product.name) &&
        productUnit == product.productUnit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, unitPrice, productUnit);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Product{");
    sb.append("name='").append(name).append('\'');
    sb.append(", unitPrice=").append(unitPrice);
    sb.append(", productUnit=").append(productUnit);
    sb.append(", discrete=").append(discrete());
    sb.append('}');
    return sb.toString();
  }
}
