abstract class List

data class Node(val info: Int, val prox: List): List()

object Nil: List()

//Verifica a quantidade de vezes que um elemento se encontra em uma lista
//Usando lista padrão
fun contador(l:List<Int>,n:Int):Int{
     return l.filter{x -> x == n }.size
}

//Faz a filtragem necessária para impressão do resultado
fun reducaoTermos(l:List<Int>):Int{
    return l.filter(x -> x>5).reduce(x,y -> x*y)
}

//A partir dessa linha utilizo a própria lista criada inicialmente
//Pega o menor elemento de uma lista
fun menor(l:List):Int = when(l){
    is Node -> menorAux(l,l.info)
    else -> -1
}

//Remove o valor de uma lista
fun remove(l:List,valor:Int):List = when(l){
    is Node -> ( if(l.info != valor ) { Node(l.info,remove(l.prox,valor))}
                    else {remove(l.prox,valor)} ) 
    else -> Nil
}


fun menorAux(l:List,menorElemento:Int):Int = when(l){
   is Node -> (if(l.info <  menorElemento) { menorAux(l.prox,l.info)
                } else { menorAux(l.prox,menorElemento)
            })
   else ->  menorElemento
   }

//Calcula o menor elemento da lista de entrada por Collections
fun menor(l:List<Int>):Int{
    val ordenado = l.sorted()
    return ordenado[0]
}

//Collections

//Retira maiores que dez de uma lista usando Collections
fun maior10(l:List<Int>):Int {
    return l.filter{x -> x>3}.reduce{x,y -> x+y}
}

//Retira os elementos pares da lista
fun retirarPares(l:List<Int>):List<Int> {
    return l.filter{x -> x%2 != 0}
}

//Adiciona um elemento numa posição específica
fun map(l:MutableList<Int>,posicao:Int,elementoAdicionar:Int):List<Int>{
    l[posicao] = elementoAdicionar
    return l
}

//Verifica quantas vezes um elemento se encontra na lista
fun verificarOcorrencia(l:List<Int>,numeroVerificar:Int):Int {
    return l.filter{x-> x==numeroVerificar}.size
}

fun main(){
    val l1 = listOf(1,2,3,4,5,6,4,8,9,4,14)
    val l2 = mutableListOf(1,2,3,4,5,6,7,8,9,10)
    println(maior10(l1))
    println(retirarPares(l1))
    println(map(l2,3,604))
    println(verificarOcorrencia(l1,4))
}


//Main com tipos de listas diferentes, recomendo um uso por vez.
fun main() {
    val l1 = listOf(3,4,5,6,7,8,9,5,13,1,42,2,10)
    val l2 = Node(45,Node(42,Node(55,Node(77,Nil))))
    println(menor(l2))
    println(menor(l1))
    println(reducaoTermos(l1))
    println(contador(l1,11))
}