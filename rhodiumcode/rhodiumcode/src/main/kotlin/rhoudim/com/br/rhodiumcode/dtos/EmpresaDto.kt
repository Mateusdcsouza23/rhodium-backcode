package rhoudim.com.br.rhodiumcode.dtos

import jakarta.validation.constraints.NotNull

data class EmpresaDto(

    @field:NotNull
    var idEmpresa:Long
)
