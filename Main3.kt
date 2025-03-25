import java.util.Scanner

data class Pessoa(
    val nome: String,
    val altura: Double
)

fun main() {
    val pessoas = mutableListOf<Pessoa>()
    val scanner = Scanner(System.`in`)

    while (true) {
        println("Menu de Opções:")
        println("1. Cadastrar registros")
        println("2. Apresentar registros <= 1.5m")
        println("3. Apresentar registros > 1.5m")
        println("4. Apresentar registros > 1.5m e < 2.0m")
        println("5. Apresentar média das alturas")
        println("6. Sair")
        print("Escolha uma opção: ")
        when (scanner.nextInt()) {
            1 -> cadastrarRegistros(pessoas, scanner)
            2 -> apresentarRegistrosMenoresOuIguais(pessoas, 1.5)
            3 -> apresentarRegistrosMaiores(pessoas, 1.5)
            4 -> apresentarRegistrosIntervalo(pessoas, 1.5, 2.0)
            5 -> apresentarMediaAlturas(pessoas)
            6 -> break
            else -> println("Opção inválida, tente novamente.")
        }
    }
}

fun cadastrarRegistros(pessoas: MutableList<Pessoa>, scanner: Scanner) {
    scanner.nextLine() // Consumir a nova linha
    for (i in 1..15) {
        println("Cadastro ${i}:")
        print("Nome: ")
        val nome = scanner.nextLine()
        print("Altura: ")
        val altura = scanner.nextDouble()
        scanner.nextLine() // Consumir a nova linha
        pessoas.add(Pessoa(nome, altura))
    }
}

fun apresentarRegistrosMenoresOuIguais(pessoas: List<Pessoa>, limite: Double) {
    println("Pessoas com altura <= $limite m:")
    pessoas.filter { it.altura <= limite }.forEach { println("Nome: ${it.nome}, Altura: ${it.altura}") }
}

fun apresentarRegistrosMaiores(pessoas: List<Pessoa>, limite: Double) {
    println("Pessoas com altura > $limite m:")
    pessoas.filter { it.altura > limite }.forEach { println("Nome: ${it.nome}, Altura: ${it.altura}") }
}

fun apresentarRegistrosIntervalo(pessoas: List<Pessoa>, limiteInferior: Double, limiteSuperior: Double) {
    println("Pessoas com altura > $limiteInferior m e < $limiteSuperior m:")
    pessoas.filter { it.altura > limiteInferior && it.altura < limiteSuperior }.forEach { println("Nome: ${it.nome}, Altura: ${it.altura}") }
}

fun apresentarMediaAlturas(pessoas: List<Pessoa>) {
    val media = pessoas.map { it.altura }.average()
    println("Média das alturas: $media m")
}