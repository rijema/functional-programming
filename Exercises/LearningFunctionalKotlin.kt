Inicialmente, se quero usar recursividade, tenho que trabalhar com essas linhas de código também
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
//Obs: Há erro por falta de verificação se o l2 é do tipo Node.
fun contem(l:List,l2:List):Boolean = when(l){
        is Node -> if(l.info == l2.info){
                        contem(l.prox,l2.prox)
                    } else{
                    contem(l.prox,l2)
                     }
         else ->  if(l2 == null){true} else{false}
        
    }

