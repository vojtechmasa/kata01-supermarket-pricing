package vojtechmasa.com.discount;

import org.junit.Test;

import javax.annotation.ParametersAreNonnullByDefault;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@ParametersAreNonnullByDefault
public class PayForLessGetMorePriceDiscountShould {
  @Test
  public void countCorrectly3for2Discount() {
    //GIVEN
    PayForLessGetMoreDiscount payForLessGetMoreDiscount = new PayForLessGetMoreDiscount(3, 2);

    //WHEN 1
    double actualPrice = payForLessGetMoreDiscount.price(10, 1);

    //THEN 1
    double expectedPrice = 10;
    assertThat(actualPrice, is(equalTo(expectedPrice)));

    //WHEN 2
    actualPrice = payForLessGetMoreDiscount.price(10, 5);

    //THEN 2
    expectedPrice = 10 * 4;
    assertThat(actualPrice, is(equalTo(expectedPrice)));

    //WHEN 3
    actualPrice = payForLessGetMoreDiscount.price(10, 6);

    //THEN 3
    expectedPrice = 10 * 4;
    assertThat(actualPrice, is(equalTo(expectedPrice)));

    //WHEN 4
    actualPrice = payForLessGetMoreDiscount.price(10, 7);

    //THEN 4
    expectedPrice = 10 * 5;
    assertThat(actualPrice, is(equalTo(expectedPrice)));
  }
}