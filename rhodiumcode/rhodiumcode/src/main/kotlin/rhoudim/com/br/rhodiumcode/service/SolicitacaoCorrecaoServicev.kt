package rhoudim.com.br.rhodiumcode.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import rhoudim.com.br.rhodiumcode.dtos.BatePontoDto
import rhoudim.com.br.rhodiumcode.entity.BatePonto
import rhoudim.com.br.rhodiumcode.repository.RegistraPontoRepository

@Service
class SolicitacaoCorrecaoService(
        private val solicitacaoCorrecaoRepository: SolicitacaoCorrecaoRepository
) {

    fun criarSolicitacaoCorrecao(funcionarioId: Long, tipoCorrecao: TipoCorrecao, motivo: String): SolicitacaoCorrecao {
        val solicitacao = SolicitacaoCorrecao(
                funcionario = Funcionario(id = funcionarioId),
                tipoCorreção = tipoCorrecao,
                motivo = motivo
        )
        return solicitacaoCorrecaoRepository.save(solicitacao)
    }

    fun obterSolicitacoesPorFuncionario(funcionarioId: Long): List<SolicitacaoCorrecao> {
        return solicitacaoCorrecaoRepository.findByFuncionarioId(funcionarioId)
    }
}