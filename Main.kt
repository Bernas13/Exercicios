// Jogo de cartas-- sistemas de pontos //

fun temKQJ (carta1: String, carta2:String): Boolean = carta1 == "K" || carta1 == "Q" || carta1 == "J" || carta2== "K" || carta2 == "Q" || carta2 == "J"

fun pontosAs(carta: String, temKQJ: Boolean): Int
{
    when
    {
        temKQJ && carta == "A" -> return 11
        !temKQJ && carta == "A" -> return 1
        else -> return 0
    }
}

fun pontosKQJ(carta: String): Int
{
    when(carta)
    {
        "K" , "Q" , "J" -> return 10
        else -> return 0
    }
}

fun outrosPontos(carta: String): Int
{
    when(carta.toIntOrNull())
    {
        null -> return 0
        else -> return carta.toInt()
    }
}

fun pontosTotais(carta1: String, carta2: String): Int
{
    var pontos = 0
    when(carta1)
    {
        "K", "Q" , "J" -> pontos += pontosKQJ(carta1)
        "A" -> pontos += pontosAs(carta1,temKQJ(carta1 , carta2))
        else -> pontos += outrosPontos(carta1)
    }
    when(carta2)
    {
        "K", "Q" , "J" -> pontos += pontosKQJ(carta2)
        "A" -> pontos += pontosAs(carta2,temKQJ(carta1 , carta2))
        else -> pontos += outrosPontos(carta2)
    }
    return pontos
}

fun main(){
    println("Insira carta 1 (A,K,Q,J,10,9,8,7,6,5,4,3,2)")
    val carta1 = readLine()
    println("Insira carta 2 (A,K,Q,J,10,9,8,7,6,5,4,3,2)")
    val carta2 = readLine()
    if(carta1 != null && carta2 !== null){
        val pontos = pontosTotais(carta1, carta2)
        println("Pontos: ${pontos}")
    }else{
        println("So possivel calcular pontos com duas cartas validas")
    }
}
