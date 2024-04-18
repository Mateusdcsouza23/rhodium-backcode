package rhoudim.com.br.rhodiumcode.controller

import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import rhoudim.com.br.rhodiumcode.dtos.BatePontoDto
import rhoudim.com.br.rhodiumcode.entity.BatePonto
import rhoudim.com.br.rhodiumcode.repository.EmpresaRepository
import rhoudim.com.br.rhodiumcode.repository.FuncionarioRepository
import rhoudim.com.br.rhodiumcode.repository.RegistraPontoRepository
import rhoudim.com.br.rhodiumcode.service.RegistraPontoService
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@RestController
@RequestMapping("/registro")
class BatePontoController {

    @Autowired
    lateinit var registraPontoService: RegistraPontoService;

    @Autowired
    lateinit var registraPontoRepository: RegistraPontoRepository

    @Autowired
    lateinit var empresaRepository: EmpresaRepository

    @Autowired
    lateinit var funcionarioRepository: FuncionarioRepository


    @PostMapping("/ponto")
    fun registrarPonto(@RequestBody @Valid registroPonto:BatePontoDto): ResponseEntity<BatePonto>{
        var fkEmpresa = empresaRepository.findById(registroPonto.fkEmpresa)
        var fkFuncionario = funcionarioRepository.findById(registroPonto.fkFuncionario)
        var cadastrarPonto = registraPontoRepository
            .save(BatePonto(registroPonto, fkFuncionario.get(), fkEmpresa.get()))

            return ResponseEntity.status(200).body(cadastrarPonto)
        }

    // endpoint pra retorna quantas horas foram trabalhadas em determinado dia!
//
//    @GetMapping("{idFuncionario}")
//    fun calcularHorasPonto(@PathVariable idFuncionario:Long, @RequestParam("data") data:LocalDate ): Duration {
//
//        val inicioDia = data.atStartOfDay()
//        val finalDia = data.atTime(LocalTime.MAX)
//
//        val batidasDePonto = registraPontoRepository.findByFkFuncionarioAndDataBBetween(idFuncionario, inicioDia, finalDia)
//
//        var duracaoTotal = Duration.ZERO
//        var ultimaBatida:LocalDateTime? = null
//
//        batidasDePonto.forEach { batida ->
//            if (ultimaBatida != null) {
//                val diferenca = Duration.between(ultimaBatida, LocalDateTime.of(batida.dataB, batida.hora))
//                duracaoTotal = duracaoTotal.plus(diferenca)
//            }
//            ultimaBatida = LocalDateTime.of(batida.dataB, batida.hora)
//        }
//
//        return duracaoTotal
//    }



}