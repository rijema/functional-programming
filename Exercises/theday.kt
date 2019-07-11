
//Executa uma função encadeada de forma tripla.
fun executarTriplo(f:(Int)->Int):(Int) -> Int = { x:Int -> f(f(f(x))) }


    fun dobro(x:Int):Int = x*x
    fun triplo(x:Int):Int = x*x*x
    fun quadruplo(x:Int):Int = x*x*x*x
    val d = ::dobro
    val t = ::triplo
    val q = ::quadruplo

    fun main(){
        println(executarTriplo(d)(14))
    }
    
//Verifica se uma função é decrescente em um ponto específico.
fun verificarDecresceste(f:(Int)->Int):(Int)->Boolean = { x -> auxiliar(f(x),f(x+1)) }

fun auxiliar(f:Int,g:Int):Boolean{
   	if(g<=f) { println("$g é maior que $f") 
    println("Função é decrescente") 
    return true
    }
    println("Função é crescente")
    println("$f é maior que $g")
    return false
}
