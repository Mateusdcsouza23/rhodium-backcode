package rhoudim.com.br.rhodiumcode.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import rhoudim.com.br.rhodiumcode.entity.BatePonto
import rhoudim.com.br.rhodiumcode.entity.SolicitacaoCorrecao

@Repository
interface SolicitacaoCorrecaoRepository : JpaRepository<SolicitacaoCorrecao, Long> {
//    fun findByFuncionarioId(funcionarioId: Long): List<SolicitacaoCorrecao>
}
