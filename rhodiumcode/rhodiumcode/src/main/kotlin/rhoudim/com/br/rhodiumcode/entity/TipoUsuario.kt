package rhoudim.com.br.rhodiumcode.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "TipoUsuario")
class TipoUsuario(

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    var idTipo: Long? = null,
    var descricao:String? = null,
){}