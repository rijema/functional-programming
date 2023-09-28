import khttp.get

fun main() {
    try {
        val response = get("http://localhost:8080")

        if (response.statusCode == 200) {
            println("Response body: ${response.text}")
        } else {
            println("Error: ${response.statusCode}")
        }
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}