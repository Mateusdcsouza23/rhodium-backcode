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
    fun solicitarAjustePonto(funcionarioId: Int, descricao: String) {
        val funcionario = funcionarioRepository.findById(funcionarioId).orElseThrow {
            IllegalArgumentException("Funcionário não encontrado.")
        }

        val gestor = gestorService.obterGestorPorFuncionario(funcionarioId).orElseThrow {
            IllegalArgumentException("Nenhum gestor encontrado para o funcionário.")
        }

        val novaSolicitacao = SolicitacaoAjustePonto(
            id = (gestor.listaSolicitacoes.size + 1),
            funcionario = funcionario,
            descricao = descricao
        )

        gestor.adicionarSolicitacao(novaSolicitacao)
    }

    fun buscarFuncionarioPorId(funcionarioId: Int): Funcionario {
        return funcionarioRepository.findById(funcionarioId)
                .orElseThrow { IllegalArgumentException("Funcionário não encontrado.") }
    }

    fun listarTodosFuncionarios(): List<Funcionario> {
        return funcionarioRepository.findAll().toList()
    }
}


