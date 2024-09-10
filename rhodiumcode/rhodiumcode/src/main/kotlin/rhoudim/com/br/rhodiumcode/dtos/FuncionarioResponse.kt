package rhoudim.com.br.rhodiumcode.dtos

import rhoudim.com.br.rhodiumcode.entity.Empresa
import rhoudim.com.br.rhodiumcode.entity.Funcionario
import rhoudim.com.br.rhodiumcode.entity.TipoUsuario
import rhoudim.com.br.rhodiumcode.entity.Usuario

data class FuncionarioResponse(

    var idFuncionario:Long?,
    var email:String?,
    var nome:String?,
    var fkEmpresa: Empresa?,
    var fkTipoUsuario: TipoUsuario?,
//    var fkEmpresa: Int?,
    var token: String
){

    constructor(usuario: Usuario, fkEmpresa: Empresa?, fkTipoUsuario: TipoUsuario, token:String): this (
        usuario.idFuncionario,
        usuario.email,
        usuario.nome,
        fkEmpresa,
        fkTipoUsuario,
//        fkEmpresa,
        token
    )


}
