package rhoudim.com.br.rhodiumcode.entity

import jakarta.persistence.*

@Entity
data class Gestor(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,
        val nome: String,

        @OneToMany
        val liderados: List<Funcionario>,

        @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
        val listaSolicitacoes: MutableList<SolicitacaoAjustePonto> = mutableListOf()
)

