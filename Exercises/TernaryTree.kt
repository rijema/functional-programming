//Criação de uma arvore Ternária, sem preceitos de binariedade( esquerda < raiz e direita > raiz) 
abstract class Arvore
data class NoArvore(val info: Int,val esquerda: Arvore, val meio: Arvore, val  direita: Arvore):Arvore()
object N: Arvore()

//(depth-first search)Calcula a altura dos Nos de uma árvore Ternária, ou seja, retornará o maior caminho da árvore
fun calcularAltura(arvoreUm:Arvore):Int = when (arvoreUm){
    is NoArvore ->  {
                val alturaEsquerda = calcularAltura(arvoreUm.esquerda)
                val alturaMeio = calcularAltura(arvoreUm.meio)
                val alturaDireita = calcularAltura(arvoreUm.direita)

                if(alturaEsquerda > alturaMeio && alturaEsquerda > alturaMeio) alturaEsquerda + 1
                else if(alturaMeio > alturaEsquerda && alturaMeio > alturaDireita) alturaMeio + 1
                else alturaDireita + 1
    }
    else -> -1
}

//(breadth-first search by level) Calcula quantos nós existem em um determinado nível daquela árvore
fun calcularQuantidadeNosNivel(arvoreUm:Arvore,nivel:Int):Int = when (arvoreUm){
    is NoArvore -> {
                if(nivel==0){
                        1
                } else{

            val alturaEsquerda = 0 + calcularQuantidadeNosNivel(arvoreUm.esquerda,nivel-1)
            val alturaMeio = 0 + calcularQuantidadeNosNivel(arvoreUm.meio,nivel-1)
            val alturaDireita = 0 + calcularQuantidadeNosNivel(arvoreUm.direita,nivel-1)
            
            alturaDireita+alturaEsquerda+alturaMeio

            }  
    }  
    else -> {
         0
    }
}

//Verifica se em cada nível há um limite de 2^(nivel) nós 
fun verificarExponencialidade(arvoreUm:Arvore):Boolean {
    return auxiliarExponencialidade(arvoreUm,calcularAltura(arvoreUm),0)
}

fun auxiliarExponencialidade(arvoreUm:Arvore,loop:Int,nivel:Int):Boolean = when{
    (nivel <= loop) -> {if(calcularQuantidadeNosNivel(arvoreUm,nivel) > baseDois(nivel)){
                             false
                     } else {
                        auxiliarExponencialidade(arvoreUm,loop,nivel+1)
                    }
               }
    else -> true
                  
}

//Calcula a potência de 2 a base do número de entrada
fun baseDois(numero:Int):Int {
    if(numero == 0){
        return 1
    } 
    return 2*(baseDois(numero-1))
    }

//Criará uma lista com a árvore associada, dissertando os nós.
fun criarLista(arvoreUm:Arvore):Arvore = when(arvoreUm){
    is NoArvore -> {
            val listaEsquerda = criarLista(arvoreUm.esquerda)
            val listaMeio = criarLista(arvoreUm.meio)
            val listaDireita = criarLista(arvoreUm.direita)

            concatenarDuplo(listaEsquerda,concatenarDuplo(listaMeio,listaDireita))
    }
    else -> N
}

//Cria uma sublista da Árvore Ternária a partir de uma posição(nível) específico
fun criarListaEspecifica(arvoreUm:Arvore,n:Int):Arvore = when{
    (arvoreUm is NoArvore && n > 1) -> {
                    val listaEsquerda = criarListaEspecifica(arvoreUm.esquerda,n-1)
                    val listaDireita  = criarListaEspecifica(arvoreUm.direita,n-1)
                    val listaMeio = criarListaEspecifica(arvoreUm.meio,n-1)

                    concatenarDuplo(listaEsquerda,concatenarDuplo(listaMeio,listaDireita))
    }
    (arvoreUm is NoArvore && n == 1) -> {
                    val finalEsquerda = criarListaFinal(arvoreUm.esquerda)
                    val finalMeio = criarListaFinal(arvoreUm.meio)
                    val finalDireita = criarListaFinal(arvoreUm.direita)
                    
                    concatenarDuplo(finalEsquerda,concatenarDuplo(finalMeio,finalDireita))
    }
    else -> N
}

//Cria a estrutura de retorno para a última posição de uma árvore, ou seja, um nó que contém as folhas
fun criarListaFinal(arvoreFinal:Arvore):Arvore = when (arvoreFinal)  {
    is NoArvore -> NoArvore(arvoreFinal.info,N,N,N)
    else -> N
}

//Função que irá concatenar duas árvores ternárias.
fun concatenarDuplo(arvoreUm:Arvore,arvoreDois:Arvore):Arvore = when {
    arvoreUm is NoArvore -> NoArvore(arvoreUm.info,concatenarDuplo(arvoreUm.esquerda,arvoreDois),concatenarDuplo(arvoreUm.meio,arvoreDois),concatenarDuplo(arvoreUm.direita,arvoreDois))
    arvoreDois is NoArvore -> NoArvore(arvoreDois.info,concatenarDuplo(arvoreDois.esquerda,N),concatenarDuplo(arvoreDois.meio,N),concatenarDuplo(arvoreDois.direita,N))
    else -> N
}

//Irá testar a igualdade a partir das funções escritas acima.
fun verificarIgualdade(arvoreUm:Arvore,arvoreDois:Arvore):Boolean {
    val primeira = criarListaEspecifica(arvoreUm,calcularAltura(arvoreUm))
    val segunda = criarListaEspecifica(arvoreDois,calcularAltura(arvoreDois))
    if(primeira == segunda) { 
        return true 
    } 
    return false
}

//Teste básico de igualdade entre dois objetos.
fun verificarIgualdadeSimples(arvoreUm:Arvore,arvoreDois:Arvore):Boolean {
    if(arvoreUm == arvoreDois) { 
        return true 
    } 
    return false
}


//Visualização de execução das funções. Para melhor visualização, indico apenas um por compilação.
fun main(){
    val one = NoArvore(1,NoArvore(2,NoArvore(22,N,N,N),NoArvore(222,N,N,N),NoArvore(2222,N,N,N)),NoArvore(3,NoArvore(33,N,N,N),NoArvore(333,N,N,N),NoArvore(3333,N,N,N)),NoArvore(4,NoArvore(44,N,N,N),NoArvore(444,N,N,N),NoArvore(4444,N,NoArvore(5,N,N,N),N)))
    println(calcularAltura(one))
    println(calcularQuantidadeNosNivel(one,1))
    println(">>>>>" + baseDois(4))
    println("Verificando Exponencialidade: " + verificarExponencialidade(one))
    //val exponencial = NoArvore(1,NoArvore(2,NoArvore(22,N,N,N),N,N),NoArvore(3,NoArvore(33,N,N,N),NoArvore(333,N,N,N),NoArvore(3333,N,N,N)),NoArvore(4,NoArvore(44,N,N,N),NoArvore(444,N,N,N),NoArvore(4444,N,NoArvore(5,N,N,N),N)))
    val exponencial2 =  NoArvore(1,NoArvore(2,NoArvore(22,N,N,N),N,N),NoArvore(45,NoArvore(23,N,N,N),N,N),NoArvore(76,NoArvore(67,N,N,N),N,N))
    println("Verificando Exponencialidade: " + verificarExponencialidade(exponencial2))
    val exponencial3 =  NoArvore(1,NoArvore(2,NoArvore(22,N,N,N),N,N),N,NoArvore(76,NoArvore(67,N,N,N),N,N))
    println("Verificando Exponencialidade: " + verificarExponencialidade(exponencial3))

    /*
    val two = NoArvore(1,NoArvore(4,NoArvore(44,N,N,N),NoArvore(555,N,N,N),NoArvore(22,N,N,N)),NoArvore(31,NoArvore(35,N,N,N),NoArvore(673,N,N,N),NoArvore(3,N,N,N)),NoArvore(42,NoArvore(8,N,N,N),NoArvore(88,N,N,N),NoArvore(8888,N,NoArvore(9,N,N,N),N)))
    val three = NoArvore(1,NoArvore(4,NoArvore(44,N,N,N),NoArvore(555,N,N,N),NoArvore(22,N,N,N)),NoArvore(31,NoArvore(35,N,N,N),NoArvore(673,N,N,N),NoArvore(3,N,N,N)),NoArvore(42,NoArvore(8,N,N,N),NoArvore(88,N,N,N),NoArvore(8888,N,NoArvore(9,N,N,N),N)))
    val four = NoArvore(0,NoArvore(4,NoArvore(92,N,N,N),NoArvore(555,N,N,N),NoArvore(22,N,N,N)),NoArvore(31,NoArvore(35,N,N,N),NoArvore(673,N,N,N),NoArvore(3,N,N,N)),NoArvore(42,NoArvore(8,N,N,N),NoArvore(88,N,N,N),NoArvore(8888,N,NoArvore(9,N,N,N),N)))

    
   println(concatenarDuplo(one,two))
   println(criarListaEspecifica(two,2))
   println(verificarIgualdade(two,three))
   println(criarLista(two))
   println(verificarIgualdade(two,four))
   println(verificarIgualdadeSimples(two,three))
   println(verificarIgualdadeSimples(two,four)) 
 */
    }


 //Funções base para criação. Não funcionam.
    /* 
fun concatenarUm(arvoreUm:Arvore):Arvore = when {
    arvoreUm is NoArvore -> NoArvore(arvoreUm.info,concatenarUm(arvoreUm.esquerda),concatenarUm(arvoreUm.meio),concatenarUm(arvoreUm.direita))
    else -> N
}

fun concatenar(arvoreUm:Arvore,arvoreDois:Arvore):Arvore {
    val listaUm = concatenarUm(arvoreUm)
    val listaDois = concatenarUm(arvoreDois)
    
    return listaUm + listaDois

}

*/