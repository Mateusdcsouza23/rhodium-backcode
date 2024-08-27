package rhoudim.com.br.rhodiumcode.dtos

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class DepartamentoDto(

    @field:NotNull
    var idDepartamento:Long,

    @field:NotNull
    @field:NotBlank
    var nomeDepartamento:String,

    @field:NotNull
    @field: NotBlank
    var gestorResponsavel:String,

    @field:NotNull
    var fkEmpresa: Long


)
