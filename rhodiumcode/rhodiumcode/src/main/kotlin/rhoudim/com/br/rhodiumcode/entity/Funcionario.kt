package rhoudim.com.br.rhodiumcode.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import rhoudim.com.br.rhodiumcode.dtos.FuncionarioDto

@Entity(name = "Funcionario")
@Table(name = "Funcionarios")
class Funcionario(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idFuncionario:Long? = null,
    var nome:String? = null,
    var email:String? = null,
    var cargo:String? = null,

    @ManyToOne
    @JoinColumn(name = "fk_departamento", referencedColumnName = "idDepartamento")
    var fkDepartamento: Departamento? = null,


    @ManyToOne
    @JoinColumn(name = "fk_empresa", referencedColumnName = "idEmpresa")
    var fkEmpresa: Empresa? = null,

//    @ManyToOne
//    @JoinColumn(name = "fk_permissao", referencedColumnName = "IDPermissao")
//    var fkPermissoes:Permissoes

){
        constructor(funcionario: FuncionarioDto, fkDepartamento: Departamento, fkEmpresa: Empresa) : this(
            funcionario.idFuncionario,
            funcionario.nome,
            funcionario.email,
            funcionario.cargo,
            fkDepartamento,
            fkEmpresa,
    )

}
