//YCDA.
//Richard Jeremias - Linguagem de Programação Funcional

//Inicialmente, se quero usar recursividade, tenho que trabalhar com essas linhas de código também
//Sexta
abstract class List

data class Node(val info: Int, val prox: List): List()

object Nil: List()

//Remoção de pares de uma lista
fun removePares(l:List?):List = when(l){
    is Node -> (if (l.info%2!=0){Node(l.info,removePares(l.prox))}
                else{removePares(l.prox)})
    else -> Nil
 
}

//Calcular soma de Elementos de uma lista
fun calcularSomaElementosNode(l:List):Int = when(l){
    is Node -> l.info + calcularSomaElementosNode(l.prox)
    else -> 0
}


//Calcula maiores que 10 em uma lista
fun maiorDez(l:List?):Int = when(l){
    is Node -> auxCalculaMaior(l,0)
    else -> 0
}

    fun auxCalculaMaior(l:List?,v:Int):Int = when(l){
        is Node -> (if(l.info>=10){auxCalculaMaior(l.prox,v+l.info)} else{auxCalculaMaior(l.prox,v)})
        else -> v
            
    }

    //Sábado

//Insere elemento em uma determinada posição
fun insereElemento(l:List?,elemento:Int,posicao:Int):List = when(l){
    is Node -> auxInsereElemento(l,elemento,posicao,0)
    else -> Nil
}


    fun auxInsereElemento(l:List?,elemento:Int,posicao:Int,contador:Int):List = when(l) {
        //verificar se é  pra sobrepor mesmo
        is Node -> (if(contador==posicao){
                    Node(elemento,auxInsereElemento(l.prox,elemento,posicao,contador+1))}
                    else{
                        Node(l.info,auxInsereElemento(l.prox,elemento,posicao,contador+1))
                    })
        else -> Nil
                    
    }


//Verifica a quantidade de vezes um elemento específico se encontra na Lista
fun contarOcorrencias(l:List?,valor:Int):Int = when(l){
    is Node -> auxContarOcorrencias(l,valor,0)
    else -> 0
}

    fun auxContarOcorrencias(l:List?,valor:Int,contador:Int):Int = when(l){
        is Node -> (if(l.info==valor){auxContarOcorrencias(l.prox,valor,contador+1)}
                    else{auxContarOcorrencias(l.prox,valor,contador)}
        )
        else -> contador
    }

//Verificar se uma subsequencia está contida em uma sequencia
fun contem(l:List,l2:List):Boolean = when{

     (l is Node && l2 is Nil) -> true
     (l is Nil  && l2 is Node) -> false
     (l is Node  && l2 is Node) -> if(l.info == l2.info){
                        contem(l.prox,l2.prox)
                    } else{
                    contem(l.prox,l2)
                    } 
    else -> false
 }


//Procurar maior valor entre dois números inseridos em uma função ((x*7)>(y*7)?(x*7):(y*7))
fun maiorValorEntre(f:(Int)->Int,maior:Int,menor:Int):Int{
    return auxiliarMaior(f,maior,menor,0)   
}

//Função auxiliar para entrada de uma valor que armazena temporariamente o maior valor naquele ponto.
fun auxiliarMaior(f:(Int)->Int,maior:Int,menor:Int,maiorEntre:Int):Int {
    if(menor == maior){ 
        return maiorEntre 
    } else {  if (f(menor)<f(menor+1)) {
            return auxiliarMaior(f,maior,menor+1,f(menor+1)) 
            }
             else {
            return auxiliarMaior(f,maior,menor+1,f(menor))
            }
    }
    return maiorEntre
}

//Cria conjuntos dentro de conjuntos a partir de uma lista de funções (sendo a lista [(f,g,h,i)] para (x) deve-se retornar f(g(h(i(x)))) )
fun receberLista(f:List<(Int)->Int>):(Int)->Int = 
{ x -> { if(f.size() == 1){
                f(x)
    } else { f(receberLista(f.drop(1))) }
    }
}

//Cria inversamente conjuntos dentro de conjuntos a partir de uma lista de funções (sendo a lista [(f,g,h,i)] para (x) deve-se retornar i(h(g(f(x)))) )
fun receberListaInverso(f:List<(Int)->Int>):(Int)->Int {
    {x -> receberAuxiliar(f,x,f.size())} 
}

//Auxiliar da função inversa, dando como entrada um contador que irá desempilhar a recursão quando apenas o último elemento estiver contido na lista
fun receberAuxiliar(f:List<(Int)->Int>,x:Int,contador:Int):(Int) -> Int {
        if(contador==1) { f(x)
        } else { f.remove()
         f(receberAuxiliar(f,x,contador-1))}
}

//Cálculo de potência a partir de funções
fun potencia(f:(Int)->Int,vezes:Int):Int{
    x -> potenciaAuxiliar(f,vezes,x,vezes)
}

//Auxiliar do potencia
fun potenciaAuxiliar(f:(Int)->Int,vezes:Int,valorInserido:Int,contador:Int):Int{
    if(contador == 0) { f(valorInserido)
    } else if(valorInserido == 0) { f(0)
    } else { f(potenciaAuxiliar(f,vezes,valorInserido,contador -1))
    } 
}

//Função sigma para chamada dentro de funções de alta ordem
fun dobro(x: Int): Int = 2 * x
val d = ::dobro    
val valorPotenciado = potencia(d,3)


//Verificar se uma subsequencia está contida em uma sequencia
fun contem(l:List,l2:List):Boolean = when{
     (l is Nil && l2 is Nil) -> true
     (l is Node && l2 is Nil) -> true
     (l is Nil  && l2 is Node) -> false
     (l is Node  && l2 is Node) -> if(l.info == l2.info){
                        contem(l.prox,l2.prox)
                    } else{
                    contem(l.prox,l2)
                    } 
    else -> false
 }
 
//Concatenar duas listas intercaladamente 
 fun concatenarIntercaladamente(l:List,l2:List):List = when{ 
     (l is Node && l2 is Nil) -> l
     (l is Nil && l2 is Node) -> l2
     (l is Node && l2 is Node) -> Node(l.info,Node(l2.info,concatenarIntercaladamente(l.prox,l2.prox)))
     else -> Nil
 }

//Cria conjuntos dentro de conjuntos a partir de uma lista de funções (sendo a lista [(f,g,h,i)] para (x) deve-se retornar f(g(h(i(x)))) )
fun receberLista(f:List<(Int)->Int>):(Int)->Int {
    { x -> { if(f.size() == 1){
                f(x)
    } else { f(receberLista(f.drop(1))) }
    }
}

//Domingo

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



fun troca(frase:String):String {
            if(frase.isEmpty()){
                return " "
            }
            if(frase.elementAt(0) == '.'){
                return 'a' + troca(frase.drop(2))

            }
            else if(frase.elementAt(0) == '-'){
                if(frase.elementAt(2) == '.'){
                    return 'b' + troca(frase.drop(4))
                } else {
    return 'c'+ troca(frase.drop(4))
        }
    }
    return " "
}

 //QUINTA

 

//Cria inversamente conjuntos dentro de conjuntos a partir de uma lista de funções (sendo a lista [(f,g,h,i)] para (x) deve-se retornar i(h(g(f(x)))) )
fun receberListaInverso(f:List<(Int)->Int>):(Int)->Int =  {x -> receberAuxiliar(f,x,f.size)} 
//Auxiliar da função inversa, dando como entrada um contador que irá desempilhar a recursão quando apenas o último elemento estiver contido na lista
fun receberAuxiliar(f:List<(Int)->Int>,x:Int,contador:Int):Int {
        if(contador==0) {
            return x
        } else { 
            return f(receberAuxiliar(f.drop(1),x,contador-1))}
}



/* MAIN's  
//Main com tipos de listas diferentes, recomendo um uso por vez.
fun main() {
    val l1 = listOf(3,4,5,6,7,8,9,5,13,1,42,2,10)
    val l2 = Node(45,Node(42,Node(55,Node(77,Nil))))
    println(menor(l2))
    println(menor(l1))
    println(reducaoTermos(l1))
    println(contador(l1,11))
}

//Main com o código morse
fun main(){
    println(troca(".-.--.-.-...-.-..-.-"))
}

//Main com tipos de listas diferentes, recomendo um uso por vez.
fun main(){
    
    val l1 = Node(1,Node(2,Node(3,Node(4,Nil))))
    println("Remove pares:" + removePares(l1))
    println("Calcula Soma:" + calcularSomaElementosNode(l1))
    val l2 = Node(2,Node(3,Nil))
    println("Verificar subsequencia:" + contem(l1,l2))
    println(maiorValorEntre(d,7,5))
    print(remove(l1,2))

}

*/



