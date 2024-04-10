package rhoudim.com.br.rhodiumcode.dtos

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class UsuarioDto(
    @field:NotNull
    var dCodU:Long,

    @field:NotNull
    @field:NotBlank
    var dNome:String,

    @field:NotNull
    @field:NotBlank
    var dCargo:String,


    @field:NotNull
    var chavPerm:Long,

    @field:NotNull
    var chaveEmp:Long,

)
