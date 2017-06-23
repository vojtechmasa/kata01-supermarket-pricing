package com.vojtechmasa.supermarketpricing.discount;

import org.junit.Test;

import javax.annotation.ParametersAreNonnullByDefault;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@ParametersAreNonnullByDefault
public class SinglePriceForMoreItemsDiscountShould {
  @Test
  public void countCorrectly_forNotEnoughPiecesInBunch() {
    //GIVEN
    SinglePriceForMoreItemsDiscount singlePriceForMoreItemsDiscount = new SinglePriceForMoreItemsDiscount(3, 10);

    //WHEN
    double actualPrice = singlePriceForMoreItemsDiscount.price(4, 2);

    //THEN
    double expectedPrice = 8;
    assertThat(actualPrice, is(equalTo(expectedPrice)));
  }

  @Test
  public void countCorrectly_forJustEnoughPiecesInBunch() {
    //GIVEN
    SinglePriceForMoreItemsDiscount singlePriceForMoreItemsDiscount = new SinglePriceForMoreItemsDiscount(3, 10);

    //WHEN
    double actualPrice = singlePriceForMoreItemsDiscount.price(4, 3);

    //THEN
    double expectedPrice = 10;
    assertThat(actualPrice, is(equalTo(expectedPrice)));
  }

  @Test
  public void countCorrectly_forOneBunchAndSomeMorePieces() {
    //GIVEN
    SinglePriceForMoreItemsDiscount singlePriceForMoreItemsDiscount = new SinglePriceForMoreItemsDiscount(3, 10);

    //WHEN
    double actualPrice = singlePriceForMoreItemsDiscount.price(4, 5);

    //THEN
    double expectedPrice = 18;
    assertThat(actualPrice, is(equalTo(expectedPrice)));
  }

  @Test
  public void countCorrectly_forMoreBunchesAndSomeMorePieces() {
    //GIVEN
    SinglePriceForMoreItemsDiscount singlePriceForMoreItemsDiscount = new SinglePriceForMoreItemsDiscount(3, 10);

    //WHEN
    double actualPrice = singlePriceForMoreItemsDiscount.price(4, 8);

    //THEN
    double expectedPrice = 28;
    assertThat(actualPrice, is(equalTo(expectedPrice)));
  }
}