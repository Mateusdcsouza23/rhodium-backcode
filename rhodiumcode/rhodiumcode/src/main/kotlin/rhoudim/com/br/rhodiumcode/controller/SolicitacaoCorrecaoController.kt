package rhoudim.com.br.rhodiumcode.controller

import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rhoudim.com.br.rhodiumcode.dtos.EmpresaDto
import rhoudim.com.br.rhodiumcode.entity.Empresa
import rhoudim.com.br.rhodiumcode.repository.EmpresaRepository

@RestController
@RequestMapping("/api/solicitacao-correcao")
class SolicitacaoCorrecaoController(
        private val solicitacaoCorrecaoService: SolicitacaoCorrecaoService
) {

    @PostMapping
    fun criarSolicitacaoCorrecao(
            @RequestParam funcionarioId: Long,
            @RequestParam tipoCorrecao: TipoCorrecao,
            @RequestParam motivo: String
    ): ResponseEntity<SolicitacaoCorrecao> {
        val solicitacao = solicitacaoCorrecaoService.criarSolicitacaoCorrecao(funcionarioId, tipoCorrecao, motivo)
        return ResponseEntity.ok(solicitacao)
    }

    @GetMapping("/funcionario/{funcionarioId}")
    fun obterSolicitacoesPorFuncionario(@PathVariable funcionarioId: Long): ResponseEntity<List<SolicitacaoCorrecao>> {
        val solicitacoes = solicitacaoCorrecaoService.obterSolicitacoesPorFuncionario(funcionarioId)
        return ResponseEntity.ok(solicitacoes)
    }
}