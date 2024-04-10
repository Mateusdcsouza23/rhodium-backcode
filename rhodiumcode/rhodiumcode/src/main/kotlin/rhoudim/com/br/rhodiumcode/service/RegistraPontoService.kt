package rhoudim.com.br.rhodiumcode.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import rhoudim.com.br.rhodiumcode.dtos.RegistraPontoDto
import rhoudim.com.br.rhodiumcode.entity.RegistraPonto
import rhoudim.com.br.rhodiumcode.repository.RegistraPontoRepository

class RegistraPontoService {


    @Autowired
    lateinit var registraPontoRepository:RegistraPontoRepository

    fun registroPontoInicio(registroPonto:RegistraPontoDto): ResponseEntity<RegistraPonto>{
        var registroPontoUsuario =  registraPontoRepository.save(RegistraPonto(registroPonto))
        return ResponseEntity.status(200).body(registroPontoUsuario)
    }





}