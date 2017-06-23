package vojtechmasa.com.product;

import com.vojtechmasa.discount.NoDiscount;
import org.junit.Test;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class QuantifiedProductShould {

  @Test(expected = IllegalArgumentException.class)
  public void notBeCreated_ifItIsDiscreteAndHasNonIntegerQuantity() {
    new QuantifiedProduct(
        new Product("Popsicle", 10, ProductUnit.PIECE),
        2.5,
        new NoDiscount()
    );
  }

  @Test
  public void beCreated_ifItIsDiscreteAndHasIntegerQuantity() {
    new QuantifiedProduct(
        new Product("Popsicle", 2.5, ProductUnit.PIECE),
        3,
        new NoDiscount()
    );
  }

  @Test
  public void beCreated_ifItIsContinuousAndHasNonIntegerQuantity() {
    new QuantifiedProduct(
        new Product("Popsicle", 3, ProductUnit.KILOGRAM),
        2.5,
        new NoDiscount()
    );
  }
}