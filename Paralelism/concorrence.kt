import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

data class SearchResult(val query: String, val results: List<String>)

suspend fun searchInEngine(query: String): SearchResult {
    delay(1000)
    return SearchResult(query, listOf("Resultado1", "Resultado2", "Resultado3"))
}

suspend fun searchInBookEngine(query: String): SearchResult {
    delay(1500) 
    return SearchResult(query, listOf("Livro1", "Livro2", "Livro3"))
}

fun main() = runBlocking {
    val termoBusca = "Kotlin"

    val tempoTotal = measureTimeMillis {
        val deferredSearch = async { searchInEngine(termoBusca) }
        val deferredBookSearch = async { searchInBookEngine(termoBusca) }

        val resultSearch = deferredSearch.await()
        val resultBookSearch = deferredBookSearch.await()

        println("Resultados da busca em mecanismo: ${resultSearch.results}")
        println("Resultados da busca em mecanismo de livros: ${resultBookSearch.results}")
    }

    println("tmp total de execução: $tempoTotal ms")
}
