package rhoudim.com.br.rhodiumcode.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
@Entity(name = "Permissoes")
class Permissoes(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idPermissao: Long? = null,
    var permissaoEditarPonto: Byte? = null,
    var permissaoAprovarPonto :Byte? = null,
    var permissaoVisualizarRelatorios: Byte? = null,

    @ManyToOne
    @JoinColumn(name = "fk_funcionario", referencedColumnName = "idFuncionario")
    var fkFuncionario:Funcionario

) {
}