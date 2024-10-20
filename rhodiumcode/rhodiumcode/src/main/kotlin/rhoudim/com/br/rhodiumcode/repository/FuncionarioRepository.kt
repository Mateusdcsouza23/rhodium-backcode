package rhoudim.com.br.rhodiumcode.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import rhoudim.com.br.rhodiumcode.entity.Funcionario
import rhoudim.com.br.rhodiumcode.entity.Usuario
import java.util.*
import org.springframework.data.repository.CrudRepository

@Repository
interface FuncionarioRepository : JpaRepository<Funcionario, Long> {

    fun findByEmailAndSenha(email:String, senha:String): Funcionario
    fun save(listaFuncionarios: List<Funcionario>)
    fun findByNome(nome: String): List<Funcionario>
    fun findAllByGestorId(gestorId: Int): List<Funcionario>
    override fun findById(funcionarioId: Int): Optional<Funcionario>
}