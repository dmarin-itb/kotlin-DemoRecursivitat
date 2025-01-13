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