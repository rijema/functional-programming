fun potencia(x:Int,pow:Int):Int = when{
    (pow > 0) -> (if(pow == 0){
        1
    }else {
        val aux = potencia(x,pow/2)
        if(pow%2==0){
            aux*aux
        } else {
            aux*aux*x
        }
    })
    else -> -1

}
   

fun main(){
    println(potencia(2,3))
}