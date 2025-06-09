package bau.dev.mgca.repository;

import bau.dev.mgca.config.enums.Estado;
import bau.dev.mgca.entity.AvaliarProcessoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import bau.dev.mgca.config.enums.Estado;

public interface AvaliarProcessoRepository  extends JpaRepository<AvaliarProcessoEntity, Long> {

public long countByEstado(Estado estado);
}
