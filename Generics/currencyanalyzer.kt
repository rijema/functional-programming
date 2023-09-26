class Currency<T, U>(val name: T, val value: U) {
    fun description(): String {
        return "This is a currency of $name with a value of $value"
    }
}

class Box<T, U> {
    private val currencies = mutableListOf<Currency<T, U>>()

    fun addCurrency(currency: Currency<T, U>) {
        currencies.add(currency)
    }

    fun removeLastCurrency(): Currency<T, U>? {
        if (currencies.isNotEmpty()) {
            return currencies.removeAt(currencies.size - 1)
        }
        return null
    }

    fun listCurrencies() {
        for (currency in currencies) {
            println(currency.description())
        }
    }
}

fun main() {
    val dollarBox = Box<String, Double>()
    val currency1 = Currency("Dollar", 1.0)
    val currency2 = Currency("Dollar", 2.0)

    dollarBox.addCurrency(currency1)
    dollarBox.addCurrency(currency2)
    dollarBox.listCurrencies()

    val lastCurrencyFromDollarBox = dollarBox.removeLastCurrency()
    println("Last currency removed from the dollar box: ${lastCurrencyFromDollarBox?.description()}")
}
