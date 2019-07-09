abstract class List
data class Node(val info:Int,val prox:List):List()
object Nil: List()


fun bubbleSort(l:List):List() {
    return bubbleAux(l,l.size)
}

fun bubbleAux(l:List,aux:Int):List() = when(l){
    is Node -> (if(aux==0){ l }
                else if(l.info > l.prox.info){
                    val aux = l.info
                    l.info = l.prox.info
                    l.prox.info = aux
                    bubbleAux(l.prox,aux)
                })
                else { bubbleAux(l.prox,aux)}
    else -> bubbleAux(l,aux-1)
}

fun mergeSort(l:List):List{
    fun aux (l1:List,l2:List):List = when{
        l1 is Node && l2 is Node ->
            if(l1.size == 1 && l2.size == 1){
                if (l1.head > l2.head){
                    Node(l2,l1)
                }else
                    Node(l1,l2)
            }else
                Node(mergeSort(l1),mergeSort(l2))
        l1 is Node && l2 is Nil -> l1
        l1 is Nil && l2 is Node -> l2
        else -> Nil
    }
        if (l is Node){
            val l1 = primeiraMetade(l,l.size/2)
            val l2 = segundaMetade(l,l.size/2)
        }else
            Nil
    }
    return aux(l1,l2)
}

fun primeiraMetade(l:List, i:Int):List = when(l){
    is Node -> ( if (i <= l.size){
                 Node(l,primeiraMetade(l.tail,i))
                 } 
                 else 
                        Nil 
                        )
    else ->     Nil
}

fun segundaMetade(l:List, i:Int):List = when(l){
    is Node -> (if (i > l.size)
                Node(l,segundaMetade(l.tail,i))
               else Nil
               )
    else -> Nil

}

fun main(){
    val l2 = Node(45,Node(42,Node(89,Node(77,Nil))))
    println(bubbleSort(l2))
}

