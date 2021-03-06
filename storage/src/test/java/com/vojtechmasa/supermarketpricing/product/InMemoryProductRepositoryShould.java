package com.vojtechmasa.supermarketpricing.product;

import org.junit.Test;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@ParametersAreNonnullByDefault
public class InMemoryProductRepositoryShould {
  @Test
  public void storeProduct_whichHasNotBeenYetStored() {
    //GIVEN
    InMemoryProductRepository inMemoryProductRepository = new InMemoryProductRepository();
    String productName = "Argus Beer";

    //WHEN
    Product originalProduct = new Product(productName, 10, ProductUnit.PIECE);
    inMemoryProductRepository.save(originalProduct);

    //THEN
    Product retrievedProduct = inMemoryProductRepository.getByName(productName)
        .orElseThrow(() -> new NoSuchElementException(productName + " is not present in the repo."));
    assertThat(retrievedProduct, is(equalTo(originalProduct)));
  }

  @Test(expected = IllegalArgumentException.class)
  public void throwException_whileSavingAlreadySavedProduct() {
    //GIVEN
    InMemoryProductRepository inMemoryProductRepository = new InMemoryProductRepository();
    String productName = "Argus Beer";
    Product originalProduct = new Product(productName, 10, ProductUnit.PIECE);
    inMemoryProductRepository.save(originalProduct);

    //WHEN
    inMemoryProductRepository.save(originalProduct);
  }
}