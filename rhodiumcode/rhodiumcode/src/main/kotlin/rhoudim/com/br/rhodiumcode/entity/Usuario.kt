package rhoudim.com.br.rhodiumcode.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import rhoudim.com.br.rhodiumcode.dtos.UsuarioDto

@Entity
class Usuario(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idCodU:Long? = null,
    var dNome:String? = null,
    var dCargo:String? = null,

    @ManyToOne
    @JoinColumn(name = "chavePerm", referencedColumnName = "dCodPermissao")
    var chavePerm: Long,


    @ManyToOne
    @JoinColumn(name = "chaveEmp", referencedColumnName = "dCodEmp")
    var chaveEmp: Long,

){
    constructor(usuarioDto: UsuarioDto) : this(
        usuarioDto.dCodU,
        usuarioDto.dNome,
        usuarioDto.dCargo,
        usuarioDto.chavPerm,
        usuarioDto.chaveEmp
    )
}
