package rhoudim.com.br.rhodiumcode.controller

import org.springframework.web.bind.annotation.*
import rhoudim.com.br.rhodiumcode.service.FuncionarioService
import rhoudim.com.br.rhodiumcode.entity.SolicitacaoAjustePonto.kt

@RestController
@RequestMapping("/gestores")
class SolicitacaoController(val funcionarioService: FuncionarioService) {

    @PostMapping("/{colaboradorId}/solicitar-ajuste")
    fun solicitarAjuste(@PathVariable funcionarioId: Int, @RequestBody descricao: String): ResponseEntity<String> {
        funcionarioService.solicitarAjustePonto(funcionarioId, descricao)
        return ResponseEntity.ok("Solicitação de ajuste enviada com sucesso.")
    }
}
