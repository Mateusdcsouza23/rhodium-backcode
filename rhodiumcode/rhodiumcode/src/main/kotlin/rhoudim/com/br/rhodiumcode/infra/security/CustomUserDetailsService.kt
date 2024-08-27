package rhoudim.com.br.rhodiumcode.infra.security

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component
import rhoudim.com.br.rhodiumcode.entity.Usuario
import rhoudim.com.br.rhodiumcode.repository.UsuarioRepository
import java.lang.RuntimeException


@Component
class CustomUserDetailsService : UserDetailsService {

    private val logger = LoggerFactory.getLogger(CustomUserDetailsService::class.java)

    @Autowired
    lateinit var usuarioRepository: UsuarioRepository

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val usuario: Usuario =  usuarioRepository.findByEmail(username).orElseThrow { RuntimeException("Usuário não existe") }
        return usuario
    }

}