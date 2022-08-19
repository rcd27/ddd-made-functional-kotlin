package com.github.rcd27

import arrow.core.Either

typealias WidgetCode = String // constraint starting with "W" then 4 digits
typealias GizmoCode = String // constraint starting with "G" then 3 digits

sealed class ProductCode {
    data class Widget(val code: WidgetCode) : ProductCode()
    data class Gizmo(val code: GizmoCode) : ProductCode()
}

/**
 * This is a good place to use refined types with all validation under the hood
 * see: https://kotlinlang.slack.com/archives/CJ699L62W/p1660928963300529
 */
typealias UnitQuantity = Int
typealias KilogramQuantity = Float

sealed class OrderQuantity {
    data class Unit(val quantity: UnitQuantity) : OrderQuantity()
    data class Kilos(val quantity: KilogramQuantity) : OrderQuantity()
}

typealias OrderId = Nothing
typealias OrderLineId = Nothing
typealias CustomerId = Nothing
typealias CustomerInfo = Nothing
typealias ShippingAddress = Nothing
typealias BillingAddress = Nothing
typealias Price = Nothing
typealias BillingAmount = Nothing

data class OrderLine(
    val id: OrderLineId,
    val orderId: OrderId,
    val productCode: ProductCode,
    val orderQuantity: OrderQuantity,
    val price: Price,
)

data class Order(
    val id: OrderId,
    val customerId: CustomerId,
    val shippingAddress: ShippingAddress,
    val billingAddress: BillingAddress,
    val orderLines: List<OrderLine>,
    val amountToBill: BillingAmount,
)

data class UnvalidatedOrder(
    val orderId: String,
    val customerInfo: CustomerInfo,
    val shippingAddress: ShippingAddress,
)

object PlaceOrderEvents // TODO: fill
data class PlaceOrderError(val errors: List<Throwable>)

typealias PlaceOrder = (UnvalidatedOrder) -> Either<PlaceOrderError, PlaceOrderEvents>