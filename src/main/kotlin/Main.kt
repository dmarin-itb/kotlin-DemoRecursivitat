/**
 * Funció entry point per a l'execució dels mètodes que calculen el factorial
 * @author dmarin-itb
 */
fun main() {
    // Creació de dos arbres amb nodes
    val arbre1 = Node(
        1, listOf(
            Node(2, listOf(Node(4), Node(5))),
            Node(3, listOf(Node(6), Node(7)))
        )
    )
    val arbre2 = Node(
        1, listOf(
            Node(2, listOf(Node(4), Node(5), Node(10))),
            Node(3, listOf(Node(6), Node(7))),
            Node(11)
        )
    )
/*
    // Com partim del repositori amb les funcions recorrerArbre i aplanarArbre, mantenim les crides, però comentades
    println("Arbre 1:")
    recorrerArbre(arbre1)

    println("\nArbre 2:")
    recorrerArbre(arbre2)

    val arbreAplanat1 = aplanarArbre(arbre1)
    println("\nArbre 1 aplanat:")
    println(arbreAplanat1)

    val arbreAplanat2 = aplanarArbre(arbre2)
    println("\nArbre 2 aplanat:")
    println(arbreAplanat2)
*/
    println("CERCA:")
    val res = cercaEnArbreNari(arbre1, 3)
    println("$res està el número 3 a l'arbre")

    println("COMPTAR:")
    val res2 = qCopsEnArbreNari(arbre1, 3)
    println("El número 3 està $res2 cops a l'arbre")

    println("SUMAR:")
    val res3 = sumarArbreNari(arbre1)
    println("La suma de tots els elements de l'arbre és $res3")

}

/**
 * Funció recursiva per recórrer l'arbre i imprimir els valors dels nodes recorrent en profunditat primer (DFS, Depth-First Search)
 * @author dmarin-itb
 * @param node Element de tipus Node que actúa com a arrel (primer nivell) de l'arbre a recòrrer
 */
fun recorrerArbre(node: Node) {
    // Imprimeix el valor del node actual
    println(node.valor)

    // Recórrer cada fill del node actual
    for (fill in node.fills) {
        recorrerArbre(fill) // crida recursiva per recórrer els fills
    }
}

/**
 * Funció recursiva per aplanar l'arbre i retornar una llista amb els valors dels nodes recorrent en profunditat primer (DFS, Depth-First Search)
 * @author dmarin-itb
 * @param node Element de tipus Node que actua com a arrel de l'arbre
 * @return Llista amb els valors de tots els nodes de l'arbre
 */
fun aplanarArbre(node: Node): List<Int> {
    // Comença amb el valor del node actual
    val llistaArbre = mutableListOf(node.valor)

    // Per cada fill, crida recursivament a la funció i afegeix els valors a la llista
    for (fill in node.fills) {
        llistaArbre.addAll(aplanarArbre(fill))
    }

    return llistaArbre
}

/**
 * Funció recursiva per cercar l'element num a l'arbre recorrent en profunditat primer (DFS, Depth-First Search) retornant true si es troba, o false en cas contrari. És una cerca optimitzada, finalitza en el moment que troba la primera coincidència.
 * @author dmarin-itb
 * @param node Element de tipus Node que actúa com a arrel (primer nivell) de l'arbre a recòrrer
 * @param num Element de tipus Int que volem trobar com a valor dins els nodes de l'arbre
 * @return Boolean amb valor true si es troba l'element i false en cas contrari
 */
fun cercaEnArbreNari(node:Node, num:Int):Boolean{
    //var resultat:Boolean = false
    if(node.valor==num) return true
    else {
        for (fill in node.fills){
            if(cercaEnArbreNari(fill, num))
                return true
        }
    }
    return false
}

/**
 * Funció recursiva per cercar l'element num a l'arbre recorrent en profunditat primer (DFS, Depth-First Search) retornant la quantitat de vegades que es troba l'element a l'arbre.
 * @author dmarin-itb
 * @param node Element de tipus Node que actúa com a arrel (primer nivell) de l'arbre a recòrrer
 * @param num Element de tipus Int que volem trobar com a valor dins els nodes de l'arbre
 * @return Int amb la quantitat de troballes de num a l'arbre
 */
fun qCopsEnArbreNari(node:Node, num:Int):Int{
    var resultat:Int = 0

    if(node.valor==num) resultat = 1

    for (fill in node.fills){
        resultat += qCopsEnArbreNari(fill, num)
    }
    return resultat
}

/**
 * Funció recursiva per sumar els diferents elements que conformen l'arbre.
 * @author dmarin-itb
 * @param node Element de tipus Node que actúa com a arrel (primer nivell) de l'arbre a recòrrer
 * @return Int amb la suma de tots els valors de tots els nodes de l'arbre
 */
fun sumarArbreNari(node:Node):Int{
    var resultat:Int = 0

    resultat = node.valor

    for (fill in node.fills){
        resultat += sumarArbreNari(fill)
    }
    return resultat
}
