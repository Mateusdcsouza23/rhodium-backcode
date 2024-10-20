package rhoudim.com.br.rhodiumcode.controller

import org.springframework.web.bind.annotation.*
import rhoudim.com.br.rhodiumcode.service.SolicitacaoService
import rhoudim.com.br.rhodiumcode.entity.SolicitacaoService

@RestController
@RequestMapping("/gestores")
class SolicitacaoController(val solicitacaoService: SolicitacaoService) {

    @PostMapping("/{colaboradorId}/solicitar-ajuste")
    fun solicitarAjuste(@PathVariable colaboradorId: Int, @RequestBody descricao: String): ResponseEntity<String> {
        colaboradorService.solicitarAjuste(colaboradorId, descricao)
        return ResponseEntity.ok("Solicitação de ajuste enviada com sucesso.")
    }
}
