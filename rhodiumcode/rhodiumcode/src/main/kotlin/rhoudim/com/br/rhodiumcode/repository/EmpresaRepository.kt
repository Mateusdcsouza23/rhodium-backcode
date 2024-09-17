package rhoudim.com.br.rhodiumcode.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import rhoudim.com.br.rhodiumcode.entity.Empresa

interface EmpresaRepository : JpaRepository<Empresa, Long> {
    @Query("""
        SELECT e FROM Empresa e WHERE e.nomeEmpresa LIKE %:empresa%
    """)
    fun findByEmpresa(empresa: String): List<Empresa>
}