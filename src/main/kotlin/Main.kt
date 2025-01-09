/**
 * Funció entry point per a l'execució dels mètodes que calculen el factorial
 * @author dmarin-itb
 */
fun main() {
    // Creació d'un arbre amb nodes
    val arbre1 = Node(
        1, listOf(
            Node(2, listOf(Node(4), Node(5))),
            Node(3, listOf(Node(6), Node(7)))
        )
    )
    println("Arbre 1:")
    recorrerArbre(arbre1)

    val arbre2 = Node(
        1, listOf(
            Node(2, listOf(Node(4), Node(5), Node(10))),
            Node(3, listOf(Node(6), Node(7))),
            Node(11)
        )
    )
    println("\nArbre 2:")
    recorrerArbre(arbre2)
}

/**
 * Definició de la classe Node per representar cada node de l'arbre
 */
data class Node(
    val valor: Int,
    val fills: List<Node> = listOf()
)

/**
 * Funció recursiva per recórrer l'arbre i imprimir els valors dels nodes
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