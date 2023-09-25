
import kotlinx.coroutines.*


fun main() = runBlocking {
    generateMessageAddition()
}

suspend fun generateMessageAddition() = coroutineScope {
    launch {
        delay(3000L)
        println("Mrs. Brightside!")
    }
    print("Let me know your needs, ")
}