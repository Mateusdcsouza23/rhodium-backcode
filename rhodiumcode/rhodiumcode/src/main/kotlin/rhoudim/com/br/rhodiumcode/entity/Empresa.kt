package rhoudim.com.br.rhodiumcode.entity

import jakarta.persistence.*
import rhoudim.com.br.rhodiumcode.dtos.EmpresaDto

@Entity(name = "Empresa")
@Table(name = "Empresas")
class Empresa(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idEmpresa: Long? = null,
    var nomeEmpresa:String? = null,
//    var endereco:String? = null,
    var segmento:String? = null,
    var emailCorporativo:String? = null,
    var telefone:String? = null,
    var cnpj: String? = null,
) {

    constructor(empresa:EmpresaDto): this(
        empresa.idEmpresa,
        empresa.nomeEmpresa,
//        empresa.endereco,
        empresa.segmento,
        empresa.emailCorporativo,
        empresa.telefone,
        empresa.cnpj
    )

}