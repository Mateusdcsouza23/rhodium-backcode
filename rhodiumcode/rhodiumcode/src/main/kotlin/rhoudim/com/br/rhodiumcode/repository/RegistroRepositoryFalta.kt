package rhoudim.com.br.rhodiumcode.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import rhoudim.com.br.rhodiumcode.entity.BatePonto
import java.time.LocalDate


@Repository
interface RegistroRepositoryFalta : JpaRepository<BatePonto, Long> {

//    @Query("""
//        SELECT b FROM BatePonto b WHERE b.fkFuncionario.idFuncionario = :fkFuncionarioId
//          AND (b.registroEntrada IS NULL OR b.registroSaida IS NULL)
//          AND b.dataB = :data
//    """)
//    fun findFaltasByFuncionarioAndData(
//            @Param("fkFuncionarioId") fkFuncionarioId: Long?,
//            @Param("data") data: LocalDate
//    ): List<BatePonto>
}
