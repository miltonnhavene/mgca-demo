package bau.dev.mgca.services.implementss;

import bau.dev.mgca.DTO.ExportadorDTO;
import bau.dev.mgca.entity.ExportadorEntity;
import bau.dev.mgca.repository.ExportadorRepository;
import bau.dev.mgca.services.ExportadorService;
import bau.dev.mgca.transform.ExportadorTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ExportadorServiceImpl implements ExportadorService {
    @Autowired
    private ExportadorRepository exportadorRepository;

    @Autowired
    private ExportadorTransform mapper;


    @Override
    public ExportadorDTO createExportador(ExportadorDTO exportadorDTO) {
        ExportadorEntity exportadorEntity = mapper.toEntity(exportadorDTO);
        ExportadorEntity savedExportador = exportadorRepository.save(exportadorEntity);
        return mapper.toDTO(savedExportador);
    }

    @Override
    public ExportadorDTO getExportadorById(Long id) {
        ExportadorEntity exportadorEntity = exportadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exportador não encontrado"));
        return mapper.toDTO(exportadorEntity);
    }

    @Override
    public ExportadorEntity updateExportador(Long id, ExportadorDTO dto) {
        return exportadorRepository.findById(id).map(exportadorEntity -> { exportadorEntity.setNomeEmpresa(dto.getNomeEmpresa());
            exportadorEntity.setNuit(dto.getNuit());
            exportadorEntity.setEmail(dto.getEmail());
            exportadorEntity.setNumeroAlvara(dto.getNumeroAlvara());
            exportadorEntity.setTipoExportador(dto.getTipoExportador());
            exportadorEntity.setNuel(dto.getNuel());
            exportadorEntity.setActividadeComercial(dto.getActividadeComercial());
            return exportadorRepository.save(exportadorEntity);
        }).orElseThrow(() -> new RuntimeException("Exportador não encontrado"));
    }

    @Override
    public void deleteExportador(Long id) {
        exportadorRepository.deleteById(id);
    }
}
