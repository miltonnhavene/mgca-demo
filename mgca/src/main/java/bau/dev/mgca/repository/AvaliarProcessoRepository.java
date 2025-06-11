package bau.dev.mgca.repository;

import bau.dev.mgca.config.enums.Decisao;
import bau.dev.mgca.config.enums.Estado;
import bau.dev.mgca.entity.AvaliarProcessoEntity;
import bau.dev.mgca.entity.ExportadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AvaliarProcessoRepository  extends JpaRepository<AvaliarProcessoEntity, Long> {

    public long countByDecisao(Decisao decisao);
    public long countByEstado(Estado estado);
    public List<AvaliarProcessoEntity> findByEstado(Estado estado);
    @Query(value = """
    SELECT * FROM avaliar_processo ap
    JOIN processo_cadastro pc ON pc.id = ap.id_processo
    WHERE (CAST(:estado AS varchar) IS NULL OR ap.estado = :estado)
      AND (CAST(:dataInicio AS date) IS NULL OR pc.data_submissao >= :dataInicio)
      AND (CAST(:dataFim AS date) IS NULL OR pc.data_submissao <= :dataFim)
""", nativeQuery = true)
    List<AvaliarProcessoEntity> buscarPorFiltros(
            @Param("estado") Estado estado,
            @Param("dataInicio") LocalDate dataInicio,
            @Param("dataFim") LocalDate dataFim
    );



}
