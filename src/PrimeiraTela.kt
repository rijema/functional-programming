import kotlin.browser.*

fun imprimindoTela(){
    val variavelInstanciada = document.getElementById("segundaDiv")
    variavelInstanciada?.innerHTML += "+1 to study for Kotlin" + "<br>"
    println("Ok, teste benéfico")
    window.alert("Kotlin is a good language :)")
}

fun clicandoBotao(){
    val variavelUtilizadaTela = document.getElementById("primeiraDiv")
    //println("Conteudo =" + variavelUtilizadaTela?.innerHTML)
    val listaAssuntos = listOf("Recursivity","High Level Functions","Lazy","Yield")
    variavelUtilizadaTela?.innerHTML += listaAssuntos.take((0 until listaAssuntos.size-1).random())
    variavelUtilizadaTela?.innerHTML += "<br>"
    val trying_to_not_wakeup = mutableListOf<String>()
    println("Adicionando na tela")
}


fun main(){
    println(document.getElementById("textosMotivacionais"))

}
