package rhoudim.com.br.rhodiumcode.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import rhoudim.com.br.rhodiumcode.entity.BatePonto
import java.time.LocalDate

@Repository
interface RegistroRepositorySaida : JpaRepository<BatePonto, Long> {

    @Query(
        """
     SELECT b FROM BatePonto b JOIN b.fkFuncionario f WHERE f.idFuncionario = ?1
    """
    )
    fun findByPontoIdFuncionario(idFuncionario: Long): List<BatePonto>?

    @Query("SELECT COUNT(bp) FROM BatePonto bp WHERE bp.fkFuncionario.idFuncionario = :fkFuncionarioId AND bp.dataB = :currentDate")
    fun countByFkFuncionarioAndDataB(
        @Param("fkFuncionarioId") fkFuncionarioId: Long,
        @Param("currentDate") currentDate: LocalDate
    ): Intv

    // Consulta para buscar os registros sem marcação de saída de um funcionário
    @Query(
            "SELECT bp FROM BatePonto bp WHERE bp.fkFuncionario.idFuncionario = :fkFuncionarioId AND bp.registroSaida IS NULL"
    )
    fun findRegistrosSemSaida(@Param("fkFuncionarioId") fkFuncionarioId: Long): List<BatePonto>

}
