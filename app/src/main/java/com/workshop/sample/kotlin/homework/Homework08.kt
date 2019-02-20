package com.workshop.sample.kotlin.homework

fun Shop.getCustomerCities() = customers.groupBy { it.city }.keys.toList()

fun Shop.getCustomerCount(city: City) = customers.groupBy { it.city }.get(city)?.size ?: 0

fun Shop.getCustomersSortedByOrdersAscending() = customers.sortedBy { it.orders.size }

fun Shop.getCustomersSortedByOrdersDescending() = customers.sortedByDescending { it.orders.size }

fun Customer.getOrderedProducts() = orders.groupBy { it.products }.keys.flatten().toSet()

fun Shop.getProductsWithAtLeastOneBuyer() =
    customers.groupBy { it.orders }.keys.flatten().groupBy { it.products }.keys.flatten().toSet()