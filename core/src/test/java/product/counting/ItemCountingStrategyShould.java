package product.counting;

import org.junit.Test;

import javax.annotation.ParametersAreNonnullByDefault;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@ParametersAreNonnullByDefault
public class ItemCountingStrategyShould {
  @Test
  public void returnUnitPrice_forOnePiece() {
    //GIVEN
    ItemCountingStrategy itemCountingStrategy = new ItemCountingStrategy();

    //WHEN
    double actualPrice = itemCountingStrategy.price(20, 1);

    //THEN
    double expectedPrice = 20;
    assertThat(actualPrice, is(equalTo(expectedPrice)));
  }

  @Test
  public void returnMultipleOfUnitPrice_forMorePieces() {
    //GIVEN
    ItemCountingStrategy itemCountingStrategy = new ItemCountingStrategy();

    //WHEN
    double actualPrice = itemCountingStrategy.price(20, 3);

    //THEN
    double expectedPrice = 20*3;
    assertThat(actualPrice, is(equalTo(expectedPrice)));
  }
}