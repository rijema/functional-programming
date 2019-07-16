abstract class List
data class Node(val info:Int,val prox:List):List()
object Nil: List()

fun triplo(l:List):Triple<List,List,List>{
    fun tAux(l:List,a:List,b:List,c:List):Triple<List,List,List> = when(l){
        is Node -> { if(l.info%2!=0) tAux(l.prox,concat(a,Node(l.info,Nil)),b,c)
                    else if(l.info%4==0) tAux(l.prox,a,concat(b,Node(l.info,Nil)),c)
                    else tAux(l.prox,a,b,concat(c,Node(l.info,Nil)))
        }
        else -> Triple(a,b,c)
    }
    return tAux(l,Nil,Nil,Nil)
}


fun concat(l1:List,l2:List):List = when{
    l1 is Node -> Node(l1.info,concat(l1.prox,l2))
    else -> l2
}


fun bubbleSort(l:MutableList<Int>):List<Int>{
    return bubbleAux(l,0,l.size-1)
}

fun bubbleAux(l:MutableList<Int>,aux:Int,repeticoes:Int):List<Int> = when{
    repeticoes == 0 -> l

    aux == l.size-1 -> bubbleAux(l,0,repeticoes-1)

    l.elementAt(aux) > l.elementAt(aux+1) -> {
        val auxiliar = l.elementAt(aux)
        l[aux] = l.elementAt(aux+1)
        l[aux+1] = auxiliar
        bubbleAux(l,aux+1,repeticoes)


    }
    else -> bubbleAux(l,aux+1,repeticoes)

}

fun main(){
    val l1 = mutableListOf(4,56,7,2,1312,542,55,3,2,1,56,5)
    println(bubbleSort(l1))
}
