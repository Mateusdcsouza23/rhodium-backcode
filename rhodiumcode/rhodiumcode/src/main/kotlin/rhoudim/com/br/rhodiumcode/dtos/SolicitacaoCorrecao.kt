package rhoudim.com.br.rhodiumcode.dtos

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDate
import java.time.LocalTime

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "solicitacao_correcao")
data class SolicitacaoCorrecao(

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
)

enum class TipoCorrecao {
    ENTRADA, SAIDA
}

