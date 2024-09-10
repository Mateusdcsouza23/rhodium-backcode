package rhoudim.com.br.rhodiumcode.entity

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.List

@Entity(name = "Usuario")
@Table(name = "Funcionario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
class Usuario (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idFuncionario:Long? = null,
    var email:String? = null,
    var senha:String? = null,
    var nome:String? = null,
    @ManyToOne
    @JoinColumn(name = "fk_empresa", referencedColumnName = "idEmpresa")
    var fkEmpresa: Empresa? = null,
    @ManyToOne
    @JoinColumn(name = "fk_tipo_usuario", referencedColumnName = "idTipo")
    var fkTipoUsuario: TipoUsuario? = null,
) : UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority?> {
        return listOf(SimpleGrantedAuthority("ROLE_USER"))
    }

    override fun getPassword(): String? {
        return senha
    }

    override fun getUsername(): String? {
        return email
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}