package rhoudim.com.br.rhodiumcode.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import rhoudim.com.br.rhodiumcode.dtos.BatePontoResponse
import rhoudim.com.br.rhodiumcode.entity.Departamento
import rhoudim.com.br.rhodiumcode.entity.Funcionario

@Repository
interface DepartamentoRepository : JpaRepository<Departamento, Long> {
//    @Query("""
//        SELECT f FROM Funcionario f JOIN f.fkDepartamento d WHERE d.idDepartamento = ?1
//    """)
//    fun findByDepartamentoId(idDepartamento: Long): List<Funcionario>?
//
//    @Query("""
//    SELECT BatePontoResponse(
//        f.nome, e.nomeEmpresa, f.email, bp.dataB, bp.hora
//    )
//    FROM BatePonto bp
//    JOIN bp.fkFuncionario f
//    JOIN f.fkDepartamento d
//    JOIN d.fkEmpresa e
//    WHERE d.idDepartamento = ?1
//""")
//    fun findBatidasDePontoByDepartamento(idDepartamento: Long): List<BatePontoResponse>?
//
//        @Query("""
//        SELECT f FROM Funcionario f WHERE f.fkDepartamento.idDepartamento = :idDepartamento
//    """)
//        fun findFuncionariosByDepartamento(@Param("idDepartamento") idDepartamento: Long): List<Funcionario>
    }
