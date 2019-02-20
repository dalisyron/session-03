package com.workshop.sample.kotlin.homework

class Homework08Tests {
    companion object {
        val cities = listOf(City("Tehran"), City("Mashhad"), City("Shiraz"), City("Nishabur"))

        val products = listOf(
            Product("Rug", 100.0),
            Product("Sculpture", 50.0),
            Product("Painting", 40.0),
            Product("Lonely Product", 0.0)
        )

        val orders = listOf(
            Order(listOf(products[0], products[1]), isDelivered = false),
            Order(listOf(products[1], products[2]), isDelivered = false),
            Order(listOf(products[0], products[1]), isDelivered = false),
            Order(listOf(products[0], products[1], products[2]), isDelivered = false)
        )

        val customers = listOf(
            Customer("Ali A", cities[0], listOf(orders[0], orders[1])),
            Customer("Pewds", cities[1], listOf(orders[0])),
            Customer("Mobin", cities[1], listOf(orders[0], orders[1], orders[2])),
            Customer("Pepe", cities[3], listOf(orders[0], orders[1], orders[2], orders[3]))
        )

        val shop = Shop("Wallmart", customers)

        fun outputAssert(conditional: Boolean) {
            println(if (conditional) "Passed" else "Failed")
        }

        fun getCustomerCitiesTest() {
            outputAssert(
                shop.getCustomerCities().map { it -> it.name }.sorted() == listOf(
                    "Mashhad",
                    "Nishabur",
                    "Tehran"
                )
            )
        }

        fun getCustomerCountTest() {
            outputAssert(shop.getCustomerCount(City("Mashhad")) == 2)
        }

        fun getCustomersSortedByOrdersAscendingTest() {
            val customers = shop.getCustomersSortedByOrdersAscending()
            outputAssert(customers.map { it -> it.name } == listOf("Pewds", "Ali A", "Mobin", "Pepe"))
        }

        fun getCustomersSortedByOrdersDescendingTest() {
            val customers = shop.getCustomersSortedByOrdersDescending()
            outputAssert(customers.map { it -> it.name } == listOf("Pepe", "Mobin", "Ali A", "Pewds"))
        }

        fun getOrderedProductsTest() {
            val products = customers[1].getOrderedProducts()
            outputAssert(products.map { it -> it.name }.sorted() == listOf("Rug", "Sculpture"))
        }

        fun getProductsWithAtLeastOneBuyerTest() {
            val products = shop.getProductsWithAtLeastOneBuyer()
            outputAssert(products.map { it -> it.name }.sorted() == listOf("Painting", "Rug", "Sculpture"))
        }
    }
}

fun main() {
    Homework08Tests.getCustomerCitiesTest()
    Homework08Tests.getCustomerCountTest()
    Homework08Tests.getCustomersSortedByOrdersDescendingTest()
    Homework08Tests.getCustomersSortedByOrdersAscendingTest()
    Homework08Tests.getOrderedProductsTest()
    Homework08Tests.getProductsWithAtLeastOneBuyerTest()
}