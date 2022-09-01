package com.github.rcd27

sealed class OrderPlaced

context(ValidateOrder) // dependency
fun PlaceOrder.placeOrder(
    /** input */
    productCode: ProductCode
) {

}