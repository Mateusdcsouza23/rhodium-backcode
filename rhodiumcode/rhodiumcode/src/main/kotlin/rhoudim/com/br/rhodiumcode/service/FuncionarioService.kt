package com.example.sistema.service

import rhoudim.com.br.rhodiumcode.entity.Funcionario
import rhoudim.com.br.rhodiumcode.repository.FuncionarioRepository
import rhoudim.com.br.rhodiumcode.repository.GestorRepository
import rhoudim.com.br.rhodiumcode.repository.SolicitacaoCorrecaoRepository
import org.springframework.stereotype.Service

@Service
class FuncionarioService(
        private val funcionarioRepository: FuncionarioRepository,
        private val gestorRepository: GestorRepository
        private val solicitacaoRepository: SolicitacaoCorrecaoRepository
) {

    private var contadorSolicitacoes: Int = 0

    fun solicitarAjuste(funcionarioId: Int, descricao: String) {

        val funcionario = funcionarioRepository.findById(funcionarioId)
                .orElseThrow { Exception("Funcionário não encontrado") }


        val novaSolicitacao = SolicitacaoAjustePonto(
                id = ++contadorSolicitacoes, // Incrementar contador para gerar ID único
                colaborador = funcionario,
                descricao = descricao
        )


        val gestor = gestorRepository.obterGestorPorColaborador(funcionario)
                ?: throw Exception("Gestor não encontrado para o funcionário ${funcionario.nome}.")

        gestor.adicionarSolicitacao(novaSolicitacao)


        solicitacaoRepository.save(novaSolicitacao)

        println("Solicitação de ajuste enviada com sucesso pelo funcionário ${funcionario.nome}.")
    }
    fun buscarFuncionarioPorId(funcionarioId: Int): Funcionario {
        return funcionarioRepository.findById(funcionarioId)
                .orElseThrow { IllegalArgumentException("Funcionário não encontrado.") }
    }

    fun listarTodosFuncionarios(): List<Funcionario> {
        return funcionarioRepository.findAll().toList()
    }
}


