package rhoudim.com.br.rhodiumcode.dtos

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class EmpresaDto(

    @field:NotNull
    var idEmpresa:Long,

    @field:NotNull
    @field: NotBlank
    var nomeEmpresa:String,

    @field:NotNull
    @field: NotBlank
    var endereco:String,

    @field:NotNull
    @field: NotBlank
    var segmento:String,

    @field:NotNull
    @field:NotBlank
    @field:Email
    var emailCorporativo:String,

    @field:NotNull
    @field:NotBlank
    var telefone:String,





)
