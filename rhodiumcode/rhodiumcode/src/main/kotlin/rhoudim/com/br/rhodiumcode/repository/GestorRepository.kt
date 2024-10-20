package rhoudim.com.br.rhodiumcode.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import rhoudim.com.br.rhodiumcode.entity.Funcionario
import rhoudim.com.br.rhodiumcode.entity.Usuario
import java.util.*

@Repository
interface GestorRepository : JpaRepository<Gestor, Int> {
    fun findByLideradosContains(funcionario: Funcionario): Gestor?
}