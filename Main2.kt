import java.util.Scanner

data class Aluno(
    val nome: String,
    val notas: List<Double>
) {
    val media: Double
        get() = notas.average()

    val status: String
        get() = if (media >= 5) "Aprovado" else "Reprovado"
}

fun main() {
    val alunos = mutableListOf<Aluno>()
    val scanner = Scanner(System.`in`)

    while (true) {
        println("Menu de Opções:")
        println("1. Cadastrar registros")
        println("2. Pesquisar registro")
        println("3. Apresentar registros")
        println("4. Sair")
        print("Escolha uma opção: ")
        when (scanner.nextInt()) {
            1 -> cadastrarRegistros(alunos, scanner)
            2 -> pesquisarRegistro(alunos, scanner)
            3 -> apresentarRegistros(alunos)
            4 -> break
            else -> println("Opção inválida, tente novamente.")
        }
    }
}

fun cadastrarRegistros(alunos: MutableList<Aluno>, scanner: Scanner) {
    for (i in 1..20) {
        println("Cadastro ${i}:")
        print("Nome: ")
        val nome = scanner.next()
        val notas = mutableListOf<Double>()
        for (j in 1..4) {
            print("Nota ${j}: ")
            notas.add(scanner.nextDouble())
        }
        alunos.add(Aluno(nome, notas))
    }
    alunos.sortBy { it.nome }
    println("Registros cadastrados e classificados por nome.")
}

fun pesquisarRegistro(alunos: List<Aluno>, scanner: Scanner) {
    print("Digite o nome para pesquisa: ")
    val nome = scanner.next()
    val aluno = alunos.find { it.nome == nome }
    if (aluno != null) {
        println("Registro encontrado: $aluno")
        println("Média: ${aluno.media}")
        println("Status: ${aluno.status}")
    } else {
        println("Registro não encontrado.")
    }
}

fun apresentarRegistros(alunos: List<Aluno>) {
    println("Todos os registros:")
    alunos.forEach {
        println("Nome: ${it.nome}, Notas: ${it.notas}, Média: ${it.media}, Status: ${it.status}")
    }
}