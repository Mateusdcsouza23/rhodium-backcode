package rhoudim.com.br.rhodiumcode.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import rhoudim.com.br.rhodiumcode.dtos.RegistraPontoDto
import java.time.LocalDateTime

@Entity(name = "RegistraPonto")
@Table(name = "dPonto")
class RegistraPonto(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var dCodPonto: Long? = null,

    @ManyToOne
    @JoinColumn(name= "dCodU", referencedColumnName = "dCodU")
    var dCodU: Int? = null,

    var dataHora:LocalDateTime = LocalDateTime.now(),
    var dStartBatida:LocalDateTime? = null,
    var dFinishBatida: LocalDateTime? = null

) {

    constructor(registraPonto:RegistraPontoDto): this(
        registraPonto.dCodPonto,
        registraPonto.dCodU,
        registraPonto.dStartBatida,
        registraPonto.dFinishBatida
        )


}