package rhoudim.com.br.rhodiumcode.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.security.core.userdetails.UserDetails
import rhoudim.com.br.rhodiumcode.entity.Usuario
import java.util.*

interface UsuarioRepository : JpaRepository<Usuario, Long> {

    fun findByEmailAndSenha(email:String, senha:String): Usuario

     fun findByEmail(email: String): Optional<Usuario>

}