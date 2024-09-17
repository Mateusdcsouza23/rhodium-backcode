package rhoudim.com.br.rhodiumcode.controller

import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import rhoudim.com.br.rhodiumcode.dtos.BatePontoDto
import rhoudim.com.br.rhodiumcode.dtos.BatePontoResponse
import rhoudim.com.br.rhodiumcode.dtos.BuscarPontoResponse
import rhoudim.com.br.rhodiumcode.entity.BatePonto
import rhoudim.com.br.rhodiumcode.repository.EmpresaRepository
import rhoudim.com.br.rhodiumcode.repository.FuncionarioRepository
import rhoudim.com.br.rhodiumcode.repository.RegistraPontoRepository
import rhoudim.com.br.rhodiumcode.service.FaltasService
import rhoudim.com.br.rhodiumcode.service.HorasExtrasService
import rhoudim.com.br.rhodiumcode.service.RegistraPontoService
import java.time.Duration
import java.time.LocalDate


@RestController
@RequestMapping("/ponto")
@CrossOrigin("*")
class BatePontoController {

    @Autowired
    lateinit var registraPontoService: RegistraPontoService;

    @Autowired
    lateinit var registraPontoRepository: RegistraPontoRepository

    @Autowired
    lateinit var empresaRepository: EmpresaRepository

    @Autowired
    lateinit var funcionarioRepository: FuncionarioRepository

    @Autowired
    lateinit var  horasExtrasService: HorasExtrasService

    @Autowired

    lateinit var  faltasService: FaltasService

    @PostMapping("/bater")
    fun registrarPonto(@RequestBody @Valid registroPonto:BatePontoDto): ResponseEntity<BatePontoResponse> {
        var fkEmpresa = empresaRepository.findById(registroPonto.fkEmpresa)
        var fkFuncionario = funcionarioRepository.findById(registroPonto.fkFuncionario)

        if (fkEmpresa.isEmpty || fkFuncionario.isEmpty) {
            return ResponseEntity.status(404).build()
        }
        val currentDate = LocalDate.now()
        val pointCount = registraPontoRepository.countByFkFuncionarioAndDataB(registroPonto.fkFuncionario, currentDate)

        if (pointCount >= 2) {
            return ResponseEntity.status(400).build();
        }

        if (pointCount == 1) {
            registroPonto.entrada = true;
            registroPonto.saida = false;
        } else {
            registroPonto.entrada = false;
            registroPonto.saida = true;
        }

        var cadastrarPonto = registraPontoRepository
            .save(BatePonto(registroPonto, fkFuncionario.get(), fkEmpresa.get()))

        val responseRegistroPonto = BatePontoResponse(
            cadastrarPonto.fkFuncionario?.nome,
            cadastrarPonto.fkEmpresa?.nomeEmpresa,
            cadastrarPonto.fkFuncionario?.email,
            cadastrarPonto.dataB,
            cadastrarPonto.hora,
            cadastrarPonto.fkFuncionario?.idFuncionario,
            cadastrarPonto.fkEmpresa?.idEmpresa,
        )

            return ResponseEntity.status(200).body(responseRegistroPonto)
    }


    @GetMapping("/{idFuncionario}")
    fun buscarPontosBatidos(@PathVariable idFuncionario:Long): ResponseEntity<List<BuscarPontoResponse>>{
        val buscarPontos = registraPontoRepository.findByPontoIdFuncionario(idFuncionario)
        if (buscarPontos !== null){
            val listaPontosMarcados = buscarPontos.map { ponto ->
                BuscarPontoResponse(
                    ponto.dataB,
                    ponto.hora,
                    ponto.entrada,
                    ponto.saida
                )
            }

        return  ResponseEntity.status(200).body(listaPontosMarcados)
        }
        return ResponseEntity.status(404).build()
    }

//    @GetMapping("/horasExtras/{idFuncionario}")
//    fun obterHorasExtras(@PathVariable idFuncionario: Long): ResponseEntity<Duration> {
//        val horasExtras = horasExtrasService.calcularHorasExtrasFuncionario(idFuncionario)
//        return ResponseEntity.ok(horasExtras)
//    }

//    @GetMapping("/horasExtras/departamento/{idDepartamento}")
//    fun obterHorasExtrasPorDepartamento(@PathVariable idDepartamento: Long): ResponseEntity<Map<String, Duration>> {
//        val horasExtras = horasExtrasService.findHorasExtrasByDepartamento(idDepartamento)
//        return ResponseEntity.ok(horasExtras)
//    }
//    @GetMapping("/faltas/departamento/{idDepartamento}")
//    fun obterFaltasPorDepartamento(
//            @PathVariable idDepartamento: Long,
//            @RequestParam data: LocalDate
//    ): ResponseEntity<Map<String, List<BatePonto>>> {
//        val faltas = faltasService.findFaltasByDepartamento(idDepartamento, data)
//        return ResponseEntity.ok(faltas)
//    }
//
//    @GetMapping("/faltas/hoje")
//    fun obterFaltasHoje(): ResponseEntity<Map<String, List<BatePonto>>> {
//        val faltas = faltasService.findAllFaltasHoje()
//        return ResponseEntity.ok(faltas)
//    }
}