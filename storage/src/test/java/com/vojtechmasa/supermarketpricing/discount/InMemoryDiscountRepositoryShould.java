package com.vojtechmasa.supermarketpricing.discount;

import com.vojtechmasa.supermarketpricing.product.Product;
import com.vojtechmasa.supermarketpricing.product.ProductUnit;
import org.junit.Test;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@ParametersAreNonnullByDefault
public class InMemoryDiscountRepositoryShould {
  @Test
  public void storeDiscount_whichHasNotYetBeenStored() {
    //GIVEN
    InMemoryDiscountRepository inMemoryDiscountRepository = new InMemoryDiscountRepository();
    Product product = new Product("Argus Beer", 10, ProductUnit.PIECE);
    Discount originalDiscount = new PayForLessGetMoreDiscount(5, 30);

    //WHEN
    inMemoryDiscountRepository.save(product, originalDiscount);

    //THEN
    Discount retrievedDiscount = inMemoryDiscountRepository.get(product)
        .orElseThrow(() -> new NoSuchElementException("Discount " + originalDiscount + " was not stored for product " + product));
    assertThat(retrievedDiscount, is(equalTo(originalDiscount)));
  }

  @Test(expected = IllegalArgumentException.class)
  public void throwException_whileSavingAlreadySavedDiscount() {
    //GIVEN
    InMemoryDiscountRepository inMemoryDiscountRepository = new InMemoryDiscountRepository();
    Product product = new Product("Argus Beer", 10, ProductUnit.PIECE);
    Discount originalDiscount = new PayForLessGetMoreDiscount(5, 30);

    inMemoryDiscountRepository.save(product, originalDiscount);

    //WHEN
    inMemoryDiscountRepository.save(product, originalDiscount);
  }
}