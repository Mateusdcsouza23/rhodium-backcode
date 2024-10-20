package rhoudim.com.br.rhodiumcode.service

import org.springframework.stereotype.Service
import rhoudim.com.br.rhodiumcode.repository.SolicitacaoCorrecaoRepository
import rhoudim.com.br.rhodiumcode.repository.FuncionarioRepository
import rhoudim.com.br.rhodiumcode.repository.GestorRepository
import rhoudim.com.br.rhodiumcode.entity.SolicitacaoAjustePonto

@Service
class SolicitacaoService(
        private val gestorRepository: GestorRepository,
        private val funcionarioRepository: FuncionarioRepository
) {

    fun obterSolicitacoesPendentesPorGestor(gestorId: Int): List<SolicitacaoAjustePonto> {
        val gestor = gestorRepository.obterGestorPorId(gestorId)
                ?: throw IllegalArgumentException("Gestor não encontrado.")
        return gestor.verSolicitacoesPendentes()
    }

    fun aprovarSolicitacao(gestorId: Int, solicitacaoId: Int) {
        val gestor = gestorRepository.obterGestorPorId(gestorId)
                ?: throw IllegalArgumentException("Gestor não encontrado.")
        val solicitacao = gestor.listaSolicitacoes.find { it.id == solicitacaoId }
                ?: throw IllegalArgumentException("Solicitação não encontrada.")
        gestor.aprovarSolicitacao(solicitacao)
    }

    fun rejeitarSolicitacao(gestorId: Int, solicitacaoId: Int) {
        val gestor = gestorRepository.obterGestorPorId(gestorId)
                ?: throw IllegalArgumentException("Gestor não encontrado.")
        val solicitacao = gestor.listaSolicitacoes.find { it.id == solicitacaoId }
                ?: throw IllegalArgumentException("Solicitação não encontrada.")
        gestor.rejeitarSolicitacao(solicitacao)
    }

    fun solicitarAjustePonto(colaboradorId: Int, descricao: String) {
        val colaborador = funcionarioRepository.obterColaboradorPorId(colaboradorId)
                ?: throw IllegalArgumentException("Colaborador não encontrado.")
        val gestor = gestorRepository.obterGestorPorColaborador(colaborador)
                ?: throw IllegalArgumentException("Nenhum gestor encontrado para o colaborador.")

        val novaSolicitacao = SolicitacaoAjustePonto(
                id = (gestor.listaSolicitacoes.size + 1),
                colaborador = colaborador,
                descricao = descricao
        )
        gestor.adicionarSolicitacao(novaSolicitacao)
    }
}