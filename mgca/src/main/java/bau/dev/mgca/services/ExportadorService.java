package bau.dev.mgca.services;

import bau.dev.mgca.DTO.ExportadorDTO;
import bau.dev.mgca.transform.ExportadorTransform;

public interface ExportadorService {
    String createExportador(ExportadorDTO exportadorDTO);
}
