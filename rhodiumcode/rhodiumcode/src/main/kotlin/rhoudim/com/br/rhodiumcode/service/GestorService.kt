package com.example.sistema.service

import rhoudim.com.br.rhodiumcode.entity.*
import rhoudim.com.br.rhodiumcode.repository.GestorRepository
import rhoudim.com.br.rhodiumcode.repository.FuncionarioRepository
import rhoudim.com.br.rhodiumcode.entity.SolicitacaoAjustePonto
import org.springframework.stereotype.Service


@Service
class GestorService(
        private val gestorRepository: GestorRepository,
        private val funcionarioRepository: FuncionarioRepository
) {

    fun adicionarSolicitacao(gestorId: Int, solicitacao: SolicitacaoAjustePonto) {
        val funcionario = funcionarioRepository.findById(solicitacao.funcionario.id)
                .orElseThrow { IllegalArgumentException("Funcionário não encontrado.") }

        val gestor = gestorRepository.findById(gestorId)
                .orElseThrow { IllegalArgumentException("Gestor não encontrado.") }

        if (gestor.liderados.contains(funcionario)) {
            gestor.listaSolicitacoes.add(solicitacao)
            gestorRepository.save(gestor)
        } else {
            throw IllegalArgumentException("Funcionário ${funcionario.nome} não é liderado por ${gestor.nome}.")
        }
    }

    fun aprovarSolicitacao(gestorId: Int, solicitacaoId: Int) {
        val gestor = gestorRepository.findById(gestorId)
                .orElseThrow { IllegalArgumentException("Gestor não encontrado.") }

        val solicitacao = gestor.listaSolicitacoes.find { it.id == solicitacaoId }
                ?: throw IllegalArgumentException("Solicitação não encontrada.")

        solicitacao.status = StatusSolicitacao.APROVADA
        gestorRepository.save(gestor)
    }

    fun rejeitarSolicitacao(gestorId: Int, solicitacaoId: Int) {
        val gestor = gestorRepository.findById(gestorId)
                .orElseThrow { IllegalArgumentException("Gestor não encontrado.") }

        val solicitacao = gestor.listaSolicitacoes.find { it.id == solicitacaoId }
                ?: throw IllegalArgumentException("Solicitação não encontrada.")

        solicitacao.status = StatusSolicitacao.REJEITADA
        gestorRepository.save(gestor)
    }

    fun verSolicitacoesPendentes(gestorId: Int): List<SolicitacaoAjustePonto> {
        val gestor = gestorRepository.findById(gestorId)
                .orElseThrow { IllegalArgumentException("Gestor não encontrado.") }

        return gestor.listaSolicitacoes.filter { it.status == StatusSolicitacao.PENDENTE }
    }
}

