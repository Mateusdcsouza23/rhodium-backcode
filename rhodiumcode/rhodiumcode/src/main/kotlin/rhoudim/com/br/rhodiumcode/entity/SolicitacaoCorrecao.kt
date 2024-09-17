package rhoudim.com.br.rhodiumcode.entity
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "solicitacao_correcao")
class SolicitacaoCorrecao(
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
    val dataCorrecao: LocalDateTime? = null // Data em que a correção foi realizada, se aplicável
) {
enum class TipoCorrecao {
    ENTRADA, SAIDA
}
}


