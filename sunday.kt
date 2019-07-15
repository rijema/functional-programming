abstract class List
class Node(val info:Int,val prox:List):List()
object Nil: List()

//Concatena duas listas para resolução das questões abaixo
fun concat(l1:List,l2:List):List = when{ 
    l1 is Node && l2 is Nil -> l1
    l2 is Node && l1 is Nil -> l2
    l1 is Node && l2 is Node -> Node(l1.info,concat(l1.prox,l2))
    else -> Nil
}

/*rodar-esquerda: recebe um número natural, uma lista e retorna uma nova lista onde a posição dos elementos 
mudou como se eles tivessem sido "rodados" ex.: (rodar-esquerda 0 '(a s d f g)) ==> (a s d f g) (rodar-esquerda 1
 '(a s d f g)) ==> (s d f g a) (rodar-esquerda 3 '(a s d f g)) ==> (f g a s d) 
 (rodar-esquerda 4 '(a s d f g)) ==> (g a s d f)
 */
fun rodarE(l1:List,n:Int):List{

    fun pegarUltimos(l1:List,n:Int):List = when(l1){
        is Node -> {if(n==0) Node(l1.info,pegarUltimos(l1.prox,n))
                    else{ pegarUltimos(l1.prox,n-1)
                        }
                    }
        else -> Nil
    }

    fun pegarPrimeiros(l1:List,n:Int):List = when(l1){
        is Node -> { if(n>0) {Node(l1.info,pegarPrimeiros(l1.prox,n-1)) }
            	     else { pegarPrimeiros(Nil,0)}
                    }
        else -> Nil           
    }

    return concat(pegarUltimos(l1,n),pegarPrimeiros(l1,n))
}

/*palindrome?: recebe uma string e verifica se ela é uma palíndrome ou nao ex.: (palindrome? "ana") ==>
 #t (palindrome? "abbccbba") ==> #t (palindrome? "abbdbbaa") ==> #f
 */
fun palindrome(l1:String):Boolean{

    fun palindromeAux(l1:String,n:Int,z:Int):Boolean = when {
        (z < n) ->
            true
        l1.elementAt(n) == l1.elementAt(z) -> palindromeAux(l1, n + 1, z - 1)
        else -> false
    }

    fun palindromeAuxImpar(l1:String,n:Int,z:Int):Boolean = when {
        (z == n) ->
            true
        l1.elementAt(n) == l1.elementAt(z) -> palindromeAuxImpar(l1, n + 1, z - 1)
        else -> false
    }

    if(l1.length %2 == 0){
        return palindromeAux(l1,0,l1.length-1)
    }
    return  palindromeAuxImpar(l1,0,l1.length-1)
}

//primo?: verifica se um número é primo ou não
fun primo(l:Int):Boolean{
    fun primoAux(l:Int,percorrer:Int,contador:Int):Boolean = when {
        (percorrer<=l) -> { if(l%percorrer==0) { primoAux(l,percorrer+1,contador+1) }
                         else{ primoAux(l,percorrer+1,contador) }
            }
        else -> {
            if (contador > 2) false
            else true
        }
        }
    return primoAux(l,1,0)
}




/*
seleciona: recebe uma lista qualquer e uma lista de posições, retorna uma lista com os 
elementos da primeira que estavam nas posições indicadas ex.: (seleciona '(a b c d e f) 
'(0 3 2 3)) ==> (a d c d)
 */

 fun pegarElementos(l1:List,l2:List):List {
     return pegarAuxiliar(l1,l2,l1,0)
 }

 fun pegarAuxiliar(l1:List,l2:List,reserva:List,n:Int):List = when{
     (l2 is Node && l1 is Node) ->  {if(n == l2.info) { Node(l1.info,pegarAuxiliar(reserva,l2.prox,reserva,0))
                                 } else{
                                        pegarAuxiliar(l1.prox,l2,reserva,n+1)
                                    }
                                 }
    (l2 is Nil || l1 is Nil) -> Nil
     else -> Nil
 }


/* 
divide: recebe uma lista e um número natural n, retorna um par onde o primeiro elemento é uma lista
 com os n primeiros números da lista original e o segundo elemento é uma lista com o resto 
dos elementos da lista original ex.: (divide '(1 2 3 4) 0) ==> (() 1 2 3 4) (divide '(1 2 3 4) 2) ==> ((1 2) 3 4)
*/

fun retornarListas(l:List,n:Int):Pair<List,List>{
    fun rA(l:List ,n:Int,a:List,b:List):Pair<List,List> =  when(l) {
            is Node -> { if(n > 0) {
                            rA(l.prox,n-1,concat(a,Node(l.info,Nil)),b)
                            }
                        else { 
                            rA(l.prox,n,a,concat(b,Node(l.info,Nil)))
                            }
                        }          
            else -> Pair(a,b)
    }
        return rA(l,n,Nil,Nil)
    
}

//Função print auxiliar
fun printarLista(l:List):Unit = when(l){
    is Node -> { print(l.info)
                 print(" -> ")
                printarLista(l.prox)
                 }
    else -> print("FIM")
        
}

fun main(){
    val l1 =  Node(42,Node(56,Node(9,Node(8,Node(1,Node(88,Node(2,Nil)))))))
    val l3 =  Node(3,Node(8,Node(4,Node(1,Node(17,Node(16,Nil))))))
    val l4 = Node(0,Node(1,Node(0,Node(2,Nil))))
    //8 4 3 1
    val l2 = retornarListas(l1,0)
    printarLista(l2.first)
    println(" ")
    printarLista(l2.second)
    println(" ")
    printarLista(concat(l1,l3))
    println(" ")
    printarLista(l1)
    println()
    print("LISTA GIRADA ESQUERDA = ")
    printarLista(rodarE(l4,5))
    println()
    println(" ")
    printarLista(pegarElementos(l1,l4))
    println()
    println("PALINDROMO")
    val l6 = "subinoonibus"
    val l7 = "abasdas"
    val l8 = "abazaba"
    val l9 = "suasdasd"
    println(palindrome(l6))
    println(palindrome(l7))
    println(palindrome(l8))
    println(palindrome(l9))
    
    val l10 = 14
    println(primo(l10))
    val l11 = 13
    println(primo(l11))

    
}



/*
Buscar tecnica para ao receber o número de giros da direita para esquerda de forma que ultrapasse o limite da string e 
ainda sim esteja dentro dela.

rodar-direita: recebe um número natural, uma lista e retorna uma nova lista onde a posição dos elementos mudou como se
 eles tivessem sido "rodados" ex.: (rodar-direita 0 '(a s d f g)) ==> (a s d f g) 
 (rodar-direita 1 '(a s d f g)) ==> (g a s d f) (rodar-direita 3 '(a s d f g)) ==> (d f g a s)
  (rodar-direita 4 '(a s d f g)) ==> (s d f g a)
 

 fun rodarD(l1:List,n:Int):List{
     fun pegarTail(l1:List,n:Int):List = when(l1){
      is Node -> { if(n==0){
                    Node(l1.info,pegarTail(l1.prox,n))
                    } else {
                        pegarTail(l1.prox,n-1)
                    }
      }
      else -> Nil
     }
     fun pegarHead(l1:List,n:Int):List = when(l1){
         is Node -> { if(n>0){
                    Node(l1.info,pegarHead(l1.prox,n-1))
         }          else{
                    pegarHead(Nil,0)
         }
         }
        else -> Nil
         }

        fun calcularGirada(l1:List,n:Int):Int {
            is Node ->  calcularGirada(l1.prox,n+1)
            else -> {   if(n)

            } 3*3 size - 1 5  4 
                         8 - n
            1 2 3 4 
        }
         return concat(pegarTail(l1,n+l1.size),pegarHead(l1,n+l1.size))
     }
 */

