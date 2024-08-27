package rhoudim.com.br.rhodiumcode.infra.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Service
import rhoudim.com.br.rhodiumcode.entity.Usuario
import java.security.Key
import java.time.Duration
import java.time.Instant
import java.time.LocalDateTime
import java.util.*
import javax.crypto.SecretKey


@Service
class JwtConfig{
    private val secretKeyHex = "357638792F423F4428472B4B6250655368566D597133743677397A244326462922"

    private val key: SecretKey

    init {
        // Convertendo a chave hexadecimal para um array de bytes
        val keyBytes = Base64.getDecoder().decode(secretKeyHex)
        key = Keys.hmacShaKeyFor(keyBytes)
    }

    fun gerarToken(usuario: Usuario): String {
        val now = LocalDateTime.now()
        val expirationTime = Duration.between(now, now.plusHours(2)).seconds.toLong()

        return Jwts.builder()
            .setIssuer("rhodium-api")
            .setSubject(usuario.email)
            .setIssuedAt(Date.from(Instant.now()))
            .setExpiration(Date.from(Instant.now().plusSeconds(expirationTime)))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact()
    }

    fun getSubjectVerifyExp(tokenJwt: String?): String? {
        if (tokenJwt.isNullOrEmpty()) {
            throw IllegalArgumentException("Token JWT null ou vazio")
        }

        return try {
            val claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(tokenJwt)
                .body

            claims.subject
        } catch (exception: Exception) {
            throw IllegalArgumentException("Token JWT inválido ou expirado", exception)
        }
    }

//    private fun getSignKey(base64SecretKey: String = secretKey): Key? {
//        val keyBytes = Base64.getDecoder().decode(base64SecretKey)
//        println("loggers: ${Keys.hmacShaKeyFor(keyBytes)}")
//        return Keys.hmacShaKeyFor(keyBytes)
//    }

}