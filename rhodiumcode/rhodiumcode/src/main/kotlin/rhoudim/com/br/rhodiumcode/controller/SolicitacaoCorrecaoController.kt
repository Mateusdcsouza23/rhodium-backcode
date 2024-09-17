package rhoudim.com.br.rhodiumcode.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import rhoudim.com.br.rhodiumcode.entity.SolicitacaoCorrecao
import rhoudim.com.br.rhodiumcode.service.SolicitacaoCorrecaoService

@RestController
@RequestMapping("/api/solicitacao-correcao")
class SolicitacaoCorrecaoController(
        private val solicitacaoCorrecaoService: SolicitacaoCorrecaoService
) {

//    @PostMapping
//    fun criarSolicitacaoCorrecao(
//        @RequestParam funcionarioId: Long,
//        @RequestParam tipoCorrecao: SolicitacaoCorrecao.TipoCorrecao,
//        @RequestParam motivo: String
//    ): ResponseEntity<SolicitacaoCorrecao> {
//        val solicitacao = solicitacaoCorrecaoService.criarSolicitacaoCorrecao(funcionarioId, tipoCorrecao, motivo)
//        return ResponseEntity.ok(solicitacao)
//    }
//
//    @GetMapping("/funcionario/{funcionarioId}")
//    fun obterSolicitacoesPorFuncionario(@PathVariable funcionarioId: Long): ResponseEntity<List<SolicitacaoCorrecao>> {
//        val solicitacoes = solicitacaoCorrecaoService.obterSolicitacoesPorFuncionario(funcionarioId)
//        return ResponseEntity.ok(solicitacoes)
//    }
}