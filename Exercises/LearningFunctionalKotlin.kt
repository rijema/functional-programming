abstract class List()
data class Node( val info:Int,val prox:List):List() 
object Nil:List()

 /*
fun calcularSomaElementos(l:List):Int{
    if(l.info == null){
        0
    }
    else {
        l.info + calcularSomaElementos(l.prox)
    }
}
 */

fun calcularSomaElementosNode(l:List):Int = when(l){
    is Node -> l.info + calcularSomaElementosNode(l.prox)
    else -> 0
}

fun removePares(l:List):List = when (l){
    is Node -> if((l.info%2)!=0){
                Node(l.info,removePares(l.prox))
            } else{removePares(l.prox)}
    else -> Nil
}
/* 
fun contem(l:List,l2:List):Boolean = when(l){
         is Node ->   if(l.info == null && l2.info != null){ false
            } else if(l.info == null && l2.info == null){ true }
        else -> if(l.info == l2.info){
                    contem(l.prox,l2.prox)
                    } else{
                    contem(l.prox,l2)
                     }
            }


fun contem(l:List,l2:List):Boolean = when(l){
        is Node -> if(l.info == l2.info){
                        contem(l.prox,l2.prox)
                    } else{
                    contem(l.prox,l2)
                     }
         else ->  if(l2 == null){true} else{false}
        
            }

fun contem(l:List,l2:List):Boolean {
        if(l==List || l2==List){
            if(l.info == l2.info){
                        contem(l.prox,l2.prox)
                    } else{
                    contem(l.prox,l2)
                     }
        } 
         else{ if(l2 == null){true} else{false}}
        
 }

  fun contem(l:List,l2:List):Boolean{
        if(l==List || l2==List){
            if(l.info == l2.info){
                        contem(l.prox,l2.prox)
                    } else{
                    contem(l.prox,l2)
                     }
        } 
         else{ if(l2 == null){true} else{false}}
        
 }
*/
 fun contem(l:List,l2:List):Boolean = when(l2){

     is Node -> when(l){
            is Node -> if(l.info == l2.info){
                        contem(l.prox,l2.prox)
                    } else{
                    contem(l.prox,l2)
                     }
            else ->  if(l2 == null){true} else{false}
            }
     else -> false
 }

fun main(){
    val l1 = Node(1,Node(2,Node(3,Node(4,Nil))))
    println("Remove pares:" + removePares(l1))
    println("Calcula Soma:" + calcularSomaElementosNode(l1))
    val l2 = Node(2,Node(3,Nil))
    println("Verificar subsequencia:" + contem(l1,l2))
}