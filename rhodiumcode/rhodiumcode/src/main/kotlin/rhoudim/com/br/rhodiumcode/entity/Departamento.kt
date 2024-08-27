package rhoudim.com.br.rhodiumcode.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import rhoudim.com.br.rhodiumcode.dtos.DepartamentoDto

@Entity(name = "Departamento")
@Table(name = "Departamentos")
class Departamento(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idDepartamento: Long? = null,
    var nomeDepartamento:String? = null,
    var gestorResponsavel:String? = null,

   @ManyToOne
   @JoinColumn(name = "fk_empresa" , referencedColumnName = "idEmpresa")
    var fkEmpresa:Empresa? = null
) {


    constructor(departamento: DepartamentoDto, fkEmpresa: Empresa): this (
        departamento.idDepartamento,
        departamento.nomeDepartamento,
        departamento.gestorResponsavel,
        fkEmpresa
    )

}