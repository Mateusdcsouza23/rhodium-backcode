package rhoudim.com.br.rhodiumcode.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import rhoudim.com.br.rhodiumcode.dtos.BatePontoDto
import rhoudim.com.br.rhodiumcode.entity.BatePonto
import rhoudim.com.br.rhodiumcode.repository.RegistraPontoRepository
@Service
class HorasExtrasService(
        private val registroRepositorySaida: RegistroRepositorySaida
) {

    fun calcularHorasExtrasSemSaida(entrada: LocalDateTime): Duration {
        val horarioSaidaPadrao = LocalTime.of(18, 0)
        val saidaCalculada = entrada.toLocalDate().atTime(horarioSaidaPadrao)
        val jornadaNormal = Duration.ofHours(8)
        val horasTrabalhadas = Duration.between(entrada, saidaCalculada)
        return if (horasTrabalhadas > jornadaNormal) {
            horasTrabalhadas.minus(jornadaNormal)
        } else {
            Duration.ZERO
        }
    }

    fun calcularHorasExtrasFuncionario(idFuncionario: Long): Duration {
        val registrosSemSaida = registroRepositorySaida.findRegistrosSemSaida(idFuncionario)
        var totalHorasExtras = Duration.ZERO
        for (registro in registrosSemSaida) {
            val horasExtras = calcularHorasExtrasSemSaida(registro.registroEntrada)
            totalHorasExtras = totalHorasExtras.plus(horasExtras)
        }
        return totalHorasExtras
    }


    fun calcularHorasExtrasSemSaida(entrada: LocalDateTime): Duration {v
        val horarioSaidaPadrao = LocalTime.of(18, 0)
        val saidaCalculada = entrada.toLocalDate().atTime(horarioSaidaPadrao)
        val jornadaNormal = Duration.ofHours(8)
        val horasTrabalhadas = Duration.between(entrada, saidaCalculada)
        return if (horasTrabalhadas > jornadaNormal) {
            horasTrabalhadas.minus(jornadaNormal)
        } else {
            Duration.ZERO
        }
    }

    fun calcularHorasExtrasFuncionario(idFuncionario: Long): Duration {
        val registrosSemSaida = registroRepositorySaida.findRegistrosSemSaida(idFuncionario)
        var totalHorasExtras = Duration.ZERO
        for (registro in registrosSemSaida) {
            val horasExtras = calcularHorasExtrasSemSaida(registro.registroEntrada)
            totalHorasExtras = totalHorasExtras.plus(horasExtras)
        }
        return totalHorasExtras
    }
    fun findHorasExtrasByDepartamento(idDepartamento: Long): Map<String, Duration> {

        val funcionarios = departamentoRepository.findFuncionariosByDepartamento(idDepartamento)


        val horasExtrasPorFuncionario = mutableMapOf<String, Duration>()


        for (funcionario in funcionarios) {
            val registrosSemSaida = registroRepositorySaida.findRegistrosSemSaida(funcionario.idFuncionario)
            var totalHorasExtras = Duration.ZERO
            for (registro in registrosSemSaida) {
                val horasExtras = calcularHorasExtrasSemSaida(registro.registroEntrada)
                totalHorasExtras = totalHorasExtras.plus(horasExtras)
            }
            horasExtrasPorFuncionario[funcionario.nome] = totalHorasExtras
        }

        return horasExtrasPorFuncionario
    }
}