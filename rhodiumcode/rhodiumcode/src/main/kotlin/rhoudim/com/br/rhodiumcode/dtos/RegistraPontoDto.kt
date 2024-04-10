package rhoudim.com.br.rhodiumcode.dtos

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDate
import java.time.LocalDateTime

data class RegistraPontoDto(

    @field:NotNull
    var dCodPonto:Long?,

    @field:NotNull
    var dCodU:Int,

//    @NotBlank
//    @NotNull
//    var dataHora: LocalDateTime = LocalDateTime.now(),

    @field:NotBlank
    @field:NotNull
    var dStartBatida:LocalDateTime,

    @field:NotBlank
    @field:NotNull
    var dFinishBatida:LocalDateTime
)
