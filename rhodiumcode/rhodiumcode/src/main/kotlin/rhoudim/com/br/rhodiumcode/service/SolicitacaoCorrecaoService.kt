package rhoudim.com.br.rhodiumcode.service

import org.springframework.stereotype.Service
import rhoudim.com.br.rhodiumcode.entity.SolicitacaoCorrecao
import rhoudim.com.br.rhodiumcode.entity.Funcionario
import rhoudim.com.br.rhodiumcode.repository.SolicitacaoCorrecaoRepository

@Service
class SolicitacaoCorrecaoService(
        private val solicitacaoCorrecaoRepository: SolicitacaoCorrecaoRepository
) {

//    fun criarSolicitacaoCorrecao(funcionarioId: Long, tipoCorrecao: SolicitacaoCorrecao.TipoCorrecao, motivo: String): SolicitacaoCorrecao {
//        val solicitacao = SolicitacaoCorrecao(
//                funcionario = Funcionario(idFuncionario = funcionarioId),
//                tipoCorreção = tipoCorrecao,
//                motivo = motivo
//        )
//        return solicitacaoCorrecaoRepository.save(solicitacao)
//    }
//
//    fun obterSolicitacoesPorFuncionario(funcionarioId: Long): List<SolicitacaoCorrecao> {
//        return solicitacaoCorrecaoRepository.findByFuncionarioId(funcionarioId)
//    }
}