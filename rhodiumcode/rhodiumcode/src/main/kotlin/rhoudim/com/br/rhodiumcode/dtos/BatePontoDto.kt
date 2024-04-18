package rhoudim.com.br.rhodiumcode.dtos

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDate
import java.time.LocalTime

data class BatePontoDto(

//    @field:NotNull
    var IDBatida:Long?,

    @field:NotNull
    var fkFuncionario:Long,

    @field:NotNull
    var fkEmpresa:Long,

//    @field:NotBlank
//    @field:NotNull
//    var dataB:LocalDate,
//
//    @field:NotBlank
//    @field:NotNull
//    var hora:LocalTime
)
