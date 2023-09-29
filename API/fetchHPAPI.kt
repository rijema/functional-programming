import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.*

data class Book(val title: String, val author: String)

suspend fun fetchBooks(): List<Book> {
    val client = HttpClient()
    return try {
        val response: List<Map<String, String>> = client.get("https://wizard-world-api.herokuapp.com/Houses")
        response.map { Book(it["name"] ?: "", it["animal"] ?: "") }
    } finally {
        client.close()
    }
}

fun main() = runBlocking {
    val books: List<Book> = async { fetchBooks() }.await()

    books.forEach {
        println("Hogwart's house: ${it.name} | Animalistic symbol: ${it.animal}")
    }
}