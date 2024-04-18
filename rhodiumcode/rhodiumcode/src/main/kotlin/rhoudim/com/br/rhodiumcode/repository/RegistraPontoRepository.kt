package rhoudim.com.br.rhodiumcode.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import rhoudim.com.br.rhodiumcode.entity.BatePonto
import java.time.LocalDateTime

interface RegistraPontoRepository : JpaRepository<BatePonto, Long> {

//
//    @Query("SELECT bp FROM BatePonto bp WHERE bp.fkFuncionario = :idFuncionario AND bp.dataB BETWEEN :inicioDoDia AND :fimDoDia")
//    fun findByFkFuncionarioAndDataBBetween(
//        @Param("idFuncionario") idFuncionario: Long,
//        @Param("inicioDoDia") inicioDoDia: LocalDateTime,
//        @Param("fimDoDia") fimDoDia: LocalDateTime
//    ): List<BatePonto>


}