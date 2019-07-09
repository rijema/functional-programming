

fun troca(frase:String):String{
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

fun main(){
    var x = "OiopameunomeéRichard"
    println(x)
    println("chamando: =>  " + x.drop(5))
    println(x)
    x = x.drop(2)
    println(x)
    x.dropLast(3)
    println(x)
    println(troca(".-.--.-.-...-.-..-.-"))
}