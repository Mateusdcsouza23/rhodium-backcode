package rhoudim.com.br.rhodiumcode.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import rhoudim.com.br.rhodiumcode.dtos.BatePontoDto
import rhoudim.com.br.rhodiumcode.entity.BatePonto
import rhoudim.com.br.rhodiumcode.repository.RegistraPontoRepository

@Service
class FaltasService(
        private val departamentoRepository: DepartamentoRepository,
        private val registroRepositoryFalta: RegistroRepositoryFalta
) {

    fun findFaltasByDepartamento(idDepartamento: Long, data: LocalDate): Map<String, List<BatePonto>> {
        val funcionarios = departamentoRepository.findFuncionariosByDepartamento(idDepartamento)
        val faltasPorFuncionario = mutableMapOf<String, List<BatePonto>>()

        for (funcionario in funcionarios) {
            val faltas = registroRepositoryFalta.findFaltasByFuncionarioAndData(funcionario.idFuncionario, data)
            if (faltas.isNotEmpty()) {
                faltasPorFuncionario[funcionario.nome] = faltas
            }
        }

        return faltasPorFuncionario
    }

    fun findAllFaltasHoje(): Map<String, List<BatePonto>> {
        val hoje = LocalDate.now()

        // Obter todos os funcionários
        val funcionarios = funcionarioRepository.findAll()

        // Map para armazenar as faltas por funcionário
        val faltasPorFuncionario = mutableMapOf<String, List<BatePonto>>()

        // Iterar sobre cada funcionário e encontrar as faltas
        for (funcionario in funcionarios) {
            val faltas = registroRepositoryFalta.findFaltasByFuncionarioAndData(funcionario.idFuncionario, hoje)
            if (faltas.isNotEmpty()) {
                faltasPorFuncionario[funcionario.nome] = faltas
            }
        }

        return faltasPorFuncionario
    }
}