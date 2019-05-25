import kotlin.browser.*

fun clicandoBotao(){
    var variavelInstanciada = document.getElementById("primeiraDiv")

    variavelInstanciada?.innerHTML += "Clicando no botão clicandoBotao" + "<br>"
    println("Ok, teste benéfico")
    window.alert("Janela aberta ao clicar na função setada no div")
}

fun imprimindoTela(){
    var variavelUtilizadaTela = document.getElementById("segundaDiv")

    //println("Conteudo =" + variavelUtilizadaTela?.innerHTML)
    variavelUtilizadaTela?.innerHTML += "Clicando no botão imprimindoTela" + "<br>"
    println("Adicionando na tela")
}


fun main(){
    println(document.getElementById("textosMotivacionais"))

}