// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BÁSICO, INTERMEDIÁRIO, AVANÇADO }

class Usuario(val nome:String, val email:String)

data class ConteudoEducacional(var nome: String, var duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel:Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    
    fun listarInscritos(){
        for(usuario in inscritos){
            println("Nome: ${usuario.nome} || Email: ${usuario.email}")
        }
    }
    
    fun listarCursosFormacao(){
        for(conteudo in conteudos){
            var minToHour = conteudo.duracao / 60
            println("Nome do curso: ${conteudo.nome} || Duração: ${minToHour} horas")
		}
    }
}

fun main() { 
	val cursoLogica = ConteudoEducacional("Curso de Lógica de Programação", 180)
    val cursoKotlin = ConteudoEducacional("Curso de Kotlin", 300)
    val cursoJava = ConteudoEducacional("Curso de Java", 240)
    
	val listContEducacional = mutableListOf<ConteudoEducacional>()
    listContEducacional.add(cursoLogica)
    listContEducacional.add(cursoKotlin)
    listContEducacional.add(cursoJava)
    
    val joao = Usuario("João da Silva", "joaosilva@gmail.com")
    val ana = Usuario("Ana Reis", "anar@gmail.com")
    
    val formacaoAndroid = Formacao("Formação Android Nativo", listContEducacional, Nivel.INTERMEDIÁRIO)
    formacaoAndroid.matricular(joao)
    formacaoAndroid.matricular(ana)
    
    println("Formação")
    println("Nome: ${formacaoAndroid.nome} Nível: ${formacaoAndroid.nivel}")
    println()
    println("Cursos da Formação")
    println(formacaoAndroid.listarCursosFormacao())
    println()
	println("Alunos Incritos:")
    println(formacaoAndroid.listarInscritos())
}
