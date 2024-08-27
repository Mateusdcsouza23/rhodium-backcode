package rhoudim.com.br.rhodiumcode.dtos

import java.time.LocalDate
import java.time.LocalTime

data class BuscarPontoResponse(
    var dataB:LocalDate?,
    var hora: LocalTime?,
    var saida: Boolean?,
    var entrada:Boolean?
)
