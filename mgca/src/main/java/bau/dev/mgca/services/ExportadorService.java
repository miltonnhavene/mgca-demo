package bau.dev.mgca.services;

import bau.dev.mgca.DTO.ExportadorDTO;
import bau.dev.mgca.entity.ExportadorEntity;

import java.util.List;
import java.util.Optional;

public interface ExportadorService {
    ExportadorDTO createExportador(ExportadorDTO exportadorDTO);
    ExportadorDTO getExportadorById(Long id);
    ExportadorEntity updateExportador(Long id, ExportadorDTO dto);
    void deleteExportador(Long id);
}
