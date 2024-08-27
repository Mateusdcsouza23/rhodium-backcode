package rhoudim.com.br.rhodiumcode.dtos

import rhoudim.com.br.rhodiumcode.entity.BatePonto
import rhoudim.com.br.rhodiumcode.entity.Empresa
import rhoudim.com.br.rhodiumcode.entity.Funcionario
import java.time.LocalDate
import java.time.LocalTime

data class BatePontoResponse(

    var nome:String?,
    var nomeEmpresa:String?,
    var email:String?,
    var dataB:LocalDate?,
    var hora:LocalTime?,
    var fkEmpresa: Long?,
    var fkFuncionario: Long?,


)
