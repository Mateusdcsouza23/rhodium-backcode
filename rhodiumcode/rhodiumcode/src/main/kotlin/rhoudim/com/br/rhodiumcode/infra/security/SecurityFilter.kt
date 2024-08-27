package rhoudim.com.br.rhodiumcode.infra.security

import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.springframework.web.filter.OncePerRequestFilter
import rhoudim.com.br.rhodiumcode.entity.Usuario
import rhoudim.com.br.rhodiumcode.repository.UsuarioRepository
import java.io.IOException
import java.util.*

@Service
class SecurityFilter : OncePerRequestFilter() {

    @Autowired
    lateinit var jwtSecurity: JwtConfig

    @Autowired
    lateinit var usuarioRepository: UsuarioRepository

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = recoverToken(request)
        if (token != null) {
            try {
                val login = jwtSecurity.getSubjectVerifyExp(token)
                if (login != null) {
                    logger.info("Token JWT válido para o usuário: $login")
//                    val authorities = Collections.singletonList(SimpleGrantedAuthority("ROLE_USER"))
                    val usuario = usuarioRepository.findByEmail(login).orElseThrow { RuntimeException("Usuário não existe") }
                    val authentication = UsernamePasswordAuthenticationToken(usuario, null, usuario.authorities)
                    SecurityContextHolder.getContext().authentication = authentication
                }
            } catch (e: Exception) {
                logger.error("Invalid or expired token: ${e.message}")
            }
        }
        filterChain.doFilter(request, response)
    }

    private fun recoverToken(request: HttpServletRequest): String? {
        val authHeader = request.getHeader("Authorization")
        return if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            null
        } else authHeader.replace("Bearer ", "")
    }
}
