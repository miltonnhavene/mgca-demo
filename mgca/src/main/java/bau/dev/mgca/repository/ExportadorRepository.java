package bau.dev.mgca.repository;

import bau.dev.mgca.entity.ExportadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExportadorRepository extends JpaRepository<ExportadorEntity, Long> {
}
