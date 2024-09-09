package rhoudim.com.br.rhodiumcode.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import rhoudim.com.br.rhodiumcode.entity.BatePonto
import java.time.LocalDa

@Repository
interface SolicitacaoCorrecaoRepository : JpaRepository<SolicitacaoCorrecao, Long> {
    fun findByFuncionarioId(funcionarioId: Long): List<SolicitacaoCorrecao>
}
