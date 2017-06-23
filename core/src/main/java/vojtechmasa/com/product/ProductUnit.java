package vojtechmasa.com.product;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public enum ProductUnit {
  KILOGRAM("kg", CountingType.CONTINUOUS), LITER("l", CountingType.CONTINUOUS), PIECE("pc", CountingType.DISCRETE);

  @Nonnull
  private final String abbreviation;
  @Nonnull
  private final CountingType countingType;

  ProductUnit(String abbreviation, CountingType countingType) {
    this.abbreviation = abbreviation;
    this.countingType = countingType;
  }

  @Nonnull
  public String abbreviation() {
    return abbreviation;
  }

  @Nonnull
  public CountingType countingType() {
    return countingType;
  }
}
