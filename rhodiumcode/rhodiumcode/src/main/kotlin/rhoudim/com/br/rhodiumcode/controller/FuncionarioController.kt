package rhoudim.com.br.rhodiumcode.controller

import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rhoudim.com.br.rhodiumcode.dtos.FuncionarioDto
import rhoudim.com.br.rhodiumcode.entity.Funcionario
import rhoudim.com.br.rhodiumcode.repository.DepartamentoRepository
import rhoudim.com.br.rhodiumcode.repository.EmpresaRepository
import rhoudim.com.br.rhodiumcode.repository.FuncionarioRepository

@RestController
@RequestMapping("/cadastro")
class FuncionarioController {

    @Autowired
    lateinit var funcionarioRepository: FuncionarioRepository

    @Autowired
    lateinit var empresaRepository: EmpresaRepository

    @Autowired
    lateinit var departamentoRepository: DepartamentoRepository


    @PostMapping("/funcionarios")
    fun cadastrarFuncionarios(@Valid @RequestBody funcionarios: List<FuncionarioDto>): ResponseEntity<Any> {

        val listaFuncionarios = funcionarios.map { funcionario ->
            val empresa = empresaRepository.findById(funcionario.fkEmpresa).get()
            val departamento = departamentoRepository.findById(funcionario.fkDepartamento).get()
            Funcionario(
                idFuncionario = funcionario.idFuncionario,
                nome = funcionario.nome,
                email = funcionario.email,
                senha = funcionario.senha,
                cargo = funcionario.cargo,
                fkDepartamento = departamento,
                fkEmpresa = empresa
            )
        }

        funcionarioRepository.saveAll(listaFuncionarios)
        return ResponseEntity.status(201).build()
    }


}