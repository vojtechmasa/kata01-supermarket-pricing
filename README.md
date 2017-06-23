# kata01-supermarket-pricing

- This is only basic implementation, focused on the domain model
- UI layer is to be done. It will be a separate module (as the storage module)
- I was not sure how to deal with discounts for products "continuous" `CountingType`. To support them, there was a need
  to have a `double` for `quantity` parameter in `com.vojtechmasa.supermarketpricing.discount.Discount.price()` method.
   That needs then casting to `int` for discrete `CountingType`. I decided keeping `double` there for the sake of extendability.
   This solution may also allow discounts for continuous `CountintType`s, for example 2 kilos of ham for price of 1 kilo.
   However, this would need a bit research, testing and changing the code.
- Most of the objects are immutable, so synchronization should be for free.
- DI principle was followed.
- This is just a sketch, I should elaborate it more.