package rhoudim.com.br.rhodiumcode.controller

import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*
import rhoudim.com.br.rhodiumcode.dtos.FuncionarioResponse
import rhoudim.com.br.rhodiumcode.dtos.LoginDto
import rhoudim.com.br.rhodiumcode.dtos.JWTDto
import rhoudim.com.br.rhodiumcode.entity.Usuario
import rhoudim.com.br.rhodiumcode.infra.security.JwtConfig
import rhoudim.com.br.rhodiumcode.repository.FuncionarioRepository
import rhoudim.com.br.rhodiumcode.repository.UsuarioRepository
import java.lang.RuntimeException
import java.util.*

@RestController
@RequestMapping("/login")
@CrossOrigin("*")
class LoginController {

    @Autowired
    lateinit var funcionarioRepository:FuncionarioRepository

    @Autowired
    lateinit var usuarioRepository: UsuarioRepository

    @Autowired
    lateinit var jwtConfig:JwtConfig

//    @Autowired
//    lateinit var securityConfig: SecurityConfig

    @Autowired
    lateinit var manager: AuthenticationManager
    private val logger = LoggerFactory.getLogger(LoginController::class.java)

    @Autowired
    lateinit var passwordEncoder: PasswordEncoder


    @PostMapping
    fun loginUser(@RequestBody @Valid dadosLogin: LoginDto): ResponseEntity<FuncionarioResponse> {
        val usuario: Usuario = usuarioRepository.findByEmail(dadosLogin.email).orElseThrow { RuntimeException("Usuário não existe")}

        val token = UsernamePasswordAuthenticationToken(dadosLogin.email, dadosLogin.senha)
        val authentication = manager.authenticate(token)
        if (passwordEncoder.matches(dadosLogin.senha, usuario.senha)){
            val user = authentication.principal as Usuario
            val token:String = jwtConfig.gerarToken(user)

            val usuarioResponse = FuncionarioResponse(
                user.idFuncionario,
                user.email,
                user.nome,
                user.fkEmpresa,
                token
            )
            return ResponseEntity.status(200).body(usuarioResponse)
        }
        return ResponseEntity.status(400).build()

    }


}