package rhoudim.com.br.rhodiumcode.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import rhoudim.com.br.rhodiumcode.entity.Funcionario
import rhoudim.com.br.rhodiumcode.entity.Usuario
import java.util.*

interface FuncionarioRepository : JpaRepository<Funcionario, Long> {

    fun findByEmailAndSenha(email:String, senha:String): Funcionario
     fun save(listaFuncionarios: List<Funcionario>)

}