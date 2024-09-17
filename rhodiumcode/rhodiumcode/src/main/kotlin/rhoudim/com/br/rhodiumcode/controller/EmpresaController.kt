package rhoudim.com.br.rhodiumcode.controller

import jakarta.validation.Valid
import org.apache.coyote.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import rhoudim.com.br.rhodiumcode.dtos.EmpresaDto
import rhoudim.com.br.rhodiumcode.entity.Empresa
import rhoudim.com.br.rhodiumcode.repository.EmpresaRepository

@RestController
@RequestMapping("/empresa")
@CrossOrigin("*")
class EmpresaController {

    @Autowired
    lateinit var empresaRepository: EmpresaRepository

    @PostMapping("/cadastro")
    fun cadastrarEmpresa(@Valid @RequestBody empresa:EmpresaDto): ResponseEntity<Empresa> {
        var registroEmpresa = empresaRepository.save(Empresa(empresa))
        return ResponseEntity.status(201).body(registroEmpresa)
    }

    @GetMapping("/{empresa}")
    fun buscarEmpresa(@PathVariable empresa: String): ResponseEntity<List<Empresa>>{
     var buscarEmpresa = empresaRepository.findByEmpresa(empresa)
       if (buscarEmpresa.isEmpty()){
           return ResponseEntity.status(204).build()
       }
           return ResponseEntity.status(200).body(buscarEmpresa)
    }
}