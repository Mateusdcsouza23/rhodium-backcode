package rhoudim.com.br.rhodiumcode.dtos

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class FuncionarioDto(

    @field:NotNull
    var idFuncionario:Long,

    @field:NotNull
    @field:NotBlank
    var nome:String,

    @field:NotNull
    @field:NotBlank
    var email:String,

    @field:NotNull
    @field:NotBlank
    var cargo:String,

    @field:NotNull
    @field:NotBlank
    var senha:String,


//    @field:NotNull
//    var fkDepartamento:Long,

    @field:NotNull
    var fkEmpresa:Long,

//    @field:NotNull
//    var fkPermissao:Long,

)
