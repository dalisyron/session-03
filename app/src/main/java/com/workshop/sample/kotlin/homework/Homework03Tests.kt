package com.workshop.sample.kotlin.homework

class ProgramTests {
    companion object {
        val cities = listOf(City("Tehran"), City("Mashhad"), City("Shiraz"), City("Nishabur"))

        val products = listOf(Product("Rug", 100.0), Product("Sculpture", 50.0), Product("Painting", 40.0))

        val orders = listOf(Order(listOf(products[0], products[1]), isDelivered = false),
                            Order(listOf(products[1], products[2]), isDelivered = false),
                            Order(listOf(products[0], products[1]), isDelivered = false),
                            Order(listOf(products[0], products[1], products[2]), isDelivered = false)
        )

        val customers = listOf(Customer("Ali A", cities[0], listOf(orders[0], orders[1])),
                               Customer("Pewds", cities[1], listOf(orders[0])),
                               Customer("Mobin", cities[1], listOf(orders[0], orders[1], orders[2])),
                               Customer("Pepe", cities[3], listOf(orders[0], orders[1], orders[2], orders[3]))
        )

        val shop = Shop("Wallmart", customers)

        fun outputAssert(conditional : Boolean) {
            println(if (conditional) "Passed" else "Failed")
        }

        fun getCityThatMostCustomersAreFromTest() {
            val ans = shop.getCityThatMostCustomersAreFrom()
            outputAssert(ans?.name == "Mashhad")
        }

        fun getCityThatMostCustomersAreFromFastTest() {
            val ans = shop.getCityThatMostCustomersAreFromFast()
            outputAssert(ans?.name == "Mashhad")
        }

        fun getCustomerWithMaximumNumberOfOrdersTest() {
            val ans = shop.getCustomerWithMaximumNumberOfOrders()
            outputAssert(ans?.name == "Pepe")
        }
    }
}

fun main() {
    ProgramTests.getCityThatMostCustomersAreFromTest()
    ProgramTests.getCityThatMostCustomersAreFromFastTest()
    ProgramTests.getCustomerWithMaximumNumberOfOrdersTest()
}