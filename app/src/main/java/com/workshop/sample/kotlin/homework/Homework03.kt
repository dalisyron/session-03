package com.workshop.sample.kotlin.homework

import java.util.*
import kotlin.collections.HashMap

/**
    Notes:
    Extension functions were used, Since no parameters were provided in the original functions.
 **/

fun City.getCustomerCount(customers: List<Customer>): Int {
    return customers?.count { this.name == it.city.name }
}

fun Shop.getCityThatMostCustomersAreFrom(): City? {
    return this.customers?.maxBy { it.city.getCustomerCount(this.customers) }?.city
}

// More code, But better time complexity.
fun Shop.getCityThatMostCustomersAreFromFast(): City? {
    val cityCount = HashMap<City, Int>()
    this.customers.forEach {
        cityCount[it.city] = (cityCount.get(it.city) ?: 0) + 1
    }
    return cityCount.maxBy { it.value }?.key
}

fun Shop.getCustomerWithMaximumNumberOfOrders(): Customer? {
    return this.customers?.maxBy { it.orders.size }
}
