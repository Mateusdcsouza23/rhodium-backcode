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
@RequestMapping("/empresa")
class EmpresaController {

    @Autowired
    lateinit var empresaRepository: EmpresaRepository

    @PostMapping("/cadastro")
    fun cadastrarEmpresa(@Valid @RequestBody empresa:EmpresaDto): ResponseEntity<Empresa> {
        var registroEmpresa = empresaRepository.save(Empresa(empresa))
        return ResponseEntity.status(201).body(registroEmpresa)
    }
}