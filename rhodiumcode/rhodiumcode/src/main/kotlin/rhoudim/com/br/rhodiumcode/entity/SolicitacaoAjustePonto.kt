package rhoudim.com.br.rhodiumcode.entity
import jakarta.persistence.*
import java.time.LocalDateTime

enum class StatusSolicitacao {
    PENDENTE, APROVADA, REJEITADA
}

enum class TipoCorrecao {
    ENTRADA, SAIDA
}

@Entity
@Table(name = "solicitacao_correcao")
data class SolicitacaoAjustePonto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    val funcionario: Funcionario,

    @Column(nullable = false)
    val dataSolicitacao: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    val tipoCorreção: TipoCorrecao, // Entrada ou Saída

    @Column(nullable = false)
    val motivo: String,

    @Column(nullable = true)
    val dataCorrecao: LocalDateTime? = null, // Data em que a correção foi realizada, se aplicável

    @Column(nullable = false)
    val descricao: String,

    @Column(nullable = false)
    var status: StatusSolicitacao = StatusSolicitacao.PENDENTE
)


