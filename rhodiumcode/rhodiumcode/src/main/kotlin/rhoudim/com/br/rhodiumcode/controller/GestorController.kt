package rhoudim.com.br.rhodiumcode.controller

import org.springframework.web.bind.annotation.*
import org.springframework.http.ResponseEntity
import rhoudim.com.br.rhodiumcode.service.SolicitacaoService
import rhoudim.com.br.rhodiumcode.entity.SolicitacaoAjustePonto

@RestController
@RequestMapping("/gestores")
class GestorController(private val gestorService: GestorService) {

    @PostMapping("/{gestorId}/solicitacoes")
    fun adicionarSolicitacao(
        @PathVariable gestorId: Int,
        @RequestBody solicitacao: SolicitacaoAjustePonto
    ): ResponseEntity<String> {
        return try {
            gestorService.adicionarSolicitacao(gestorId, solicitacao)
            ResponseEntity.ok("Solicitação de ajuste adicionada com sucesso.")
        } catch (e: IllegalArgumentException) {
            ResponseEntity.badRequest().body(e.message)
        }
    }

    @GetMapping("/{gestorId}/solicitacoes")
    fun verSolicitacoesPendentes(@PathVariable gestorId: Int): ResponseEntity<List<SolicitacaoAjustePonto>> {
        val solicitacoes = gestorService.verSolicitacoesPendentes(gestorId)
        return ResponseEntity.ok(solicitacoes)
    }

    @PostMapping("/{gestorId}/solicitacoes/aprovar")
    fun aprovarSolicitacao(@PathVariable gestorId: Int, @RequestBody solicitacao: SolicitacaoAjustePonto): ResponseEntity<String> {
        gestorService.aprovarSolicitacao(gestorId, solicitacao)
        return ResponseEntity.ok("Solicitação aprovada com sucesso.")
    }

    @PostMapping("/{gestorId}/solicitacoes/rejeitar")
    fun rejeitarSolicitacao(@PathVariable gestorId: Int, @RequestBody solicitacao: SolicitacaoAjustePonto): ResponseEntity<String> {
        gestorService.rejeitarSolicitacao(gestorId, solicitacao)
        return ResponseEntity.ok("Solicitação rejeitada com sucesso.")
    }

    @GetMapping("/por-funcionario/{funcionarioId}")
    fun obterGestorPorFuncionario(@PathVariable funcionarioId: Long): ResponseEntity<Gestor> {
        val funcionario = funcionarioRepository.findById(funcionarioId).orElseThrow {
            IllegalArgumentException("Funcionário não encontrado.")
        }

        val gestor = gestorService.obterGestorPorFuncionario(funcionario)
        return ResponseEntity.ok(gestor)
    }
}
