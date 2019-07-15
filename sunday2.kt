fun palindrome(l1:String):Boolean {
    fun palindromeAux(l1:String,n:Int,z:Int):Boolean {
            if(l1.length %2 == 0) {
                if(z < n){
                    return true
                } 
                else if(l1.elementAt(n).equals(l1.elementAt(z))){
                    palindromeAux(l1,n+1,z-1)
                }
                else {
                   return false
                }
            } else {
                if(z == n){
                    return true
                } 
                else if(l1.elementAt(n).equals(l1.elementAt(z))){
                    palindromeAux(l1,n+1,z-1)
                }
                else {
                    return false
                }
            } 
            return false 
    }
            return palindromeAux(l1,0,l1.length-1)
}

fun main(){
    val l1:String = "subinoonibus"
    val l2:String = "mymyaymym"
    val l3:String = "subinoonxbus"
    val l4:String = "mymyaydym"
    println(palindromeR (l1))
    println(l1.elementAt(0))
    println(l1.elementAt(l1.length-1))
    val resultado = l1.elementAt(0).equals(l1.elementAt(l1.length-1))
    println(resultado)
    
    println(palindrome(l2))
    
    println(palindrome(l3))
    
    println(palindrome(l4))


}