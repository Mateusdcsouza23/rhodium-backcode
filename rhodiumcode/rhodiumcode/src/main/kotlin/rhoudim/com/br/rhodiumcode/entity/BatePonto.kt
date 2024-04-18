package rhoudim.com.br.rhodiumcode.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import rhoudim.com.br.rhodiumcode.dtos.BatePontoDto
import java.time.LocalDate
import java.time.LocalTime

@Entity(name = "BatePonto")
@Table(name = "BatidasDePonto")
class BatePonto(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var IDBatida: Long? = null,

    @ManyToOne
    @JoinColumn(name= "fk_funcionario", referencedColumnName = "idFuncionario")
    var fkFuncionario: Funcionario,


    @ManyToOne
    @JoinColumn(name= "fk_empresa", referencedColumnName = "idEmpresa")
    var fkEmpresa: Empresa,

    var dataB:LocalDate? = LocalDate.now(),
    var hora: LocalTime? = LocalTime.now()

) {

    constructor(registraPonto:BatePontoDto, fkFuncionario:Funcionario, fkEmpresa:Empresa): this(
        registraPonto.IDBatida,
        fkFuncionario,
        fkEmpresa
        )


}