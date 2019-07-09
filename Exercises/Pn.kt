abstract class Arvore
data class NoArvore(val info:Int,val listaTail:List<Arvore>):Arvore()
object ArvoreVazia:Arvore()

fun verificarExponencialidade(arv:Arvore,nivel:Int):Boolean = when(arv){
    is NoArvore -> limparLista(arv,nivel,true,arv.listaTail)
    else -> true
}
fun limparLista(arv:Arvore,nivel:Int,condicao:Boolean,lista : List<Arvore>):Boolean {
    if (condicao == false) {
        return false
    }
    if (arv is NoArvore) {
        if (arv.listaTail.isEmpty()) {
            limparLista(arv,nivel+1,false,arv.listaTail)
        } else {
            if (calcularFilhosNivel(arv.listaTail[0]) > 2) {
                limparLista(arv, nivel, false, arv.listaTail.drop(0))
            } else {
                limparLista(arv, nivel, true, arv.listaTail.drop(0))
            } } }
    return true }

fun elevarDois(nivel:Int):Int{
        if(nivel == 0){ return 1 }
        else{ return 2*elevarDois(nivel-1) }
    }

fun calcularFilhosNivel(arv:Arvore):Int = when(arv){
    is NoArvore -> (arv.listaTail.size)
    else -> 0
}
