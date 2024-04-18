package rhoudim.com.br.rhodiumcode.repository

import org.springframework.data.jpa.repository.JpaRepository
import rhoudim.com.br.rhodiumcode.entity.Funcionario

interface FuncionarioRepository : JpaRepository<Funcionario, Long> {
}