abstract class List
data class ListaExterna(val info: List,val prox: List):List()
data class ListaInterna(val info: Int,val prox: List):List()
object Nil: List()

fun concatena(l:List):List =  when(l) {
    is ListaExterna -> concatenaAux(l.info, concatena(l.prox))
    else -> Nil
}

fun concatenaAux(l:List,l2:List):List = when(l){
    is ListaInterna -> ListaInterna(l.info,concatenaAux(l.prox,l2))
    else -> l2
}

fun printar(l:List):Unit = when(l) {
    is ListaInterna -> {
        print(l.info); print(" -> "); printar(l.prox);
    }
    else -> print("Fim")
}

fun soma(f:(Int)->Int):(Int)->Int {
    fun aux(f:(Int)->Int,contador:Int):(Int)->Int = {
            x -> ( if(x==contador){ f(contador) }
    else { f(contador) + aux(f,contador +1 )}
            )

    }

}

fun calcularEntre(f:(Int)->Int,maior:Int,menor:Int):(Int)->Int {

    fun calcularEntreAux(f:(Int)->Int,maior:Int,menor:Int,verMaior:Int):Int = when{
        menor < maior -> { if(f(menor)<f(menor+1)){ calcularEntreAux(f,maior,menor+1,f(menor+1)) }
        else { calcularEntreAux(f,maior,menor+1,menor) }
        }
        menor == maior -> verMaior
        else -> -1
    }

    return calcularEntreAux(f,maior,menor,0)
}

fun inverso(f:(Int)->Int):(Int)->Int =  {x ->
    (
    val z = f(x)
    1 / f(z)
    )
}

}

fun dobro(x:Int):Int = x/(x-1)

fun decrescencia(f:(Int)->Int):(Int)->Boolean = { x -> if(f(x)>f(x+1)) true else false }



fun main(){
    var l1 = mutableListOf<Int>(1,2,3,4,3)
    val l2 = l1.sorted()
    val l3 = l2.reduce{x,y -> x+y}
    val l4 = l1.spliterator()
}




fun main(){
    val l = ListaExterna(ListaInterna(1,ListaInterna(2,Nil)),ListaExterna(ListaInterna(3,ListaInterna(4,Nil)),Nil))
    printar(concatena(l))
}


