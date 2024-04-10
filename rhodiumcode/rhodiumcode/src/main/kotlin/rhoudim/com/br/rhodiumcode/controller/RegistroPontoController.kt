package rhoudim.com.br.rhodiumcode.controller

import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rhoudim.com.br.rhodiumcode.dtos.RegistraPontoDto
import rhoudim.com.br.rhodiumcode.entity.RegistraPonto
import rhoudim.com.br.rhodiumcode.service.RegistraPontoService

@RestController
@RequestMapping("/registro")
class RegistroPontoController {

    @Autowired
    lateinit var registraPontoService: RegistraPontoService;


    @PostMapping("/ponto")
    fun registrarPonto(@Valid @RequestBody registroPonto:RegistraPontoDto): ResponseEntity<RegistraPonto>{

    val cadastrarRegistroPonto = registraPontoService.registroPontoInicio(registroPonto)

        if (cadastrarRegistroPonto.statusCode === HttpStatus.CREATED ){
            return cadastrarRegistroPonto
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
        }
    }
}