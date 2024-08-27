package rhoudim.com.br.rhodiumcode.dtos

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class LoginDto(


    @field:NotNull
    @field:NotBlank
    @field:Email
    var email: String,


    @field:NotBlank
    var senha:String

)
