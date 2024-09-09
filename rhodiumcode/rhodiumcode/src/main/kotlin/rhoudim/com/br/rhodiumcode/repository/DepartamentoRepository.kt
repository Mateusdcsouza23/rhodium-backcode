package rhoudim.com.br.rhodiumcode.repository

import org.springframework.data.jpa.repository.JpaRepository
import rhoudim.com.br.rhodiumcode.entity.Departamento

@Repository
interface DepartamentoRepository : JpaRepository<Departamento, Long> {
    @Query("""
        SELECT f FROM Funcionario f JOIN f.fkDepartamento d WHERE d.idDepartamento = ?1
    """)
    fun findByDepartamentoId(idDepartamento: Long): List<Funcionario>?v

    @Query("""
    SELECT BatePontoResponse(
        f.nome, e.nomeEmpresa, f.email, bp.dataB, bp.hora
    )
    FROM BatePonto bp
    JOIN bp.fkFuncionario f
    JOIN f.fkDepartamento d
    JOIN d.fkEmpresa e
    WHERE d.idDepartamento = ?1
""")
    fun findBatidasDePontoByDepartamento(idDepartamento: Long): List<BatePontoResponse>?

        @Query("""
        SELECT f FROM Funcionario f WHERE f.fkDepartamento.idDepartamento = :idDepartamento
    """)
        fun findFuncionariosByDepartamento(@Param("idDepartamento") idDepartamento: Long): List<Funcionario>
    }
}